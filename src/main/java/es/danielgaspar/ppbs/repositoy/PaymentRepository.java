package es.danielgaspar.ppbs.repositoy;

import org.springframework.data.repository.CrudRepository;

import es.danielgaspar.ppbs.entity.PaymentEntity;

public interface PaymentRepository extends CrudRepository<PaymentEntity, Integer> {

}
