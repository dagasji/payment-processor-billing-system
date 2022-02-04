package es.danielgaspar.ppbs.service;

import es.danielgaspar.ppbs.entity.EcommerceEntity;
import es.danielgaspar.ppbs.model.EcommerceDetail;
import es.danielgaspar.ppbs.model.EcommerceReport;
import es.danielgaspar.ppbs.model.Payment;

public interface EcommerceService extends GeneralService<EcommerceEntity, EcommerceDetail>{
	
	public void createPayment(Integer idEcommerce, Payment payment);
	
	/**
	 * Generate de ecommerce report monthly
	 * @param idEcommerce id ecommerce
	 * @param year report year
	 * @param month report month
	 * @return EcommerceReport
	 */
	public EcommerceReport ecommerceReport(Integer idEcommerce, Integer year, Integer month);

}
