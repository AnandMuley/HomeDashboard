package com.propertymanager.domain

import com.fasterxml.jackson.annotation.{JsonCreator, JsonProperty}
import org.springframework.data.mongodb.core.mapping.Document

import scala.beans.BeanProperty

@Document(collection = "paymentschedule")
class PaymentSchedule @JsonCreator()(
                                      @BeanProperty @JsonProperty("paymentNumber") var paymentNumber: String,
                                      @BeanProperty @JsonProperty("amount") var amount: Double,
                                      @BeanProperty @JsonProperty("description") var description: String) {

}
