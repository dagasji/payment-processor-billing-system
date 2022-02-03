package es.danielgaspar.ppbs.service;

import java.util.List;

/**
 * General Service
 * 
 * @author dagasji
 */
public interface GeneralService<E, M> {

	M findById(Integer id);
	
	List<M> findAll(); 

	M update(M entity);

	M create(M entity);
	
	M delete(Integer id);
}
