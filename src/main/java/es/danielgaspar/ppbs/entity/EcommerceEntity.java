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
@Table(name="ECOMMERCE")
public class EcommerceEntity {
	
	public EcommerceEntity() {
		super();
	}


	public EcommerceEntity(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public EcommerceEntity(Integer id) {
		super();
		this.id = id;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ECOMMERCE")
	private Integer id;


	@Column(name="NAME")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "ID_PAYMENT_PROCESSOR")
	private PaymentProcessorEntity paymentProcessor;


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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}




}
