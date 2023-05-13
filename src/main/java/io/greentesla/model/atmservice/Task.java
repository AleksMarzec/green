package io.greentesla.model.atmservice;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

/**
 * Task
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-08T20:53:13.805155972Z[GMT]")


public class Task   {
  @JsonProperty("region")
  private Integer region = null;

  /**
   * Type of request
   */
  public enum RequestTypeEnum {
    STANDARD("STANDARD"),
    
    PRIORITY("PRIORITY"),
    
    SIGNAL_LOW("SIGNAL_LOW"),
    
    FAILURE_RESTART("FAILURE_RESTART");

    private String value;

    RequestTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RequestTypeEnum fromValue(String text) {
      for (RequestTypeEnum b : RequestTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("requestType")
  private RequestTypeEnum requestType = null;

  @JsonProperty("atmId")
  private Integer atmId = null;

  public Task region(Integer region) {
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

  public Task requestType(RequestTypeEnum requestType) {
    this.requestType = requestType;
    return this;
  }

  /**
   * Type of request
   * @return requestType
   **/
  @Schema(example = "STANDARD", description = "Type of request")
  
    public RequestTypeEnum getRequestType() {
    return requestType;
  }

  public void setRequestType(RequestTypeEnum requestType) {
    this.requestType = requestType;
  }

  public Task atmId(Integer atmId) {
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
    Task task = (Task) o;
    return Objects.equals(this.region, task.region) &&
        Objects.equals(this.requestType, task.requestType) &&
        Objects.equals(this.atmId, task.atmId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(region, requestType, atmId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Task {\n");
    
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    requestType: ").append(toIndentedString(requestType)).append("\n");
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
