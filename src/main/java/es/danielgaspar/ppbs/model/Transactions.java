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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-02-04T11:43:54.244+01:00")


public class Transactions   {
  @JsonProperty("day")
  private String day = null;

  @JsonProperty("transactions")
  private Integer transactions = null;

  @JsonProperty("amount")
  private Double amount = null;

  public Transactions day(String day) {
    this.day = day;
    return this;
  }

  /**
   * Day of month
   * @return day
  **/
  @ApiModelProperty(value = "Day of month")


  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }

  public Transactions transactions(Integer transactions) {
    this.transactions = transactions;
    return this;
  }

  /**
   * Number transactions
   * @return transactions
  **/
  @ApiModelProperty(value = "Number transactions")


  public Integer getTransactions() {
    return transactions;
  }

  public void setTransactions(Integer transactions) {
    this.transactions = transactions;
  }

  public Transactions amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Total amount + tax
   * @return amount
  **/
  @ApiModelProperty(value = "Total amount + tax")


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
    Transactions transactions = (Transactions) o;
    return Objects.equals(this.day, transactions.day) &&
        Objects.equals(this.transactions, transactions.transactions) &&
        Objects.equals(this.amount, transactions.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(day, transactions, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transactions {\n");
    
    sb.append("    day: ").append(toIndentedString(day)).append("\n");
    sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
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

