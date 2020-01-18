package com.moneytransfer.entities;

import com.moneytransfer.models.transaction.PayablesCreateRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNull;

public class PayablesTest {

    @Test
    public void testPayablesDefaultConstructor() {
        Long id = 1L;
        Long accountId = 2L;
        BigDecimal amount = BigDecimal.valueOf(10.50);
        String currency = "EUR";

        Payables payables = new Payables();
        payables.setId(id);
        payables.setAccountId(accountId);
        payables.setAmount(amount);
        payables.setCurrency(currency);

        assertEquals(id, payables.getId());
        assertEquals(accountId, payables.getAccountId());
        assertEquals(amount, payables.getAmount());
        assertEquals(currency, payables.getCurrency());
    }

    @Test
    public void testPayablesCreateRequestConstructor() {
        Long accountId = 2L;
        BigDecimal amount = BigDecimal.valueOf(10.50);
        String currency = "EUR";

        PayablesCreateRequest payablesCreateRequest = new PayablesCreateRequest();
        payablesCreateRequest.setAccountId(accountId);
        payablesCreateRequest.setAmount(amount);
        payablesCreateRequest.setCurrency(currency);

        Payables payables = new Payables(payablesCreateRequest);

        assertNull(payables.getId());
        assertEquals(accountId, payables.getAccountId());
        assertEquals(amount, payables.getAmount());
        assertEquals(currency, payables.getCurrency());
    }

}
