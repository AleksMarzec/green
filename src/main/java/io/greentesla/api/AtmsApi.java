/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.42).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.greentesla.api;

import io.greentesla.model.generated.atmservice.Order;
import io.greentesla.model.generated.atmservice.Task;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-08T20:53:13.805155972Z[GMT]")
@Validated
public interface AtmsApi {

    @Operation(summary = "", description = "Calculates ATMs order for service team", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Order.class)))})
    @RequestMapping(value = "/atms/calculateOrder",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Order> calculate(@Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody List<Task> body);

}

