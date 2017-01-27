package com.abm.investments.dtos;

import java.util.Currency;

public class InvestmentDto {

    private String id;
    private String name;
    private Double amount;

    public InvestmentDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public InvestmentDto(String name, Double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "InvestmentDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
