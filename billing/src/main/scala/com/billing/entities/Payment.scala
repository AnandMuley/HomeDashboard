package com.billing.entities

import java.util.Date

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import scala.beans.BeanProperty

@Document(collection = "payments")
class Payment(
               @BeanProperty val billId: String,
               @BeanProperty val paymentDate: Date,
               @BeanProperty val amount: Double,
               @BeanProperty val isPaid: Boolean) {

  @Id
  @BeanProperty
  var id: String = null

}
