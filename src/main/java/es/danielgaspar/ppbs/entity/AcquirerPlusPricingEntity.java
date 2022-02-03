package es.danielgaspar.ppbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ACQUIRER_PLUS_PRICING")
public class AcquirerPlusPricingEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ACQUIRER_PLUS_PRICING")
	private Integer id;
	

	@Column(name="volumen")
	private Integer volumen;
	
	@Column(name="APP")
	private Float app;
	
	@ManyToOne
	@JoinColumn(name = "ID_PAYMENT_PROCESSOR")
	private PaymentProcessorEntity paymentProcessor;
	

	public Integer getVolumen() {
		return volumen;
	}


	public void setVolumen(Integer volumen) {
		this.volumen = volumen;
	}


	public Float getApp() {
		return app;
	}


	public void setApp(Float app) {
		this.app = app;
	}


	public PaymentProcessorEntity getPaymentProcessor() {
		return paymentProcessor;
	}


	public void setPaymentProcessor(PaymentProcessorEntity paymentProcessor) {
		this.paymentProcessor = paymentProcessor;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


}
