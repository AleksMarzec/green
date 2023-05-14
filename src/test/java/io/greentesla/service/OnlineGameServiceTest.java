package io.greentesla.service;

import io.greentesla.model.generated.onlinegame.Order;
import io.greentesla.model.generated.onlinegame.Players;
import io.greentesla.service.utils.JsonCasesReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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