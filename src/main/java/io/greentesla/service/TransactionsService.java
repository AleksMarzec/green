package io.greentesla.service;

import io.greentesla.model.dto.transactions.AccountDto;
import io.greentesla.model.generated.transactions.Accounts;
import io.greentesla.model.generated.transactions.Transaction;
import io.greentesla.model.generated.transactions.Transactions;

import java.math.BigDecimal;
import java.util.List;
import java.util.TreeMap;

public class TransactionsService {
    public Accounts solve(Transactions transactions) {
        TreeMap<String, AccountDto> accounts = new TreeMap<>();

        for (Transaction transaction : transactions) {
            // handle debit
            String debitAccountText = transaction.getDebitAccount();
            if (accounts.containsKey(debitAccountText)) {
                AccountDto existingAccount = accounts.get(debitAccountText);
                modifyDebit(existingAccount, transaction.getAmount());
            } else {
                BigDecimal initialBalance = BigDecimal.valueOf(transaction.getAmount() * 100).multiply(new BigDecimal(-1));
                AccountDto debitAccount = createAccount(debitAccountText, 1, 0, initialBalance);

                accounts.put(debitAccountText, debitAccount);
            }

            // handle credit
            String creditAccountText = transaction.getCreditAccount();
            if (accounts.containsKey(creditAccountText)) {
                AccountDto existingAccount = accounts.get(creditAccountText);
                modifyCredit(existingAccount, transaction.getAmount());
            } else {
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
