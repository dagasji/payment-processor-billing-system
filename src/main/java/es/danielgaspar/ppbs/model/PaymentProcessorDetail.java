package es.danielgaspar.ppbs.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import es.danielgaspar.ppbs.model.APP;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * This is Payment Processor model
 */
@ApiModel(description = "This is Payment Processor model")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-02-04T11:27:20.173+01:00")


public class PaymentProcessorDetail   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("flatfee")
  private Float flatfee = null;

  @JsonProperty("listAPP")
  @Valid
  private List<APP> listAPP = null;

  public PaymentProcessorDetail id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Payment procesor Id
   * @return id
  **/
  @ApiModelProperty(value = "Payment procesor Id")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public PaymentProcessorDetail name(String name) {
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

  public PaymentProcessorDetail flatfee(Float flatfee) {
    this.flatfee = flatfee;
    return this;
  }

  /**
   * Commission for each transaction
   * @return flatfee
  **/
  @ApiModelProperty(value = "Commission for each transaction")


  public Float getFlatfee() {
    return flatfee;
  }

  public void setFlatfee(Float flatfee) {
    this.flatfee = flatfee;
  }

  public PaymentProcessorDetail listAPP(List<APP> listAPP) {
    this.listAPP = listAPP;
    return this;
  }

  public PaymentProcessorDetail addListAPPItem(APP listAPPItem) {
    if (this.listAPP == null) {
      this.listAPP = new ArrayList<APP>();
    }
    this.listAPP.add(listAPPItem);
    return this;
  }

  /**
   * Get listAPP
   * @return listAPP
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<APP> getListAPP() {
    return listAPP;
  }

  public void setListAPP(List<APP> listAPP) {
    this.listAPP = listAPP;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentProcessorDetail paymentProcessorDetail = (PaymentProcessorDetail) o;
    return Objects.equals(this.id, paymentProcessorDetail.id) &&
        Objects.equals(this.name, paymentProcessorDetail.name) &&
        Objects.equals(this.flatfee, paymentProcessorDetail.flatfee) &&
        Objects.equals(this.listAPP, paymentProcessorDetail.listAPP);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, flatfee, listAPP);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentProcessorDetail {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    flatfee: ").append(toIndentedString(flatfee)).append("\n");
    sb.append("    listAPP: ").append(toIndentedString(listAPP)).append("\n");
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

