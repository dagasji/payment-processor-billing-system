package es.danielgaspar.ppbs.service;

import es.danielgaspar.ppbs.entity.EcommerceEntity;
import es.danielgaspar.ppbs.model.EcommerceDetail;
import es.danielgaspar.ppbs.model.Payment;

public interface EcommerceService extends GeneralService<EcommerceEntity, EcommerceDetail>{
	
	public void createPayment(Integer idEcommerce, Payment payment);

}
