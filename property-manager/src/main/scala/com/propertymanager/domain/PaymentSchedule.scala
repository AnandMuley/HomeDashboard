package com.propertymanager.domain

import com.fasterxml.jackson.annotation.{JsonCreator, JsonProperty}
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import scala.beans.BeanProperty

@Document(collection = "paymentschedule")
class PaymentSchedule @JsonCreator()(@BeanProperty @JsonProperty("paymentNumber") val paymentNumber: String, @BeanProperty @JsonProperty("amount") val amount: Double, @BeanProperty @JsonProperty("description") val description: String) {

  @Id
  private val id: String = null;

  def getId(): String = {
    id
  }

}
