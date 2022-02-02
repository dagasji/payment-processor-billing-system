/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.21).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package es.danielgaspar.ppbs.api;

import es.danielgaspar.ppbs.model.EcommerceReport;
import es.danielgaspar.ppbs.model.PaymentProcessor;
import es.danielgaspar.ppbs.model.PaymentProcessorDetail;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-02-02T09:05:00.503+01:00")

@Validated
@Api(value = "paymentprocessor", description = "the paymentprocessor API")
@RequestMapping(value = "")
public interface PaymentprocessorApi {

    @ApiOperation(value = "create new payment processor", nickname = "createPaymentProcessor", notes = "", response = PaymentProcessorDetail.class, tags={ "Payment Processor", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = PaymentProcessorDetail.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/paymentprocessor",
        produces = { "*/*" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<PaymentProcessorDetail> createPaymentProcessor(@ApiParam(value = "Body request" ,required=true )  @Valid @RequestBody PaymentProcessor body);


    @ApiOperation(value = "Delete Payment Processor", nickname = "deletePaymentProcessor", notes = "", response = PaymentProcessorDetail.class, tags={ "Payment Processor", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = PaymentProcessorDetail.class),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden") })
    @RequestMapping(value = "/paymentprocessor/{id}",
        produces = { "*/*" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<PaymentProcessorDetail> deletePaymentProcessor(@ApiParam(value = "id",required=true) @PathVariable("id") String id);


    @ApiOperation(value = "Get Payment Processor detail", nickname = "getPaymentProcessor", notes = "", response = PaymentProcessorDetail.class, tags={ "Payment Processor", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = PaymentProcessorDetail.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/paymentprocessor/{id}",
        produces = { "*/*" }, 
        method = RequestMethod.GET)
    ResponseEntity<PaymentProcessorDetail> getPaymentProcessor();


    @ApiOperation(value = "Report monthly", nickname = "reportPaymentProcessor", notes = "", response = EcommerceReport.class, tags={ "Payment Processor", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = EcommerceReport.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/paymentprocessor/{id}/report",
        produces = { "*/*" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<EcommerceReport> reportPaymentProcessor(@ApiParam(value = "id",required=true) @PathVariable("id") String id);


    @ApiOperation(value = "Update Payment Processor", nickname = "updatePaymentProcessor", notes = "", response = PaymentProcessorDetail.class, tags={ "Payment Processor", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = PaymentProcessorDetail.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/paymentprocessor/{id}",
        produces = { "*/*" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<PaymentProcessorDetail> updatePaymentProcessor(@ApiParam(value = "Body request" ,required=true )  @Valid @RequestBody PaymentProcessor body);

}