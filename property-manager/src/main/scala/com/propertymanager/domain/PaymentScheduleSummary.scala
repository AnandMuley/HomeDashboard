package com.propertymanager.domain

import java.util._

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "paymentschedule")
class PaymentScheduleSummary(val propertyName: String, val items: List[PaymentSchedule]) {

  @Id
  private val id: String = null

  def getId() = id

}
