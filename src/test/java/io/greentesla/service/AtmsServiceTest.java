package io.greentesla.service;

import io.greentesla.model.generated.atmservice.Order;
import io.greentesla.model.generated.atmservice.ServiceTasks;
import io.greentesla.model.generated.atmservice.Task;
import io.greentesla.service.utils.JsonCasesReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AtmsServiceTest {

    @Test
    public void regularCase() {
        JsonCasesReader reader = new JsonCasesReader();
        ServiceTasks tasks = reader.readAtmServicesRequest("regular");
        Order expectedResult = reader.readAtmServicesResponse("regular");

        AtmsService service = new AtmsService();
        Order result = service.solve(tasks);

        Assertions.assertArrayEquals(expectedResult.toArray(), result.toArray());
    }

    @Test
    public void regularCase2() {
        JsonCasesReader reader = new JsonCasesReader();
        ServiceTasks tasks = reader.readAtmServicesRequest("regular2");
        Order expectedResult = reader.readAtmServicesResponse("regular2");

        AtmsService service = new AtmsService();
        Order result = service.solve(tasks);

        Assertions.assertArrayEquals(expectedResult.toArray(), result.toArray());
    }
}