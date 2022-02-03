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
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PAYMENT_PROCESSOR")
	private Integer id;
	

	@Column(name="NAME")
	private String name;
	
	@Column(name="FLAT_FEE")
	private String flatfee;
	
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


}
