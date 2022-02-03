package es.danielgaspar.ppbs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.danielgaspar.ppbs.entity.EcommerceEntity;
import es.danielgaspar.ppbs.entity.PaymentEntity;
import es.danielgaspar.ppbs.entity.PaymentProcessorEntity;
import es.danielgaspar.ppbs.model.EcommerceDetail;
import es.danielgaspar.ppbs.model.Payment;
import es.danielgaspar.ppbs.repositoy.PaymentRepository;

@Service
public class EcommerceServiceImpl extends GeneralServiceImpl<EcommerceEntity, EcommerceDetail> 
	implements EcommerceService{
	
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
			
			if (idEcommerce != null) {
				EcommerceEntity ecommerce = new EcommerceEntity(idEcommerce);
				entity.setEcommerce(ecommerce);
			}
			
		}
		
		return entity;
	}



	
}
