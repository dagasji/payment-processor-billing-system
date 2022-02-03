package es.danielgaspar.ppbs.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * This is Payment model
 */
@ApiModel(description = "This is Payment model")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-02-03T17:18:44.282+01:00")


public class Payment   {
  @JsonProperty("amount")
  private Double amount = null;

  @JsonProperty("date")
  private LocalDate date = null;

  @JsonProperty("description")
  private String description = null;

  public Payment amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Payment amount
   * @return amount
  **/
  @ApiModelProperty(value = "Payment amount")


  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Payment date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Payment amount
   * @return date
  **/
  @ApiModelProperty(value = "Payment amount")

  @Valid

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Payment description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Payment description
   * @return description
  **/
  @ApiModelProperty(value = "Payment description")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Payment payment = (Payment) o;
    return Objects.equals(this.amount, payment.amount) &&
        Objects.equals(this.date, payment.date) &&
        Objects.equals(this.description, payment.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, date, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Payment {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

