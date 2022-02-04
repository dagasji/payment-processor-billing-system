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
 * This is EcommerceBilling model
 */
@ApiModel(description = "This is EcommerceBilling model")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-02-04T13:43:34.582+01:00")


public class EcommerceBilling   {
  @JsonProperty("ecommerceName")
  private String ecommerceName = null;

  @JsonProperty("amount")
  private Double amount = null;

  public EcommerceBilling ecommerceName(String ecommerceName) {
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

  public EcommerceBilling amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Payment description
   * @return amount
  **/
  @ApiModelProperty(value = "Payment description")


  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EcommerceBilling ecommerceBilling = (EcommerceBilling) o;
    return Objects.equals(this.ecommerceName, ecommerceBilling.ecommerceName) &&
        Objects.equals(this.amount, ecommerceBilling.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ecommerceName, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EcommerceBilling {\n");
    
    sb.append("    ecommerceName: ").append(toIndentedString(ecommerceName)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

