/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.21).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package es.danielgaspar.ppbs.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.danielgaspar.ppbs.model.Ecommerce;
import es.danielgaspar.ppbs.model.EcommerceDetail;
import es.danielgaspar.ppbs.model.EcommerceReport;
import es.danielgaspar.ppbs.model.Payment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-02-03T12:17:41.594+01:00")

@Validated
@Api(value = "ecommerce", description = "the ecommerce API")
@RequestMapping(value = "")
public interface EcommerceApi {

    @ApiOperation(value = "Create new ecommerce", nickname = "createEcommerce", notes = "", response = EcommerceDetail.class, tags={ "ecommerce", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = EcommerceDetail.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/ecommerce",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<EcommerceDetail> createEcommerce(@ApiParam(value = "Body request" ,required=true )  @Valid @RequestBody Ecommerce body);
    
    @ApiOperation(value = "Create new payment link to the ecommerce", nickname = "createPayment", notes = "", tags={ "ecommerce", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/ecommerce/{id}/payment",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> createPayment(@ApiParam(value = "id ecommerce",required=true) @PathVariable("id") Integer id,@ApiParam(value = "Body request" ,required=true )  @Valid @RequestBody Payment body);
    

    @ApiOperation(value = "Delete Ecommmerce", nickname = "deleteEcommerce", notes = "", response = EcommerceDetail.class, tags={ "ecommerce", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = EcommerceDetail.class),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden") })
    @RequestMapping(value = "/ecommerce/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<EcommerceDetail> deleteEcommerce(@ApiParam(value = "id",required=true) @PathVariable("id") Integer id);
    
    
    @ApiOperation(value = "Get all ecommerce", nickname = "getAllEcommerce", notes = "", response = EcommerceDetail.class, responseContainer = "List", tags={ "ecommerce", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = EcommerceDetail.class, responseContainer = "List"),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/ecommerce",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<EcommerceDetail>> getAllEcommerce();

    @ApiOperation(value = "Get ecommerce detail", nickname = "getEcommerce", notes = "", response = EcommerceDetail.class, tags={ "ecommerce", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = EcommerceDetail.class),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/ecommerce/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<EcommerceDetail> getEcommerce(@ApiParam(value = "id",required=true) @PathVariable("id") Integer id);


    @ApiOperation(value = "Report monthly settlement Ecommerce", nickname = "reportEcommerce", notes = "", response = EcommerceReport.class, tags={ "ecommerce", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = EcommerceReport.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/ecommerce/{id}/report/{year}/{month}",
        produces = { "application/json" }, 
        consumes = { "*/*" },
        method = RequestMethod.GET)
    ResponseEntity<EcommerceReport> reportEcommerce(@ApiParam(value = "id",required=true) @PathVariable("id") Integer id,@ApiParam(value = "",required=true) @PathVariable("year") Integer year,@ApiParam(value = "",required=true) @PathVariable("month") Integer month);


    @ApiOperation(value = "Update ecommerce", nickname = "updateEcommerce", notes = "", response = EcommerceDetail.class, tags={ "ecommerce", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = EcommerceDetail.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/ecommerce/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<EcommerceDetail> updateEcommerce(@ApiParam(value = "id",required=true) @PathVariable("id") Integer id,@ApiParam(value = "Body request" ,required=true )  @Valid @RequestBody Ecommerce body);

}
