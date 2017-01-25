package com.abm.investments.dtos;

public class InvestmentDto {

    private String id;
    private String name;

    public InvestmentDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public InvestmentDto(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "InvestmentDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
