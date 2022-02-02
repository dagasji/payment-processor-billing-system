package es.danielgaspar.ppbs.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EcommerceReport
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-02-02T09:05:00.503+01:00")


public class EcommerceReport   {
  @JsonProperty("ecommerceName")
  private String ecommerceName = null;

  @JsonProperty("month")
  private String month = null;

  @JsonProperty("paymentProcessorName")
  private String paymentProcessorName = null;

  public EcommerceReport ecommerceName(String ecommerceName) {
    this.ecommerceName = ecommerceName;
    return this;
  }

  /**
   * Ecommerce name
   * @return ecommerceName
  **/
  @ApiModelProperty(value = "Ecommerce name")


  public String getEcommerceName() {
    return ecommerceName;
  }

  public void setEcommerceName(String ecommerceName) {
    this.ecommerceName = ecommerceName;
  }

  public EcommerceReport month(String month) {
    this.month = month;
    return this;
  }

  /**
   * Month
   * @return month
  **/
  @ApiModelProperty(value = "Month")


  public String getMonth() {
    return month;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  public EcommerceReport paymentProcessorName(String paymentProcessorName) {
    this.paymentProcessorName = paymentProcessorName;
    return this;
  }

  /**
   * Payment Processor name
   * @return paymentProcessorName
  **/
  @ApiModelProperty(value = "Payment Processor name")


  public String getPaymentProcessorName() {
    return paymentProcessorName;
  }

  public void setPaymentProcessorName(String paymentProcessorName) {
    this.paymentProcessorName = paymentProcessorName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EcommerceReport ecommerceReport = (EcommerceReport) o;
    return Objects.equals(this.ecommerceName, ecommerceReport.ecommerceName) &&
        Objects.equals(this.month, ecommerceReport.month) &&
        Objects.equals(this.paymentProcessorName, ecommerceReport.paymentProcessorName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ecommerceName, month, paymentProcessorName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EcommerceReport {\n");
    
    sb.append("    ecommerceName: ").append(toIndentedString(ecommerceName)).append("\n");
    sb.append("    month: ").append(toIndentedString(month)).append("\n");
    sb.append("    paymentProcessorName: ").append(toIndentedString(paymentProcessorName)).append("\n");
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

