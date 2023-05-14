package io.greentesla.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.greentesla.model.generated.transactions.Accounts;
import io.greentesla.model.generated.transactions.Transaction;
import io.greentesla.service.TransactionsService;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-08T20:52:28.561455274Z[GMT]")
@RestController
public class TransactionsApiController implements TransactionsApi {

    private static final Logger log = LoggerFactory.getLogger(TransactionsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TransactionsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Accounts> report(@Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody List<Transaction> body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            TransactionsService transactionsService = new TransactionsService();
            Accounts res = transactionsService.solve(body);
            return new ResponseEntity<Accounts>(res, HttpStatus.OK);
        }

        return new ResponseEntity<Accounts>(HttpStatus.NOT_IMPLEMENTED);
    }

}
