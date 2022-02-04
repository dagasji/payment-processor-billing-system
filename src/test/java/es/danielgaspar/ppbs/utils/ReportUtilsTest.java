package es.danielgaspar.ppbs.utils;


import static org.mockito.Mockito.CALLS_REAL_METHODS;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.danielgaspar.ppbs.Swagger2SpringBoot;
import es.danielgaspar.ppbs.entity.AcquirerPlusPricingEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Swagger2SpringBoot.class)
public class ReportUtilsTest {




	
	@Test 
	public void testCalculateApp() {
		
		List<AcquirerPlusPricingEntity> listApp = new ArrayList<AcquirerPlusPricingEntity>();
		listApp.add(new AcquirerPlusPricingEntity(100, 5.0f));
		listApp.add(new AcquirerPlusPricingEntity(150, 4.0f));
		listApp.add(new AcquirerPlusPricingEntity(200, 2.0f));
		listApp.add(new AcquirerPlusPricingEntity(500, 1.0f));
		
		Assert.assertEquals(5.0f, ReportUtils.calculateApp(50, listApp).getApp().floatValue(), 0);
		

		
	} 
	
	
	@Test 
	public void testCalculateApp2() {
		
		List<AcquirerPlusPricingEntity> listApp = new ArrayList<AcquirerPlusPricingEntity>();
		listApp.add(new AcquirerPlusPricingEntity(100, 5.0f));
		listApp.add(new AcquirerPlusPricingEntity(150, 4.0f));
		listApp.add(new AcquirerPlusPricingEntity(200, 2.0f));
		listApp.add(new AcquirerPlusPricingEntity(500, 1.0f));
		
		Assert.assertEquals(4.0f, ReportUtils.calculateApp(130, listApp).getApp().floatValue(), 0);
		

		
	} 
	
	@Test 
	public void testCalculateApp3() {
		
		List<AcquirerPlusPricingEntity> listApp = new ArrayList<AcquirerPlusPricingEntity>();
		listApp.add(new AcquirerPlusPricingEntity(100, 5.0f));
		listApp.add(new AcquirerPlusPricingEntity(150, 4.0f));
		listApp.add(new AcquirerPlusPricingEntity(200, 2.0f));
		listApp.add(new AcquirerPlusPricingEntity(500, 1.0f));
		
		Assert.assertEquals(1.0f, ReportUtils.calculateApp(600, listApp).getApp().floatValue(), 0);
		

		
	} 

	
	
}
