package es.danielgaspar.ppbs.repositoy;

import org.springframework.data.repository.CrudRepository;

import es.danielgaspar.ppbs.entity.PaymentProcessorEntity;

public interface PaymentProcessorRepository extends CrudRepository<PaymentProcessorEntity, Integer> {

}
