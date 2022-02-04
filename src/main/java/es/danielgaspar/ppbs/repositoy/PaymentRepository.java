package es.danielgaspar.ppbs.repositoy;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.danielgaspar.ppbs.entity.EcommerceEntity;
import es.danielgaspar.ppbs.entity.PaymentEntity;

public interface PaymentRepository extends CrudRepository<PaymentEntity, Integer> {
	
	List<PaymentEntity> findByDateBetweenAndEcommerce(LocalDate dateInit,
			LocalDate dateEnd, EcommerceEntity ecommerce);
	
	List<PaymentEntity> findByEcommerce(EcommerceEntity ecommerce);

}
