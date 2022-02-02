package es.danielgaspar.ppbs.api;

import es.danielgaspar.ppbs.model.Ecommerce;
import es.danielgaspar.ppbs.model.EcommerceDetail;
import es.danielgaspar.ppbs.model.EcommerceReport;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-02-02T09:05:00.503+01:00")

@Controller
public class EcommerceApiController implements EcommerceApi {

    private static final Logger log = LoggerFactory.getLogger(EcommerceApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public EcommerceApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<EcommerceDetail> createEcommerce(@ApiParam(value = "Body request" ,required=true )  @Valid @RequestBody Ecommerce body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("")) {
            try {
                return new ResponseEntity<EcommerceDetail>(objectMapper.readValue("", EcommerceDetail.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type ", e);
                return new ResponseEntity<EcommerceDetail>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<EcommerceDetail>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<EcommerceDetail> deleteEcommerce(@ApiParam(value = "id",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("")) {
            try {
                return new ResponseEntity<EcommerceDetail>(objectMapper.readValue("", EcommerceDetail.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type ", e);
                return new ResponseEntity<EcommerceDetail>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<EcommerceDetail>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<EcommerceDetail> getEcommerce() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("")) {
            try {
                return new ResponseEntity<EcommerceDetail>(objectMapper.readValue("", EcommerceDetail.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type ", e);
                return new ResponseEntity<EcommerceDetail>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<EcommerceDetail>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<EcommerceReport> reportEcommerce(@ApiParam(value = "id",required=true) @PathVariable("id") String id,@ApiParam(value = "",required=true) @PathVariable("month") String month) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("")) {
            try {
                return new ResponseEntity<EcommerceReport>(objectMapper.readValue("", EcommerceReport.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type ", e);
                return new ResponseEntity<EcommerceReport>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<EcommerceReport>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<EcommerceDetail> updateEcommerce(@ApiParam(value = "Body request" ,required=true )  @Valid @RequestBody Ecommerce body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("")) {
            try {
                return new ResponseEntity<EcommerceDetail>(objectMapper.readValue("", EcommerceDetail.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type ", e);
                return new ResponseEntity<EcommerceDetail>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<EcommerceDetail>(HttpStatus.NOT_IMPLEMENTED);
    }

}
