package io.greentesla.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.greentesla.model.generated.atmservice.Order;
import io.greentesla.model.generated.atmservice.Task;
import io.greentesla.service.AtmsService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-08T20:53:13.805155972Z[GMT]")
@RestController
public class AtmsApiController implements AtmsApi {

    private static final Logger log = LoggerFactory.getLogger(AtmsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public AtmsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Order> calculate(@Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody List<Task> body) {
        String accept = request.getHeader("Accept");
        AtmsService logic = new AtmsService();

        if (accept != null && accept.contains("application/json")) {
            AtmsService atmsService = new AtmsService();
            Order res = atmsService.solve(body);
            return new ResponseEntity<Order>(res, HttpStatus.OK);
        }

        return new ResponseEntity<Order>(HttpStatus.NOT_IMPLEMENTED);
    }

}
