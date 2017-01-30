package com.abm.investments.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "investments")
public class Investment {

    public enum Type {
        SIP, MONTHLY, QUARTERLY, ADHOC
    }

    @Id
    private String id;
    private String name;
    private Amount amount;
    private Type type;

    public Investment(String name, Amount amount, Type type) {
        this.name = name;
        this.amount = amount;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Investment{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", type=" + type +
                '}';
    }
}
