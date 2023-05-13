package io.greentesla.model.atmservice;

import java.util.Objects;

import io.greentesla.model.atmservice.ATM;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;

import org.springframework.validation.annotation.Validated;

/**
 * Ordered list of ATMs to service
 */
@Schema(description = "Ordered list of ATMs to service")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-08T20:53:13.805155972Z[GMT]")


public class Order extends ArrayList<ATM>  {

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
