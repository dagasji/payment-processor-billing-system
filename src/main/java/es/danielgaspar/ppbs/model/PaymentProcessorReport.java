package es.danielgaspar.ppbs.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This is Payment Processor Report
 */
@ApiModel(description = "This is Payment Processor Report")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-02-04T13:43:34.582+01:00")


public class PaymentProcessorReport   {
  @JsonProperty("paymentProcessorName")
  private String paymentProcessorName = null;

  @JsonProperty("listEcommerce")
  @Valid
  private List<EcommerceBilling> listEcommerce = null;

  public PaymentProcessorReport paymentProcessorName(String paymentProcessorName) {
    this.paymentProcessorName = paymentProcessorName;
    return this;
  }

  /**
   * Payment processor name
   * @return paymentProcessorName
  **/
  @ApiModelProperty(value = "Payment processor name")


  public String getPaymentProcessorName() {
    return paymentProcessorName;
  }

  public void setPaymentProcessorName(String paymentProcessorName) {
    this.paymentProcessorName = paymentProcessorName;
  }

  public PaymentProcessorReport listEcommerce(List<EcommerceBilling> listEcommerce) {
    this.listEcommerce = listEcommerce;
    return this;
  }

  public PaymentProcessorReport addListEcommerceItem(EcommerceBilling listEcommerceItem) {
    if (this.listEcommerce == null) {
      this.listEcommerce = new ArrayList<EcommerceBilling>();
    }
    this.listEcommerce.add(listEcommerceItem);
    return this;
  }

  /**
   * Get listEcommerce
   * @return listEcommerce
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<EcommerceBilling> getListEcommerce() {
    return listEcommerce;
  }

  public void setListEcommerce(List<EcommerceBilling> listEcommerce) {
    this.listEcommerce = listEcommerce;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentProcessorReport paymentProcessorReport = (PaymentProcessorReport) o;
    return Objects.equals(this.paymentProcessorName, paymentProcessorReport.paymentProcessorName) &&
        Objects.equals(this.listEcommerce, paymentProcessorReport.listEcommerce);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentProcessorName, listEcommerce);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentProcessorReport {\n");
    
    sb.append("    paymentProcessorName: ").append(toIndentedString(paymentProcessorName)).append("\n");
    sb.append("    listEcommerce: ").append(toIndentedString(listEcommerce)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

