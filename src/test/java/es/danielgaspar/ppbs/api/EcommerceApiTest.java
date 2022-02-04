package es.danielgaspar.ppbs.api;


import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.danielgaspar.ppbs.Swagger2SpringBoot;
import es.danielgaspar.ppbs.model.Ecommerce;
import es.danielgaspar.ppbs.model.EcommerceDetail;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Swagger2SpringBoot.class)
public class EcommerceApiTest {

	@Autowired
	EcommerceApi ecommerceApi;


	@Test	 
	public void testGetFindAll() {
		
		String name = "Test getFindAll";
		Ecommerce ecomerce = new Ecommerce();
		ecomerce.setName(name);
		
		this.ecommerceApi.createEcommerce(ecomerce);
		
		Assert.assertTrue(this.ecommerceApi.getAllEcommerce().getBody().size() > 0);
	} 
	
	@Test 
	public void testCreateEcommerce() {
		
		String name = "Test createEcommerce";
		Ecommerce ecomerce = new Ecommerce();
		ecomerce.setName(name);
		
		
		Assert.assertEquals(name, this.ecommerceApi.createEcommerce(ecomerce).getBody().getName());
	} 
	
	
	@Test 
	public void testGetEcommerce() {
		
		String name = "Test getFindAll";
		Ecommerce ecomerce = new Ecommerce();
		ecomerce.setName(name);
		
		EcommerceDetail ecomerceDetail = this.ecommerceApi.createEcommerce(ecomerce).getBody();
		
		
		Assert.assertEquals(ecomerceDetail.getId(), this.ecommerceApi.getEcommerce(ecomerceDetail.getId()).getBody().getId());
		
	} 
	
	
	@Test 
	public void testDeleteEcommerce() {
		
		String name = "Test getFindAll";
		Ecommerce ecomerce = new Ecommerce();
		ecomerce.setName(name);
		
		EcommerceDetail ecomerceDetail = this.ecommerceApi.createEcommerce(ecomerce).getBody();
		
		
		Assert.assertEquals(ecomerceDetail.getId(), this.ecommerceApi.deleteEcommerce(ecomerceDetail.getId()).getBody().getId());
		
	} 
	
	
	@Test 
	public void testUpdateEcommerce() {
		
		String name = "Test getFindAll";
		Ecommerce ecomerce = new Ecommerce();
		ecomerce.setName(name);
		
		EcommerceDetail ecomerceDetail = this.ecommerceApi.createEcommerce(ecomerce).getBody();
		
		String nameUpdate = "Name update";
		ecomerce.setName(nameUpdate);
		
		
		
		Assert.assertEquals(nameUpdate, this.ecommerceApi.updateEcommerce(ecomerceDetail.getId(), ecomerce).getBody().getName());
		
	} 
	
	

	
	
}
