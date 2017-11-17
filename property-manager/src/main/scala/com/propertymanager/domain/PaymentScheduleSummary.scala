package com.propertymanager.domain

import java.util._

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import scala.beans.BeanProperty

@Document(collection = "paymentschedule")
class PaymentScheduleSummary(@BeanProperty var propertyName: String, val items: List[PaymentSchedule]) {

  @Id
  private val id: String = null

  def getId() = id

}
