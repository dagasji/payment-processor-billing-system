package es.danielgaspar.ppbs.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.danielgaspar.ppbs.entity.AcquirerPlusPricingEntity;
import es.danielgaspar.ppbs.entity.EcommerceEntity;
import es.danielgaspar.ppbs.entity.PaymentEntity;
import es.danielgaspar.ppbs.entity.PaymentProcessorEntity;
import es.danielgaspar.ppbs.model.EcommerceDetail;
import es.danielgaspar.ppbs.model.EcommerceReport;
import es.danielgaspar.ppbs.model.Payment;
import es.danielgaspar.ppbs.model.Transactions;
import es.danielgaspar.ppbs.repositoy.PaymentRepository;
import es.danielgaspar.ppbs.utils.ReportUtils;

@Service
public class EcommerceServiceImpl extends GeneralServiceImpl<EcommerceEntity, EcommerceDetail> 
	implements EcommerceService{
	
    private static final Logger log = LoggerFactory.getLogger(EcommerceServiceImpl.class);
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	protected EcommerceDetail entityToModel(EcommerceEntity entity) {
		
		EcommerceDetail model = null; 
		
		if (entity != null) {
			
			model = new EcommerceDetail();
			
			model.setId(entity.getId());
			model.setName(entity.getName());		
			
			if(entity.getPaymentProcessor() != null) {
				model.setIdPaymentProcessor(entity.getPaymentProcessor().getId());				
			}
		}

		return model;
	}

	@Override
	protected List<EcommerceDetail> listEntityToModel(List<EcommerceEntity> listEntity) {
		
		List<EcommerceDetail> listEcomerceModel = null;
		
		if (listEntity != null) {
			
			listEcomerceModel = new ArrayList<EcommerceDetail>();
		
			for (EcommerceEntity ecommerceEntity : listEntity) {
				
				listEcomerceModel.add(entityToModel(ecommerceEntity));
			}
		
		}
		
		return listEcomerceModel;
	}

	@Override
	protected EcommerceEntity modelToEntity(EcommerceDetail model) {
		
		EcommerceEntity entity = null;
		
		if (model != null) {
			entity = new EcommerceEntity(model.getId(), model.getName());

			
			if (model.getIdPaymentProcessor() != null) {
				PaymentProcessorEntity paymentProcessor = new PaymentProcessorEntity(model.getIdPaymentProcessor());				
				entity.setPaymentProcessor(paymentProcessor);
			}
		}

		return entity;
	}

	@Override
	public void createPayment(Integer idEcommerce, Payment payment) {
		
		this.paymentRepository.save(this.paymentModelToEntity(idEcommerce, payment));
		
	}
	
	/**
	 * Parse object Payment to PaymentEntity
	 * @param idEcommerce id ecommerce
	 * @param payment detail of the payment
	 * @return
	 */
	private PaymentEntity paymentModelToEntity(Integer idEcommerce, Payment payment) {
		
		PaymentEntity entity = null;
		if(payment != null) {
			entity = new PaymentEntity();
			entity.setAmount(payment.getAmount());
			entity.setDescription(payment.getDescription());
			
			
			if (payment.getDate() != null) {
				org.threeten.bp.LocalDate date = payment.getDate();
				entity.setDate(LocalDate.of(date.getYear(), date.getMonthValue(), date.getDayOfMonth()));
			}
			
			if (idEcommerce != null) {
				EcommerceEntity ecommerce = new EcommerceEntity(idEcommerce);
				entity.setEcommerce(ecommerce);
			}
			
		}
		
		return entity;
	}


	/**
	 * Generate de ecommerce report monthly
	 * @param idEcommerce id ecommerce
	 * @param year report year
	 * @param month report month
	 * @return EcommerceReport
	 */
	public EcommerceReport ecommerceReport(Integer idEcommerce, Integer year, Integer month) {
		
		//Get Ecommerce
		EcommerceEntity ecommerce = this.getRepo().findOne(idEcommerce);
		
		EcommerceReport report = new EcommerceReport();
		report.setEcommerceName(ecommerce.getName());
		report.setPaymentProcessorName(ecommerce.getPaymentProcessor().getName());
		report.setListTransactions(this.listTransactionReport(ecommerce, year, month));
				
		LocalDate date = LocalDate.of(year, month, 1);	
		String displayMonth = date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		report.setMonth(displayMonth + " " + year);
		
		return report;
		
		
	}
	
	/**
	 * Get de transaction report 
	 * @return
	 */
	private List<Transactions> listTransactionReport(EcommerceEntity ecommerce, Integer year, Integer month ) {
		
		List<Transactions> listTransactions = null;
		
		LocalDate firstDay = LocalDate.of(year, month, 1);		
		LocalDate lastDay = firstDay.with(TemporalAdjusters.lastDayOfMonth());
		
		//get list payment in the month/year/ecommerce
		List<PaymentEntity> list = paymentRepository.findByDateBetweenAndEcommerce(
				firstDay, lastDay, ecommerce);
		
		log.debug("ecommerceReport. List payment found: ", list.size());
		
		if (list.size() > 0) {
			
			listTransactions = new ArrayList<Transactions>();
			
			List<AcquirerPlusPricingEntity> listApp = ecommerce.getPaymentProcessor().getListApp();
			
			//Group by day
			Map<Integer, List<PaymentEntity>> mapGroupByDay = list.stream()
			        .collect(Collectors.groupingBy(d -> d.getDate().getDayOfMonth()));
			
			log.debug("ecommerceReport. List group found: ", mapGroupByDay.size());
			
			Transactions transaction = null;
			
			for (Integer day : mapGroupByDay.keySet()) {
				
				List<PaymentEntity> listDay = mapGroupByDay.get(day);
				
				Integer numTransactions = listDay.size();
				
				//Get the correct app to apply
				AcquirerPlusPricingEntity app = ReportUtils.calculateApp(numTransactions, listApp);
				
				//sum amount
				Double amountTotal = listDay.stream().mapToDouble(o->o.getAmount()).sum(); 
				
				//Calculate the total amount + tax
				Double totalWithTax = amountTotal + 
						(amountTotal * app.getApp() / 100) + 
						(ecommerce.getPaymentProcessor().getFlatfee() * numTransactions) ;
				
				log.info("Day: " + day + " totalAmount: " + totalWithTax);
				
				//Create de object transaction for the report
				transaction = new Transactions();
				transaction.setDay(day.toString());
				transaction.setTransactions(numTransactions);
				transaction.setAmount(totalWithTax);
				listTransactions.add(transaction);
				
			}
		
		}
		
		return listTransactions;
		
	}
	
}
