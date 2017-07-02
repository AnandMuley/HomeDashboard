package com.abm.mct.model;

public class Product {

  private String id;
  private String name;

  public Product(String name, String id) {
    this.name = name;
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Product{" +
      "id='" + id + '\'' +
      ", name='" + name + '\'' +
      '}';
  }
}
