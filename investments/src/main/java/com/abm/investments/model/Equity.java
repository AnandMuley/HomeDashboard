package com.abm.investments.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "equities")
public class Equity {

    @Id
    private String id;
    private String companyName;
    private Amount faceValue;
    private Long noOfShares;
    private Amount marketPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Amount getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(Amount faceValue) {
        this.faceValue = faceValue;
    }

    public Long getNoOfShares() {
        return noOfShares;
    }

    public void setNoOfShares(Long noOfShares) {
        this.noOfShares = noOfShares;
    }

    public Amount getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Amount marketPrice) {
        this.marketPrice = marketPrice;
    }

    @Override
    public String toString() {
        return "Equity{" +
                "id='" + id + '\'' +
                ", companyName='" + companyName + '\'' +
                ", faceValue=" + faceValue +
                ", noOfShares=" + noOfShares +
                ", marketPrice=" + marketPrice +
                '}';
    }
}
