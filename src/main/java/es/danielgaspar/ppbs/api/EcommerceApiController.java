package es.danielgaspar.ppbs.api;

import es.danielgaspar.ppbs.model.Ecommerce;
import es.danielgaspar.ppbs.model.EcommerceDetail;
import es.danielgaspar.ppbs.model.EcommerceReport;
import es.danielgaspar.ppbs.service.EcommerceService;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
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
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            
        	//Parse Ecommerce to EcommerceDetail
        	EcommerceDetail detail = new EcommerceDetail();
        	detail.setName(body.getName());
        	detail.setIdPaymentProcessor(body.getIdPaymentProcessor());
        	
        	//Call service
        	detail = service.create(detail);   
        	return new ResponseEntity<EcommerceDetail>(detail, HttpStatus.OK);       
        	
        }

        return new ResponseEntity<EcommerceDetail>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Delete existing ecommerce
     */
    public ResponseEntity<EcommerceDetail> deleteEcommerce(@ApiParam(value = "id",required=true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("")) {
        	
        	EcommerceDetail response = service.delete(id);
        	
        	if (response != null) {
        		return new ResponseEntity<EcommerceDetail>(response, HttpStatus.OK);
        	} else {
        		return new ResponseEntity<EcommerceDetail>(HttpStatus.NO_CONTENT);
        	}
        }

        return new ResponseEntity<EcommerceDetail>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Get existing Ecommerce
     * 
     */
    public ResponseEntity<EcommerceDetail> getEcommerce(@ApiParam(value = "id",required=true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        
        if (accept != null && accept.contains("application/json")) {
        	EcommerceDetail response = service.findById(id);
            	
        	if (response != null) {
        		return new ResponseEntity<EcommerceDetail>(response, HttpStatus.OK);
        	} else {
        		return new ResponseEntity<EcommerceDetail>(HttpStatus.NO_CONTENT);
        	}
            
        }

        return new ResponseEntity<EcommerceDetail>(HttpStatus.NOT_IMPLEMENTED);
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
        
    	String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("")) {
        	
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

        return new ResponseEntity<EcommerceDetail>(HttpStatus.NOT_IMPLEMENTED);
    }

}
