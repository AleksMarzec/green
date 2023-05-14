package io.greentesla.model.generated.atmservice;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

/**
 * ATMs details
 */
@Schema(description = "ATMs details")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-08T20:53:13.805155972Z[GMT]")


public class ATM   {
  @JsonProperty("region")
  private Integer region = null;

  @JsonProperty("atmId")
  private Integer atmId = null;

  public ATM region(Integer region) {
    this.region = region;
    return this;
  }

  /**
   * Get region
   * minimum: 1
   * maximum: 9999
   * @return region
   **/
  @Schema(example = "10", description = "")
  
  @Min(1) @Max(9999)   public Integer getRegion() {
    return region;
  }

  public void setRegion(Integer region) {
    this.region = region;
  }

  public ATM atmId(Integer atmId) {
    this.atmId = atmId;
    return this;
  }

  /**
   * Get atmId
   * minimum: 1
   * maximum: 9999
   * @return atmId
   **/
  @Schema(example = "500", description = "")
  
  @Min(1) @Max(9999)   public Integer getAtmId() {
    return atmId;
  }

  public void setAtmId(Integer atmId) {
    this.atmId = atmId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ATM ATM = (ATM) o;
    return Objects.equals(this.region, ATM.region) &&
        Objects.equals(this.atmId, ATM.atmId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(region, atmId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ATM {\n");
    
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    atmId: ").append(toIndentedString(atmId)).append("\n");
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
