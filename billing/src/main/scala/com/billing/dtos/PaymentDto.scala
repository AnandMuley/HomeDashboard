package com.billing.dtos

import java.util.Date

import com.fasterxml.jackson.annotation.{JsonCreator, JsonFormat, JsonProperty}

import scala.beans.BeanProperty

class PaymentDto @JsonCreator()(
                                 @BeanProperty @JsonProperty("billId") val billId: String,
                                 @BeanProperty @JsonProperty("paymentDate") @JsonFormat(pattern = "dd-MMM-yyyy") val paymentDate: Date,
                                 @BeanProperty @JsonProperty("amount") val amount: Double,
                                 @BeanProperty @JsonProperty("paid") val paid: Boolean = true) {

  @BeanProperty
  def id: String = null

}
