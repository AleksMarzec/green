package io.greentesla.service;

import io.greentesla.model.transactions.Account;
import io.greentesla.model.transactions.Accounts;
import io.greentesla.model.transactions.Transaction;
import io.greentesla.service.utils.JsonCasesReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class TransactionsServiceTest {

    @Test
    public void regularCaseShouldBeTheSameAsResult() {
        JsonCasesReader reader = new JsonCasesReader();
        List<Transaction> transactions = reader.readTransactionsRequest("regular");
        List<Account> expectedResult = reader.readTransactionsResponse("regular");

        TransactionsService service = new TransactionsService();
        Accounts result = service.solve(transactions);

        Assertions.assertArrayEquals(expectedResult.toArray(), result.toArray());
    }
}