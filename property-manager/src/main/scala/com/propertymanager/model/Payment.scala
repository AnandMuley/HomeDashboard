package com.propertymanager.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "payments")
class Payment(name: String) {

  @Id
  private val id: String = null

  def getId(): String = {
    id
  }

  override def toString: String = {
    s"id : $id, name : $name"
  }

}
