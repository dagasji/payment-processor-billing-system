package es.danielgaspar.ppbs.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.danielgaspar.ppbs.model.Ecommerce;
import es.danielgaspar.ppbs.model.EcommerceDetail;
import es.danielgaspar.ppbs.model.EcommerceReport;
import es.danielgaspar.ppbs.model.Payment;
import es.danielgaspar.ppbs.service.EcommerceService;
import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-02-03T09:47:42.868+01:00")

/**
 * Ecomnmerce API
 * @author dgaspar
 *
 */
@Controller
public class EcommerceApiController implements EcommerceApi {

    private static final Logger log = LoggerFactory.getLogger(EcommerceApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private EcommerceService service;
    
    @org.springframework.beans.factory.annotation.Autowired
    public EcommerceApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    /**
     * Create new ecommerce entity
     */
    public ResponseEntity<EcommerceDetail> createEcommerce(@ApiParam(value = "Body request" ,required=true )  @Valid @RequestBody Ecommerce body) {
            
    	//Parse Ecommerce to EcommerceDetail
    	EcommerceDetail detail = new EcommerceDetail();
    	detail.setName(body.getName());
    	detail.setIdPaymentProcessor(body.getIdPaymentProcessor());
    	
    	//Call service
    	detail = service.create(detail);   
    	return new ResponseEntity<EcommerceDetail>(detail, HttpStatus.OK);       
        
    }
    
    public ResponseEntity<Void> createPayment(@ApiParam(value = "id ecommerce",required=true) @PathVariable("id") Integer id,@ApiParam(value = "Body request" ,required=true )  @Valid @RequestBody Payment body) {
        
    	try {
    		service.createPayment(id, body);
    	
    	}catch (Exception e) {
    		log.error("Error in createPayment()", e);
    		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    /**
     * Delete existing ecommerce
     */
    public ResponseEntity<EcommerceDetail> deleteEcommerce(@ApiParam(value = "id",required=true) @PathVariable("id") Integer id) {
        	
    	EcommerceDetail response = service.delete(id);
    	
    	if (response != null) {
    		return new ResponseEntity<EcommerceDetail>(response, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<EcommerceDetail>(HttpStatus.NO_CONTENT);
    	}
    }

    /**
     * Get all ecommerce
     */
    public ResponseEntity<List<EcommerceDetail>> getAllEcommerce() {
            
    	List<EcommerceDetail> response = service.findAll();
    	return new ResponseEntity<List<EcommerceDetail>>(response, HttpStatus.OK);

    }
    
    /**
     * Get existing Ecommerce
     * 
     */
    public ResponseEntity<EcommerceDetail> getEcommerce(@ApiParam(value = "id",required=true) @PathVariable("id") Integer id) {
       
    	EcommerceDetail response = service.findById(id);
        	
    	if (response != null) {
    		return new ResponseEntity<EcommerceDetail>(response, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<EcommerceDetail>(HttpStatus.NO_CONTENT);
    	}            
       
    }

    
    public ResponseEntity<EcommerceReport> reportEcommerce(@ApiParam(value = "id",required=true) @PathVariable("id") String id,@ApiParam(value = "",required=true) @PathVariable("month") String month) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("")) {
            
        	//this.service.delete(id);
        }

        return new ResponseEntity<EcommerceReport>(HttpStatus.NOT_IMPLEMENTED);
    }


    /**
     * Update existing Ecommerce
     */
    public ResponseEntity<EcommerceDetail> updateEcommerce(@ApiParam(value = "id",required=true) @PathVariable("id") Integer id,@ApiParam(value = "Body request" ,required=true )  @Valid @RequestBody Ecommerce body) {
        	
    	//Parse Ecommerce to EcommerceDetail
    	EcommerceDetail detail = new EcommerceDetail();
    	detail.setId(id);
    	detail.setName(body.getName());
    	detail.setIdPaymentProcessor(body.getIdPaymentProcessor());
    	        	
    	//Call service
    	EcommerceDetail response= service.update(detail);   
    	
    	if (response != null) {
    		return new ResponseEntity<EcommerceDetail>(response, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<EcommerceDetail>(HttpStatus.NO_CONTENT);
    	}
        	

    }

}
