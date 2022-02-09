package es.danielgaspar.ppbs.repositoy;


import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.danielgaspar.ppbs.Swagger2SpringBoot;
import es.danielgaspar.ppbs.entity.EcommerceEntity;
import es.danielgaspar.ppbs.entity.PaymentEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Swagger2SpringBoot.class)
public class PaymentRepositortyTest {

	@Autowired
	PaymentRepository repository;

	@Autowired
	EcommerceRepository ecommerceRepository;

	@Test	 
	public void testFindByDate() {
		
		//Create Ecommerce
		EcommerceEntity ecommerce = new EcommerceEntity();
		ecommerce.setName("Test Ecommerce");
		ecommerceRepository.save(ecommerce);
		
		//Create 
		repository.save(new PaymentEntity("Payment 1", LocalDate.now(), 100d, ecommerce));
		repository.save(new PaymentEntity("Payment 2", LocalDate.of(2022, 2, 15 ), 100d, ecommerce));
		repository.save(new PaymentEntity("Payment 2", LocalDate.of(2022, 1, 1), 100d, ecommerce));
		
		LocalDate now = LocalDate.now();
		LocalDate firstDay = now.with(TemporalAdjusters.firstDayOfMonth());
		LocalDate lastDay = now.with(TemporalAdjusters.lastDayOfMonth());
		
		
		Assert.assertEquals(2 , repository.findByDateBetweenAndEcommerce(firstDay, lastDay, ecommerce).size());
	} 
	

	

	
	
}
