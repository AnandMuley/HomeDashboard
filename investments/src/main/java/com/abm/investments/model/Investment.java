package com.abm.investments.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "investments")
public class Investment {

    @Id
    private String id;
    private String name;
    private Amount amount;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Amount getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Investment{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
