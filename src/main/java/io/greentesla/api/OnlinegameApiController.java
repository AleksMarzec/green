package io.greentesla.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.greentesla.model.generated.onlinegame.Order;
import io.greentesla.model.generated.onlinegame.Players;
import io.greentesla.service.OnlineGameService;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-08T20:53:53.976764680Z[GMT]")
@RestController
public class OnlinegameApiController implements OnlinegameApi {

    private static final Logger log = LoggerFactory.getLogger(OnlinegameApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public OnlinegameApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Order> calculate(@Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody Players body) {
        Order result = null;

        try {
            OnlineGameService onlineGameService = new OnlineGameService();
            result = onlineGameService.solve(body);
        } catch (Exception ex) {
            // logger
            return new ResponseEntity<Order>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Order>(result, HttpStatus.OK);

    }

}
