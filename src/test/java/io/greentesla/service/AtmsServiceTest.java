package io.greentesla.service;

import io.greentesla.model.atmservice.Order;
import io.greentesla.model.atmservice.Task;
import io.greentesla.model.transactions.Account;
import io.greentesla.model.transactions.Accounts;
import io.greentesla.model.transactions.Transaction;
import io.greentesla.service.utils.JsonCasesReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AtmsServiceTest {

    @Test
    public void regularCase() {
        JsonCasesReader reader = new JsonCasesReader();
        List<Task> tasks = reader.readAtmServicesTasks("src/test/java/io/greentesla/service/jsonrequests/atmservice.regular.json");
        Order expectedResult = reader.readAtmServicesOrder("src/test/java/io/greentesla/service/jsonresponses/atmservice.regular.json");

        AtmsService service = new AtmsService();
        Order result = service.solve(tasks);

        Assertions.assertArrayEquals(expectedResult.toArray(), result.toArray());
    }
}