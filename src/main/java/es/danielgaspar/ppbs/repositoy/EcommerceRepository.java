package es.danielgaspar.ppbs.repositoy;

import org.springframework.data.repository.CrudRepository;

import es.danielgaspar.ppbs.entity.EcommerceEntity;

public interface EcommerceRepository extends CrudRepository<EcommerceEntity, Integer> {
	
	/*public void report(Integer idEccomerce, Integer idMounth) {
		
		List<Object[]> results = entityManager.createQuery("SELECT m.name AS name, COUNT(m) AS total FROM Man AS m GROUP BY m.name ORDER BY m.name ASC");
		        .getResultList();
		for (Object[] result : results) {
		    String name = (String) result[0];
		    int count = ((Number) result[1]).intValue();
		}
		
	}*/

}
