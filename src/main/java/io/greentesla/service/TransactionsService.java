package io.greentesla.service;

import io.greentesla.model.dto.transactions.AccountDto;
import io.greentesla.model.generated.transactions.Accounts;
import io.greentesla.model.generated.transactions.Transaction;

import java.math.BigDecimal;
import java.util.List;
import java.util.TreeMap;

public class TransactionsService {
    public Accounts solve(List<Transaction> transactions) {
        TreeMap<String, AccountDto> accounts = new TreeMap<>();

        for (Transaction transaction : transactions) {
            // handle debit
            if (accounts.containsKey(transaction.getDebitAccount())) {
                AccountDto existingAccount = accounts.get(transaction.getDebitAccount());
                modifyDebit(existingAccount, transaction.getAmount());
            } else {
                String debitAccountText = transaction.getDebitAccount();
                BigDecimal initialBalance = BigDecimal.valueOf(transaction.getAmount() * 100).multiply(new BigDecimal(-1));
                AccountDto debitAccount = createAccount(debitAccountText, 1, 0, initialBalance);

                accounts.put(debitAccountText, debitAccount);
            }

            // handle credit
            if (accounts.containsKey(transaction.getCreditAccount())) {
                AccountDto existingAccount = accounts.get(transaction.getCreditAccount());
                modifyCredit(existingAccount, transaction.getAmount());
            } else {
                String creditAccountText = transaction.getCreditAccount();
                BigDecimal initialBalance = BigDecimal.valueOf(transaction.getAmount() * 100);
                AccountDto creditAccount = createAccount(creditAccountText, 0, 1, initialBalance);

                accounts.put(creditAccountText, creditAccount);
            }
        }

        Accounts results = new Accounts();
        for (AccountDto account : accounts.values()) {
            results.add(account.toAccount());
        }
        return results;
    }

    private AccountDto createAccount(String account, int debitCount, int creditCount, BigDecimal balance) {
        return new AccountDto(account, debitCount, creditCount, balance);
    }

    private void modifyCredit(AccountDto account, float amount) {
        account.setCreditCount(account.getCreditCount() + 1);
        account.setBalance(account.getBalance().add(new BigDecimal(amount * 100)));
    }

    private void modifyDebit(AccountDto account, float amount) {
        account.setDebitCount(account.getDebitCount() + 1);
        account.setBalance(account.getBalance().subtract(new BigDecimal(amount * 100)));
    }
}
