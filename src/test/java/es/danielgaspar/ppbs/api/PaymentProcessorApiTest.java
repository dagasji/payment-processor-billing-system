package es.danielgaspar.ppbs.api;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.danielgaspar.ppbs.Swagger2SpringBoot;
import es.danielgaspar.ppbs.model.APP;
import es.danielgaspar.ppbs.model.PaymentProcessor;
import es.danielgaspar.ppbs.model.PaymentProcessorDetail;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Swagger2SpringBoot.class)
@Transactional
public class PaymentProcessorApiTest {

	@Autowired
	PaymentprocessorApi paymentProcessorApi;


	
	@Test 
	public void testCreatePaymentProcessor() {
		
		String name = "Test CCPP1";
		PaymentProcessor paymentProcessor = new PaymentProcessor();
		paymentProcessor.setFlatfee(2f);
		paymentProcessor.setName(name);
		
		Assert.assertEquals(name, this.paymentProcessorApi.createPaymentProcessor(paymentProcessor).getBody().getName());
	} 
	
	
	@Test 
	public void testGetEcommerce() {
		
		String name = "Test testGetEcommerce";
		PaymentProcessor paymentProcessor = new PaymentProcessor();
		paymentProcessor.setFlatfee(2f);
		paymentProcessor.setName(name);
		
		List<APP> listAPP = new ArrayList<APP>();
		APP app1 = new APP();
		app1.setApp(3f);
		app1.setVolumen(100);
		listAPP.add(app1);
		
		APP app2 = new APP();
		app1.setApp(1f);
		app1.setVolumen(200);
		listAPP.add(app2);
		
		paymentProcessor.setListAPP(listAPP);
		
		
		PaymentProcessorDetail result = this.paymentProcessorApi.createPaymentProcessor(paymentProcessor).getBody();
		
		Assert.assertEquals(2, this.paymentProcessorApi.getPaymentProcessor(result.getId()).getBody().getListAPP().size());
		
	} 
	
	
	@Test 
	public void testDeletePaymentProcessor() {
		
		String name = "Test CCPP1";
		PaymentProcessor paymentProcessor = new PaymentProcessor();
		paymentProcessor.setFlatfee(2f);
		paymentProcessor.setName(name);
		
		//create
		PaymentProcessorDetail result = this.paymentProcessorApi.createPaymentProcessor(paymentProcessor).getBody();
		
		
		Assert.assertEquals(result.getId(), this.paymentProcessorApi.deletePaymentProcessor(result.getId()).getBody().getId());
		
	} 
	
	
	@Test 
	public void testUpdateEcommerce() {
		
		String name = "Test CCPP1";
		PaymentProcessor paymentProcessor = new PaymentProcessor();
		paymentProcessor.setFlatfee(2f);
		paymentProcessor.setName(name);
		
		//create
		PaymentProcessorDetail result = this.paymentProcessorApi.createPaymentProcessor(paymentProcessor).getBody();
		
		String nameUpdate = "Name update";
		paymentProcessor.setName(nameUpdate);
		
		
		
		Assert.assertEquals(nameUpdate, this.paymentProcessorApi.updatePaymentProcessor(result.getId(), paymentProcessor).getBody().getName());
		
	} 
	
	

	
	
}
