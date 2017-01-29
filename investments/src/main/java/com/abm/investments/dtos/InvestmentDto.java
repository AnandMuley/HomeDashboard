package com.abm.investments.dtos;

public class InvestmentDto {

    private String id;
    private String name;
    private Double amount;

    public InvestmentDto() {
    }

    public InvestmentDto(String id, String name) {
        this.id = id;
        this.name = name;
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
