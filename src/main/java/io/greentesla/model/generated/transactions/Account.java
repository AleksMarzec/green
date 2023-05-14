package io.greentesla.model.generated.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Account
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-08T20:52:28.561455274Z[GMT]")


public class Account {
    @JsonProperty("account")
    private String account = null;

    @JsonProperty("debitCount")
    private Integer debitCount = null;

    @JsonProperty("creditCount")
    private Integer creditCount = null;

    @JsonProperty("balance")
    private Float balance = null;

    public Account account(String account) {
        this.account = account;
        return this;
    }

    /**
     * Get account
     *
     * @return account
     **/
    @Schema(example = "3.2309111922661937E+25", description = "")

    @Size(min = 26, max = 26)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Account debitCount(Integer debitCount) {
        this.debitCount = debitCount;
        return this;
    }

    /**
     * Number of debit transactions
     *
     * @return debitCount
     **/
    @Schema(example = "2", description = "Number of debit transactions")

    public Integer getDebitCount() {
        return debitCount;
    }

    public void setDebitCount(Integer debitCount) {
        this.debitCount = debitCount;
    }

    public Account creditCount(Integer creditCount) {
        this.creditCount = creditCount;
        return this;
    }

    /**
     * Number of credit transactions
     *
     * @return creditCount
     **/
    @Schema(example = "2", description = "Number of credit transactions")

    public Integer getCreditCount() {
        return creditCount;
    }

    public void setCreditCount(Integer creditCount) {
        this.creditCount = creditCount;
    }

    public Account balance(Float balance) {
        this.balance = balance;
        return this;
    }

    /**
     * Get balance
     *
     * @return balance
     **/
    @Schema(description = "")

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(this.account, account.account) &&
                Objects.equals(this.debitCount, account.debitCount) &&
                Objects.equals(this.creditCount, account.creditCount) &&
                Objects.equals(this.balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, debitCount, creditCount, balance);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Account {\n");

        sb.append("    account: ").append(toIndentedString(account)).append("\n");
        sb.append("    debitCount: ").append(toIndentedString(debitCount)).append("\n");
        sb.append("    creditCount: ").append(toIndentedString(creditCount)).append("\n");
        sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
