package io.greentesla.service;

import io.greentesla.model.atmservice.Task;
import io.greentesla.model.onlinegame.Order;
import io.greentesla.model.onlinegame.Players;
import io.greentesla.service.utils.JsonCasesReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OnlineGameServiceTest {

    @Test
    public void regularCase() {
        JsonCasesReader reader = new JsonCasesReader();
        Players request = reader.readOnlineGameRequest("regular");
        Order expectedResult = reader.readOnlineGameResponse("regular");

        OnlineGameService onlineGameService = new OnlineGameService();
        Order result = onlineGameService.solve(request);

        Assertions.assertArrayEquals(expectedResult.toArray(), result.toArray());
    }
}