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
import org.threeten.bp.LocalDate;

import es.danielgaspar.ppbs.Swagger2SpringBoot;
import es.danielgaspar.ppbs.entity.PaymentEntity;
import es.danielgaspar.ppbs.model.APP;
import es.danielgaspar.ppbs.model.Ecommerce;
import es.danielgaspar.ppbs.model.EcommerceDetail;
import es.danielgaspar.ppbs.model.Payment;
import es.danielgaspar.ppbs.model.PaymentProcessor;
import es.danielgaspar.ppbs.model.PaymentProcessorDetail;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Swagger2SpringBoot.class)
@Transactional
public class EcommerceApiTest {

	@Autowired
	EcommerceApi ecommerceApi;
	
	@Autowired
	PaymentprocessorApi paymentProcessorApi;
	


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
	
	@Test 
	public void testEcommerceReport() {
		
		//Create payment processor
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
		app2.setApp(1f);
		app2.setVolumen(200);
		listAPP.add(app2);
		
		paymentProcessor.setListAPP(listAPP);
		
		
		PaymentProcessorDetail result = this.paymentProcessorApi.createPaymentProcessor(paymentProcessor).getBody();
		
		//Create ecommerce
		String nameEcommerce = "Test getFindAll";
		Ecommerce ecommerce = new Ecommerce();
		ecommerce.setName(name);
		ecommerce.setIdPaymentProcessor(result.getId());
		EcommerceDetail ecommerceDetail = this.ecommerceApi.createEcommerce(ecommerce).getBody();
		
		
		//Create payments
		Payment payment = new Payment();
		payment.setAmount(50d);
		payment.setDate(LocalDate.of(2022, 2, 15 ));
		payment.setDescription("Payment 1");		
		ecommerceApi.createPayment(ecommerceDetail.getId(), payment);
		
		payment.setAmount(25d);
		payment.setDate(LocalDate.of(2022, 2, 15 ));
		payment.setDescription("Payment 2");
		ecommerceApi.createPayment(ecommerceDetail.getId(), payment);
		
		payment.setAmount(25d);
		payment.setDate(LocalDate.of(2022, 2, 12 ));
		payment.setDescription("Payment 3");
		ecommerceApi.createPayment(ecommerceDetail.getId(), payment);
		
		
		Assert.assertEquals(2, this.ecommerceApi.reportEcommerce(ecommerceDetail.getId(), 2022, 2).getBody().getListTransactions().size());
	} 
	
	

	
	
}
