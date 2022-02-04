package es.danielgaspar.ppbs.utils;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.danielgaspar.ppbs.api.EcommerceApiController;
import es.danielgaspar.ppbs.entity.AcquirerPlusPricingEntity;

public class ReportUtils {
	
	private static final Logger log = LoggerFactory.getLogger(EcommerceApiController.class);
	
	/**
	 * Calculates the app to apply for a given volume
	 * @param volumen Numbers of transactions
	 * @param listApp App list 
	 * @return App 
	 */
	public static AcquirerPlusPricingEntity calculateApp(Integer volumen, List<AcquirerPlusPricingEntity> listApp) {
		
		
		Optional<AcquirerPlusPricingEntity> app = listApp.stream().filter(i -> (i.getVolumen() >=  volumen)).min(
				Comparator.comparing(AcquirerPlusPricingEntity::getVolumen));
		
		//if no find, get the maximum value
		if (!app.isPresent()) {
			log.debug("Get the maximum value");
			app = listApp.stream().max(
					Comparator.comparing(AcquirerPlusPricingEntity::getVolumen));
			
		}
		
		log.debug("calculateApp result: ", app.get());
		
		
		return app.get();
	}

}
