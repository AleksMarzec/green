package io.greentesla.service;

import io.greentesla.model.transactions.Account;
import io.greentesla.model.transactions.Accounts;
import io.greentesla.model.transactions.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class TransactionsService {
    public Accounts solve(List<Transaction> transactions) {
        TreeMap<String, Account> accounts = new TreeMap<>();

        for (Transaction transaction : transactions) {
            // handle debit
            if (accounts.containsKey(transaction.getDebitAccount())) {
                Account existingAccount = accounts.get(transaction.getDebitAccount());
                existingAccount.setDebitCount(existingAccount.getDebitCount() + 1);
                existingAccount.setBalance(existingAccount.getBalance() - transaction.getAmount());
            } else {
                Account debitAccount = new Account();
                debitAccount.setAccount(transaction.getDebitAccount());
                debitAccount.setDebitCount(1);
                debitAccount.setCreditCount(0);
                debitAccount.setBalance(transaction.getAmount() * -1);

                accounts.put(transaction.getDebitAccount(), debitAccount);
            }

            // handle credit
            if (accounts.containsKey(transaction.getCreditAccount())) {
                Account existingAccount = accounts.get(transaction.getCreditAccount());
                existingAccount.setCreditCount(existingAccount.getCreditCount() + 1);
                existingAccount.setBalance(existingAccount.getBalance() + transaction.getAmount());
            } else {
                Account creditAccount = new Account();
                creditAccount.setAccount(transaction.getCreditAccount());
                creditAccount.setDebitCount(0);
                creditAccount.setCreditCount(1);
                creditAccount.setBalance(transaction.getAmount());

                accounts.put(transaction.getCreditAccount(), creditAccount);
            }
        }

        Accounts accounts1 = new Accounts();
        accounts1.addAll(accounts.values());
        return accounts1;
    }
}
