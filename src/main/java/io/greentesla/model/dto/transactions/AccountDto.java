package io.greentesla.model.dto.transactions;

import io.greentesla.model.generated.transactions.Account;

import java.math.BigDecimal;

public class AccountDto {
    private String account = null;
    private Integer debitCount = null;
    private Integer creditCount = null;
    private BigDecimal balance = null;

    public AccountDto() {
    }

    public AccountDto(Account account) {
        this.account = account.getAccount();
        this.balance = BigDecimal.valueOf(account.getBalance() * 100); // avoid precision numbers, could also be solved by using library for money
        this.debitCount = account.getDebitCount();
        this.creditCount = account.getCreditCount();
    }

    public AccountDto(String account, int debitCount, int creditCount, BigDecimal balance) {
        this.account = account;
        this.debitCount = debitCount;
        this.creditCount = creditCount;
        this.balance = balance;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getDebitCount() {
        return debitCount;
    }

    public void setDebitCount(Integer debitCount) {
        this.debitCount = debitCount;
    }

    public Integer getCreditCount() {
        return creditCount;
    }

    public void setCreditCount(Integer creditCount) {
        this.creditCount = creditCount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Account toAccount() {
        Account newAccount = new Account();
        newAccount.setAccount(this.getAccount());
        newAccount.setBalance(this.getBalance().floatValue() / 100);
        newAccount.setDebitCount(this.getDebitCount());
        newAccount.setCreditCount(this.getCreditCount());

        return newAccount;
    }
}
