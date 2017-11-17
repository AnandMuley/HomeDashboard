package com.propertymanager.dtos

import com.fasterxml.jackson.annotation.{JsonCreator, JsonProperty}

import scala.beans.BeanProperty

class PaymentItemDto @JsonCreator()(
                                     @BeanProperty @JsonProperty("paymentNumber") val paymentNumber: String,
                                     @BeanProperty @JsonProperty("amount") val amount: Double,
                                     @BeanProperty @JsonProperty("description") val description: String
                                   ) {

}
