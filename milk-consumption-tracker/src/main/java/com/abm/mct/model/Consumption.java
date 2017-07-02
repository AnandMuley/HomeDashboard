package com.abm.mct.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "consumptions")
public class Consumption {

  @Id
  private String id;
  private String productName;
  private Double quantity;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private Date consumedOn;

  public Consumption() {
    this.productName = "MILK";
    this.consumedOn = new Date();
  }

  public Consumption(Double quantity) {
    this();
    this.quantity = quantity;
  }

  public String getId() {
    return id;
  }

  public String getProductName() {
    return productName;
  }

  public Double getQuantity() {
    return quantity;
  }

  public Date getConsumedOn() {
    return consumedOn;
  }

  @Override
  public String toString() {
    return "Consumption{" +
      "id='" + id + '\'' +
      ", productName='" + productName + '\'' +
      ", quantity=" + quantity +
      ", consumedOn=" + consumedOn +
      '}';
  }
}
