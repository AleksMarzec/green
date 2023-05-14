package io.greentesla.service.utils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import io.greentesla.model.atmservice.ATM;
import io.greentesla.model.atmservice.Order;
import io.greentesla.model.atmservice.Task;
import io.greentesla.model.onlinegame.Players;
import io.greentesla.model.transactions.Account;
import io.greentesla.model.transactions.Transaction;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class JsonCasesReader<T> {

    public List<Transaction> readTransactionsRequest(String testName) {
        Class<Transaction[]> transactions = Transaction[].class;
        String filename = "src/test/java/io/greentesla/service/jsonrequests/transactions.".concat(testName).concat(".json");

        return readArray(filename, transactions);
    }

    public List<Account> readTransactionsResponse(String testName) {
        Class<Account[]> account = Account[].class;
        String filename = "src/test/java/io/greentesla/service/jsonresponses/transactions.".concat(testName).concat(".json");
        return readArray(filename, account);
    }

    public List<Task> readAtmServicesRequest(String testName) {
        Class<Task[]> task = Task[].class;
        String filename = "src/test/java/io/greentesla/service/jsonrequests/atmservice.".concat(testName).concat(".json");

        return readArray(filename, task);
    }

    public Order readAtmServicesResponse(String testName) {
        Class<ATM[]> atm = ATM[].class;
        String filename = "src/test/java/io/greentesla/service/jsonresponses/atmservice.".concat(testName).concat(".json");

        List<ATM> atms = readArray(filename, atm);

        Order order = new Order();
        order.addAll(atms);

        return order;
    }

    public Players readOnlineGameRequest(String testName) {
        Class<Players> playersType = Players.class;
        String filename = "src/test/java/io/greentesla/service/jsonrequests/onlinegame.".concat(testName).concat(".json");

        return readObject(filename, playersType);
    }

    public io.greentesla.model.onlinegame.Order readOnlineGameResponse(String testName) {
        Class<io.greentesla.model.onlinegame.Order> playersType = io.greentesla.model.onlinegame.Order.class;
        String filename = "src/test/java/io/greentesla/service/jsonresponses/onlinegame.".concat(testName).concat(".json");

        return readObject(filename, playersType);
    }

    private <T> List<T> readArray(String filename, Class<T[]> type) {
        Gson gson = new Gson();
        T[] res = null;

        try {
            JsonReader reader = new JsonReader(new FileReader(filename));
            T[] data = gson.fromJson(reader, type);
            res = data;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return Arrays.asList(res);
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
