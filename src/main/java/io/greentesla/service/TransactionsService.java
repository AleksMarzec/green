package io.greentesla.service;

import io.greentesla.model.dto.transactions.AccountDto;
import io.greentesla.model.generated.transactions.Accounts;
import io.greentesla.model.generated.transactions.Transaction;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.TreeMap;

public class TransactionsService {
    public Accounts solve(List<Transaction> transactions) {
        TreeMap<String, AccountDto> accounts = new TreeMap<>();

        for (Transaction transaction : transactions) {
            // handle debit
            if (accounts.containsKey(transaction.getDebitAccount())) {
                AccountDto existingAccount = accounts.get(transaction.getDebitAccount());
                existingAccount.setDebitCount(existingAccount.getDebitCount() + 1);
                existingAccount.setBalance(existingAccount.getBalance().subtract(new BigDecimal(transaction.getAmount() * 100)));
            } else {
                AccountDto debitAccount = new AccountDto();
                debitAccount.setAccount(transaction.getDebitAccount());
                debitAccount.setDebitCount(1);
                debitAccount.setCreditCount(0);
                debitAccount.setBalance(new BigDecimal(transaction.getAmount() * 100).multiply(new BigDecimal(-1)));

                accounts.put(transaction.getDebitAccount(), debitAccount);
            }

            // handle credit
            if (accounts.containsKey(transaction.getCreditAccount())) {
                AccountDto existingAccount = accounts.get(transaction.getCreditAccount());
                existingAccount.setCreditCount(existingAccount.getCreditCount() + 1);
                existingAccount.setBalance(existingAccount.getBalance().add(new BigDecimal(transaction.getAmount() * 100)));
            } else {
                AccountDto creditAccount = new AccountDto();
                creditAccount.setAccount(transaction.getCreditAccount());
                creditAccount.setDebitCount(0);
                creditAccount.setCreditCount(1);
                creditAccount.setBalance(new BigDecimal(transaction.getAmount() * 100));

                accounts.put(transaction.getCreditAccount(), creditAccount);
            }
        }

        Accounts accounts1 = new Accounts();
        for (AccountDto account : accounts.values()) {
            accounts1.add(account.toAccount());
        }
        return accounts1;
    }
}
