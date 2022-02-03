package es.danielgaspar.ppbs.repositoy;

import org.springframework.data.repository.CrudRepository;

import es.danielgaspar.ppbs.entity.EcommerceEntity;

public interface EcommerceRepository extends CrudRepository<EcommerceEntity, Integer> {

}
