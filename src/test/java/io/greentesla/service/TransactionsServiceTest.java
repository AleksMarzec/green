package io.greentesla.service;

import io.greentesla.model.generated.transactions.Account;
import io.greentesla.model.generated.transactions.Accounts;
import io.greentesla.model.generated.transactions.Transaction;
import io.greentesla.model.generated.transactions.Transactions;
import io.greentesla.service.utils.JsonCasesReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class TransactionsServiceTest {

    @Test
    public void regularCaseShouldBeTheSameAsResult() {
        JsonCasesReader reader = new JsonCasesReader();
        Transactions transactions = reader.readTransactionsRequest("regular");
        Accounts expectedResult = reader.readTransactionsResponse("regular");

        TransactionsService service = new TransactionsService();
        Accounts result = service.solve(transactions);

        Assertions.assertArrayEquals(expectedResult.toArray(), result.toArray());
    }

    @Test
    public void largeDataSetShouldHandleItFast() {
        JsonCasesReader reader = new JsonCasesReader();
        Transactions transactions = reader.readTransactionsRequest("large");
        TransactionsService service = new TransactionsService();

        long startTime = System.currentTimeMillis();
        Accounts result = service.solve(transactions);
        long estimatedTime = System.currentTimeMillis() - startTime;

        boolean isLess = estimatedTime < 3000 / 5; // dataset is 4x smaller than expected one, and complexity is log, so let's add some margin
        Assertions.assertEquals(isLess, true);
    }
}