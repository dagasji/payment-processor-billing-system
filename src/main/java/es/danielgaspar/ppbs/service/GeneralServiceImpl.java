package es.danielgaspar.ppbs.service;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
/**
 * 
 * @author Dani
 *
 * @param <E> Model object
 * @param <T> Entity object
 * 
 */
@Service
public abstract class GeneralServiceImpl<E, M> implements GeneralService<E, M>{
	
	private static final Logger logger = LoggerFactory.getLogger(GeneralServiceImpl.class);
	
	@Autowired
	private CrudRepository<E, Integer> repo;	
	
	
	protected abstract M entityToModel(E entity);
	
	protected abstract List<M> listEntityToModel(List<E> listEntity);
	
	protected abstract E modelToEntity(M model);
	
	

	public M findById(Integer id) {
		E result = repo.findOne(id);
		
		M entity = this.entityToModel(result);
		
		return entity;
	}


	@Override
	public List<M> findAll() {
		List<E> list = IterableUtils.toList(repo.findAll());
		
		List<M> listaDTO = this.listEntityToModel(list);
		
		return listaDTO;
	}	

	@Override
	public M update(M dto) {
		
		E entity = this.modelToEntity(dto);
		entity = this.repo.save(entity);
		
		logger.info("[" + this.getClass() + "] " + "update entity " + entity.toString());
		
		M modelResponse = this.entityToModel(entity); 
		
		return modelResponse;
		
	}

	@Override
	public M create(M dto) {
		
		E entity = this.modelToEntity(dto);
		entity = this.repo.save(entity);
		
		logger.info("[" + this.getClass() + "] " + "create entity " + entity.toString());
		
		M modelResponse = this.entityToModel(entity); 
		
		return modelResponse;
		
	}

	@Override
	public M delete(Integer id) {
		
		M modelResponse = this.findById(id);
		
		this.repo.delete(id);
		
		logger.info("[" + this.getClass() + "] " + "delete entity " + id);
		
		return modelResponse;
	}

	public CrudRepository<E, Integer> getRepo() {
		return repo;
	}

	public void setRepo(CrudRepository<E, Integer> repo) {
		this.repo = repo;
	}
}
