package io.greentesla.service.utils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import io.greentesla.model.generated.atmservice.ATM;
import io.greentesla.model.generated.atmservice.Order;
import io.greentesla.model.generated.atmservice.ServiceTasks;
import io.greentesla.model.generated.atmservice.Task;
import io.greentesla.model.generated.onlinegame.Players;
import io.greentesla.model.generated.transactions.Account;
import io.greentesla.model.generated.transactions.Accounts;
import io.greentesla.model.generated.transactions.Transaction;
import io.greentesla.model.generated.transactions.Transactions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class JsonCasesReader<T> {

    public Transactions readTransactionsRequest(String testName) {
        Class<Transactions> transactions = Transactions.class;
        String filename = "src/test/java/io/greentesla/service/jsonrequests/transactions.".concat(testName).concat(".json");

        return readObject(filename, transactions);
    }

    public Accounts readTransactionsResponse(String testName) {
        Class<Accounts> account = Accounts.class;
        String filename = "src/test/java/io/greentesla/service/jsonresponses/transactions.".concat(testName).concat(".json");
        return readObject(filename, account);
    }

    public ServiceTasks readAtmServicesRequest(String testName) {
        Class<ServiceTasks> task = ServiceTasks.class;
        String filename = "src/test/java/io/greentesla/service/jsonrequests/atmservice.".concat(testName).concat(".json");

        return readObject(filename, task);
    }

    public Order readAtmServicesResponse(String testName) {
        Class<Order> order = Order.class;
        String filename = "src/test/java/io/greentesla/service/jsonresponses/atmservice.".concat(testName).concat(".json");

        return readObject(filename, order);
    }

    public Players readOnlineGameRequest(String testName) {
        Class<Players> playersType = Players.class;
        String filename = "src/test/java/io/greentesla/service/jsonrequests/onlinegame.".concat(testName).concat(".json");

        return readObject(filename, playersType);
    }

    public io.greentesla.model.generated.onlinegame.Order readOnlineGameResponse(String testName) {
        Class<io.greentesla.model.generated.onlinegame.Order> playersType = io.greentesla.model.generated.onlinegame.Order.class;
        String filename = "src/test/java/io/greentesla/service/jsonresponses/onlinegame.".concat(testName).concat(".json");

        return readObject(filename, playersType);
    }

    private <T> T readObject(String filename, Class<T> type) {
        Gson gson = new Gson();
        T res = null;

        try {
            JsonReader reader = new JsonReader(new FileReader(filename));
            T data = gson.fromJson(reader, type);
            res = data;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return res;
    }
}
