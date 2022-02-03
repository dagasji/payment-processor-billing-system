package es.danielgaspar.ppbs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.danielgaspar.ppbs.entity.AcquirerPlusPricingEntity;
import es.danielgaspar.ppbs.entity.PaymentProcessorEntity;
import es.danielgaspar.ppbs.model.APP;
import es.danielgaspar.ppbs.model.PaymentProcessorDetail;
import es.danielgaspar.ppbs.repositoy.PaymentRepository;

@Service
public class PaymentProcessorServiceImpl extends GeneralServiceImpl<PaymentProcessorEntity, PaymentProcessorDetail>	
	implements PaymentProcessorService{
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	protected PaymentProcessorDetail entityToModel(PaymentProcessorEntity entity) {
		
		PaymentProcessorDetail model = null; 
		
		if (entity != null) {
			
			model = new PaymentProcessorDetail();
			
			model.setId(entity.getId());
			model.setName(entity.getName());		
			model.setFlatfee(entity.getFlatfee());		
			
			if(entity.getListApp() != null && entity.getListApp().size() > 0) {
				
				
				List<APP> listAppModel = new ArrayList<APP>();
				
				for (AcquirerPlusPricingEntity app : entity.getListApp()) {
					APP appModel = new APP();
					appModel.setApp(app.getApp());
					appModel.setVolumen(app.getVolumen());
					listAppModel.add(appModel);
				}
				
				model.setListAPP(listAppModel);
								
			}
		}

		return model;
	}

	@Override
	protected List<PaymentProcessorDetail> listEntityToModel(List<PaymentProcessorEntity> listEntity) {
		
		return null;
	}

	@Override
	protected PaymentProcessorEntity modelToEntity(PaymentProcessorDetail model) {
		
		PaymentProcessorEntity entity = null; 
		
		if (model != null) {
			
			entity = new PaymentProcessorEntity();
			
			entity.setId(model.getId());
			entity.setName(model.getName());		
			entity.setFlatfee(model.getFlatfee());		
			
			if(model.getListAPP() != null && model.getListAPP().size() > 0) {
				
				List<AcquirerPlusPricingEntity> listAppEntity = new ArrayList<AcquirerPlusPricingEntity>();
				
				for (APP app : model.getListAPP()) {
					AcquirerPlusPricingEntity appEntity = new AcquirerPlusPricingEntity();
					appEntity.setApp(app.getApp());
					appEntity.setVolumen(app.getVolumen());
					appEntity.setPaymentProcessor(entity);
					listAppEntity.add(appEntity);
				}
				
				entity.setListApp(listAppEntity);
								
			}
		}

		return entity;
	}

	
}
