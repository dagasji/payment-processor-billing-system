package es.danielgaspar.ppbs.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PAYMENT_PROCESSOR")
public class PaymentProcessorEntity {
	
	public PaymentProcessorEntity() { 
		super();
	}
	
	public PaymentProcessorEntity(Integer id) {
		super();
		this.id = id;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PAYMENT_PROCESSOR")
	private Integer id;
	

	@Column(name="NAME")
	private String name;
	
	@Column(name="FLAT_FEE")
	private Float flatfee;
	
	@OneToMany(mappedBy = "paymentProcessor")
	private List<EcommerceEntity> listEntity;
	
	@OneToMany(mappedBy = "paymentProcessor", cascade = CascadeType.ALL, orphanRemoval = true)    
	private List<AcquirerPlusPricingEntity> listApp;


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

	public Float getFlatfee() {
		return flatfee;
	}

	public void setFlatfee(Float flatfee) {
		this.flatfee = flatfee;
	}

	public List<EcommerceEntity> getListEntity() {
		return listEntity;
	}

	public void setListEntity(List<EcommerceEntity> listEntity) {
		this.listEntity = listEntity;
	}

	public List<AcquirerPlusPricingEntity> getListApp() {
		return listApp;
	}

	public void setListApp(List<AcquirerPlusPricingEntity> listApp) {
		this.listApp = listApp;
	}

}
