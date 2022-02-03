package es.danielgaspar.ppbs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import es.danielgaspar.ppbs.entity.EcommerceEntity;
import es.danielgaspar.ppbs.entity.PaymentProcessorEntity;
import es.danielgaspar.ppbs.model.EcommerceDetail;

@Service
public class EcommerceServiceImpl extends GeneralServiceImpl<EcommerceEntity, EcommerceDetail> 
	implements EcommerceService{

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
		
		EcommerceEntity entity = new EcommerceEntity();
		
		if (model != null) {
			entity.setId(model.getId());
			entity.setName(model.getName());
			
			if (model.getIdPaymentProcessor() != null) {
				PaymentProcessorEntity paymentProcessor = new PaymentProcessorEntity();
				paymentProcessor.setId(model.getIdPaymentProcessor());
				entity.setPaymentProcessor(paymentProcessor);
			}
		}

		return entity;
	}



	
}
