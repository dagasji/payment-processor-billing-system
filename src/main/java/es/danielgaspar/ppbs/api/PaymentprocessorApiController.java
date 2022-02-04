package es.danielgaspar.ppbs.api;

import java.io.IOException;

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

import es.danielgaspar.ppbs.model.PaymentProcessor;
import es.danielgaspar.ppbs.model.PaymentProcessorDetail;
import es.danielgaspar.ppbs.model.PaymentProcessorReport;
import es.danielgaspar.ppbs.service.PaymentProcessorService;
import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-02-03T16:56:52.396+01:00")

@Controller
public class PaymentprocessorApiController implements PaymentprocessorApi {

    private static final Logger log = LoggerFactory.getLogger(PaymentprocessorApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private PaymentProcessorService service;

    @org.springframework.beans.factory.annotation.Autowired
    public PaymentprocessorApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<PaymentProcessorDetail> createPaymentProcessor(@ApiParam(value = "Body request" ,required=true )  @Valid @RequestBody PaymentProcessor body) {
        
    	//Parse PaymentProcessor to PaymentProcessorDetail
    	PaymentProcessorDetail detail = new PaymentProcessorDetail();
    	detail.setName(body.getName());
    	detail.setFlatfee(body.getFlatfee());
    	detail.setListAPP(body.getListAPP());    	
    	
    	//Call service
    	detail = service.create(detail);   
    	return new ResponseEntity<PaymentProcessorDetail>(detail, HttpStatus.OK);       
    	
    }

    public ResponseEntity<PaymentProcessorDetail> deletePaymentProcessor(@ApiParam(value = "id",required=true) @PathVariable("id") Integer id) {
    	
    	PaymentProcessorDetail response = service.delete(id);
    	
    	if (response != null) {
    		return new ResponseEntity<PaymentProcessorDetail>(response, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<PaymentProcessorDetail>(HttpStatus.NO_CONTENT);
    	}
    }

    public ResponseEntity<PaymentProcessorDetail> getPaymentProcessor(@ApiParam(value = "id",required=true) @PathVariable("id") Integer id) {
    	
    	PaymentProcessorDetail response = service.findById(id);
    	
    	if (response != null) {
    		return new ResponseEntity<PaymentProcessorDetail>(response, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<PaymentProcessorDetail>(HttpStatus.NO_CONTENT);
    	} 
    	
    }

    public ResponseEntity<PaymentProcessorReport> reportPaymentProcessor(@ApiParam(value = "id",required=true) @PathVariable("id") Integer id) {
      
    	//Call service
    	PaymentProcessorReport response = this.service.report(id);
    	
        return new ResponseEntity<PaymentProcessorReport>(response, HttpStatus.OK);
    }

    public ResponseEntity<PaymentProcessorDetail> updatePaymentProcessor(@ApiParam(value = "id",required=true) @PathVariable("id") Integer id,@ApiParam(value = "Body request" ,required=true )  @Valid @RequestBody PaymentProcessor body) {
    	
    	//Parse Ecommerce to EcommerceDetail
    	//Parse PaymentProcessor to PaymentProcessorDetail
    	PaymentProcessorDetail detail = new PaymentProcessorDetail();
    	detail.setName(body.getName());
    	detail.setFlatfee(body.getFlatfee());
    	detail.setListAPP(body.getListAPP());    	
    	detail.setId(id);
    	        	
    	//Call service
    	PaymentProcessorDetail response= service.update(detail);   
    	
    	if (response != null) {
    		return new ResponseEntity<PaymentProcessorDetail>(response, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<PaymentProcessorDetail>(HttpStatus.NO_CONTENT);
    	}
    }

}
