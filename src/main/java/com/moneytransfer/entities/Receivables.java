package com.moneytransfer.entities;

import com.google.common.base.Objects;
import com.moneytransfer.models.transaction.ReceivablesCreateRequest;
import org.javamoney.moneta.Money;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "receivables")
public class Receivables {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_id")
    private Long accountId;

    private BigDecimal amount;

    private String currency;

    public Receivables() {
    }

    public Receivables(ReceivablesCreateRequest receivablesCreateRequest) {
        Money money = Money.of(receivablesCreateRequest.getAmount(), receivablesCreateRequest.getCurrency());
        this.accountId = receivablesCreateRequest.getAccountId();
        this.amount = BigDecimal.valueOf(money.getNumber().doubleValueExact());
        this.currency = money.getCurrency().getCurrencyCode();
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "account_id")
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Receivables)) return false;
        Receivables that = (Receivables) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(accountId, that.accountId) &&
                Objects.equal(amount, that.amount) &&
                Objects.equal(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, accountId, amount, currency);
    }

    @Override
    public String toString() {
        return "Receivables{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

}
