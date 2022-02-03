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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-02-03T17:54:18.092+01:00")


public class APP   {
  @JsonProperty("volumen")
  private Integer volumen = null;

  @JsonProperty("app")
  private Float app = null;

  public APP volumen(Integer volumen) {
    this.volumen = volumen;
    return this;
  }

  /**
   * Volumen
   * @return volumen
  **/
  @ApiModelProperty(value = "Volumen")


  public Integer getVolumen() {
    return volumen;
  }

  public void setVolumen(Integer volumen) {
    this.volumen = volumen;
  }

  public APP app(Float app) {
    this.app = app;
    return this;
  }

  /**
   * Payment Processor name
   * @return app
  **/
  @ApiModelProperty(value = "Payment Processor name")


  public Float getApp() {
    return app;
  }

  public void setApp(Float app) {
    this.app = app;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    APP APP = (APP) o;
    return Objects.equals(this.volumen, APP.volumen) &&
        Objects.equals(this.app, APP.app);
  }

  @Override
  public int hashCode() {
    return Objects.hash(volumen, app);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class APP {\n");
    
    sb.append("    volumen: ").append(toIndentedString(volumen)).append("\n");
    sb.append("    app: ").append(toIndentedString(app)).append("\n");
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

