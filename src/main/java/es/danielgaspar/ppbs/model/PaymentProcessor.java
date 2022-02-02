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
 * This is Payment Processor model
 */
@ApiModel(description = "This is Payment Processor model")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-02-02T09:05:00.503+01:00")


public class PaymentProcessor   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("flatfee")
  private String flatfee = null;

  public PaymentProcessor name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Payment Processor name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Payment Processor name")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PaymentProcessor flatfee(String flatfee) {
    this.flatfee = flatfee;
    return this;
  }

  /**
   * Commission for each transaction
   * @return flatfee
  **/
  @ApiModelProperty(value = "Commission for each transaction")


  public String getFlatfee() {
    return flatfee;
  }

  public void setFlatfee(String flatfee) {
    this.flatfee = flatfee;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentProcessor paymentProcessor = (PaymentProcessor) o;
    return Objects.equals(this.name, paymentProcessor.name) &&
        Objects.equals(this.flatfee, paymentProcessor.flatfee);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, flatfee);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentProcessor {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    flatfee: ").append(toIndentedString(flatfee)).append("\n");
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

