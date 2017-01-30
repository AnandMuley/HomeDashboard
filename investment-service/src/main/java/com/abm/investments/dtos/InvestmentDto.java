package com.abm.investments.dtos;

import java.time.LocalDate;

public class InvestmentDto {

    private String id;
    private String name;
    private Double amount;
    private LocalDate startDate;
    private LocalDate endDate;
    private String type;

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

    public String getType() {
        return type;
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
