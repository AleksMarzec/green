package io.greentesla.service.utils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import io.greentesla.model.atmservice.ATM;
import io.greentesla.model.atmservice.Order;
import io.greentesla.model.atmservice.Task;
import io.greentesla.model.transactions.Account;
import io.greentesla.model.transactions.Transaction;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class JsonCasesReader<T> {

    public List<Transaction> readTransactionsTransactions(String filename) {
        Gson gson = new Gson();
        Transaction[] res = null;

        try {
            JsonReader reader = new JsonReader(new FileReader(filename));
            Transaction[] data = gson.fromJson(reader, Transaction[].class);
            res = data;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return Arrays.asList(res);
    }

    public List<Account> readTransactionsAccounts(String filename) {
        Gson gson = new Gson();
        Account[] res = null;

        try {
            JsonReader reader = new JsonReader(new FileReader(filename));
            Account[] data = gson.fromJson(reader, Account[].class);
            res = data;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return Arrays.asList(res);
    }

    public List<Task> readAtmServicesTasks(String filename) {
        Class<Task[]> task = Task[].class;

        return readArray(filename, task);
    }

    public Order readAtmServicesOrder(String filename) {
        Class<ATM[]> atm = ATM[].class;

        List<ATM> atms = readArray(filename, atm);

        Order order = new Order();
        order.addAll(atms);

        return order;
    }

    public <T> List<T> readArray(String filename, Class<T[]> type) {
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
}
