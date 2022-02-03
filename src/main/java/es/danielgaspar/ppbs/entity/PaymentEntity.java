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
@Table(name="PAYMENT")
public class PaymentEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PAYMENT")
	private Integer id;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="amount")
	private Double amount;	
	
	
	@ManyToOne
	@JoinColumn(name = "ID_ECOMMERCE")
	private EcommerceEntity ecommerce;



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Double getAmount() {
		return amount;
	}



	public void setAmount(Double amount) {
		this.amount = amount;
	}



	public EcommerceEntity getEcommerce() {
		return ecommerce;
	}



	public void setEcommerce(EcommerceEntity ecommerce) {
		this.ecommerce = ecommerce;
	}
	


}
