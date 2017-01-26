package com.abm.investments.model;

import java.util.Currency;

public class Amount {

    private Double value;
    private Currency currency;

    public Amount(Double value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public Double getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "value=" + value +
                ", currency=" + currency +
                '}';
    }
}
