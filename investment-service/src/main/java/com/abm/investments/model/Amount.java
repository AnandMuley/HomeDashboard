package com.abm.investments.model;

public class Amount {

    private Double value;
    private String currency = "INR";

    public Amount(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public String getCurrency() {
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
