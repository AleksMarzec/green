package io.greentesla.model.generated.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Transaction
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-08T20:52:28.561455274Z[GMT]")


public class Transaction {
    @JsonProperty("debitAccount")
    private String debitAccount = null;

    @JsonProperty("creditAccount")
    private String creditAccount = null;

    @JsonProperty("amount")
    private Float amount = null;

    public Transaction debitAccount(String debitAccount) {
        this.debitAccount = debitAccount;
        return this;
    }

    /**
     * Get debitAccount
     *
     * @return debitAccount
     **/
    @Schema(example = "3.2309111922661937E+25", description = "")

    @Size(min = 26, max = 26)
    public String getDebitAccount() {
        return debitAccount;
    }

    public void setDebitAccount(String debitAccount) {
        this.debitAccount = debitAccount;
    }

    public Transaction creditAccount(String creditAccount) {
        this.creditAccount = creditAccount;
        return this;
    }

    /**
     * Get creditAccount
     *
     * @return creditAccount
     **/
    @Schema(example = "3.107431869813706E+25", description = "")

    @Size(min = 26, max = 26)
    public String getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(String creditAccount) {
        this.creditAccount = creditAccount;
    }

    public Transaction amount(Float amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Get amount
     *
     * @return amount
     **/
    @Schema(description = "")

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transaction transaction = (Transaction) o;
        return Objects.equals(this.debitAccount, transaction.debitAccount) &&
                Objects.equals(this.creditAccount, transaction.creditAccount) &&
                Objects.equals(this.amount, transaction.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(debitAccount, creditAccount, amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Transaction {\n");

        sb.append("    debitAccount: ").append(toIndentedString(debitAccount)).append("\n");
        sb.append("    creditAccount: ").append(toIndentedString(creditAccount)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

