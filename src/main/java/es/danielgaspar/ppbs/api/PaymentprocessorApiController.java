package es.danielgaspar.ppbs.api;

import java.io.IOException;
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
    	
    	log.debug("Init createPaymentProcessor(). body: {}", body);
        
    	//Parse PaymentProcessor to PaymentProcessorDetail
    	PaymentProcessorDetail detail = new PaymentProcessorDetail();
    	detail.setName(body.getName());
    	detail.setFlatfee(body.getFlatfee());
    	detail.setListAPP(body.getListAPP());    	
    	
    	//Call service
    	detail = service.create(detail);   
    	
    	log.debug("Exit createPaymentProcessor(). respoonse: {}", detail);
    	
    	return new ResponseEntity<PaymentProcessorDetail>(detail, HttpStatus.OK);       
    	
    }

    public ResponseEntity<PaymentProcessorDetail> deletePaymentProcessor(@ApiParam(value = "id",required=true) @PathVariable("id") Integer id) {
    	
    	log.debug("Init createPaymentProcessor(). id: {}", id);
    	
    	PaymentProcessorDetail response = service.delete(id);
    	
    	log.debug("Exit createPaymentProcessor(). respoonse: {}", response);
    	
    	if (response != null) {
    		return new ResponseEntity<PaymentProcessorDetail>(response, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<PaymentProcessorDetail>(HttpStatus.NO_CONTENT);
    	}
    }
    
    public ResponseEntity<List<PaymentProcessorDetail>> getAllPaymentProcessor() {
    	
    	log.debug("Init getAllPaymentProcessor()");
        
    	List<PaymentProcessorDetail> response = this.service.findAll();
    	
    	log.debug("Exit getAllPaymentProcessor(). reponse: {}, reponse");
    	
        return new ResponseEntity<List<PaymentProcessorDetail>>(response, HttpStatus.OK);
    }    

    public ResponseEntity<PaymentProcessorDetail> getPaymentProcessor(@ApiParam(value = "id",required=true) @PathVariable("id") Integer id) {
    	
    	log.debug("Init getPaymentProcessor(). id: {}", id);
    	
    	PaymentProcessorDetail response = service.findById(id);
    	
    	log.debug("Exit getPaymentProcessor(). reponse: {}, reponse");
    	
    	if (response != null) {
    		return new ResponseEntity<PaymentProcessorDetail>(response, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<PaymentProcessorDetail>(HttpStatus.NO_CONTENT);
    	} 
    	
    }

    public ResponseEntity<PaymentProcessorReport> reportPaymentProcessor(@ApiParam(value = "id",required=true) @PathVariable("id") Integer id) {
    	
    	log.debug("Init reportPaymentProcessor(). id: {}", id);
      
    	//Call service
    	PaymentProcessorReport response = this.service.report(id);
    	
    	log.debug("Exit reportPaymentProcessor(). reponse: {}, reponse");
    	
        return new ResponseEntity<PaymentProcessorReport>(response, HttpStatus.OK);
    }

    public ResponseEntity<PaymentProcessorDetail> updatePaymentProcessor(@ApiParam(value = "id",required=true) @PathVariable("id") Integer id,@ApiParam(value = "Body request" ,required=true )  @Valid @RequestBody PaymentProcessor body) {
    	
    	log.debug("Init reportPaymentProcessor(). id: {} body: {}", id, body);
    	
    	//Parse Ecommerce to EcommerceDetail
    	//Parse PaymentProcessor to PaymentProcessorDetail
    	PaymentProcessorDetail detail = new PaymentProcessorDetail();
    	detail.setName(body.getName());
    	detail.setFlatfee(body.getFlatfee());
    	detail.setListAPP(body.getListAPP());    	
    	detail.setId(id);
    	        	
    	//Call service
    	PaymentProcessorDetail response= service.update(detail); 
    	
    	log.debug("Exit updatePaymentProcessor(). reponse: {}, reponse");
    	
    	if (response != null) {
    		return new ResponseEntity<PaymentProcessorDetail>(response, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<PaymentProcessorDetail>(HttpStatus.NO_CONTENT);
    	}
    }

}
