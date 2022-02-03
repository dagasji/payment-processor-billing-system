package es.danielgaspar.ppbs.api;

import es.danielgaspar.ppbs.model.EcommerceDetail;
import es.danielgaspar.ppbs.model.EcommerceReport;
import es.danielgaspar.ppbs.model.PaymentProcessor;
import es.danielgaspar.ppbs.model.PaymentProcessorDetail;
import es.danielgaspar.ppbs.service.EcommerceService;
import es.danielgaspar.ppbs.service.PaymentProcessorService;

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

    public ResponseEntity<EcommerceReport> reportPaymentProcessor(@ApiParam(value = "id",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<EcommerceReport>(objectMapper.readValue("{\"empty\": false}", EcommerceReport.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<EcommerceReport>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<EcommerceReport>(HttpStatus.NOT_IMPLEMENTED);
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
