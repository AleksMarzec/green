package io.greentesla.service;

import io.greentesla.model.generated.onlinegame.Order;
import io.greentesla.model.generated.onlinegame.Players;
import io.greentesla.service.utils.JsonCasesReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OnlineGameServiceTest {

    @Test
    public void regularCaseShouldReturnAccordingToResults() {
        JsonCasesReader reader = new JsonCasesReader();
        Players request = reader.readOnlineGameRequest("regular");
        Order expectedResult = reader.readOnlineGameResponse("regular");

        OnlineGameService onlineGameService = new OnlineGameService();
        Order result = onlineGameService.solve(request);

        Assertions.assertArrayEquals(expectedResult.toArray(), result.toArray());
    }

    @Test
    public void smallGroupsShouldReturnGroupsWithOneClan() {
        JsonCasesReader reader = new JsonCasesReader();
        Players request = reader.readOnlineGameRequest("smallgroups");
        Order expectedResult = reader.readOnlineGameResponse("smallgroups");

        OnlineGameService onlineGameService = new OnlineGameService();
        Order result = onlineGameService.solve(request);

        Assertions.assertArrayEquals(expectedResult.toArray(), result.toArray());
    }

    @Test
    public void firstClanIsSmallSecondMaxShouldReturnTwoClans() {
        JsonCasesReader reader = new JsonCasesReader();
        Players request = reader.readOnlineGameRequest("oneclantoosmall");
        Order expectedResult = reader.readOnlineGameResponse("oneclantoosmall");

        OnlineGameService onlineGameService = new OnlineGameService();
        Order result = onlineGameService.solve(request);

        Assertions.assertArrayEquals(expectedResult.toArray(), result.toArray());
    }
}