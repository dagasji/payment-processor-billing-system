package es.danielgaspar.ppbs.service;

import es.danielgaspar.ppbs.entity.PaymentProcessorEntity;
import es.danielgaspar.ppbs.model.PaymentProcessor;
import es.danielgaspar.ppbs.model.PaymentProcessorDetail;
import es.danielgaspar.ppbs.model.PaymentProcessorReport;

public interface PaymentProcessorService extends GeneralService<PaymentProcessorEntity, PaymentProcessorDetail>{
	
	
	

	public PaymentProcessorReport report(Integer id);
	
}
