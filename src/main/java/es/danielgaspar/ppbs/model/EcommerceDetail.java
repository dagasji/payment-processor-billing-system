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
 * This is ecommerce model
 */
@ApiModel(description = "This is ecommerce model")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-02-02T09:05:00.503+01:00")


public class EcommerceDetail   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  public EcommerceDetail id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Ecommerce Id
   * @return id
  **/
  @ApiModelProperty(value = "Ecommerce Id")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public EcommerceDetail name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Ecommerce name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Ecommerce name")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EcommerceDetail ecommerceDetail = (EcommerceDetail) o;
    return Objects.equals(this.id, ecommerceDetail.id) &&
        Objects.equals(this.name, ecommerceDetail.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EcommerceDetail {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

