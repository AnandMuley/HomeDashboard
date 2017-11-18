package com.propertymanager.dtos

import java.util._

import com.fasterxml.jackson.annotation.{JsonCreator, JsonProperty}

import scala.beans.BeanProperty

class PaymentScheduleDto @JsonCreator()(
                                                @BeanProperty @JsonProperty("propertyName") val propertyName: String,
                                                @BeanProperty @JsonProperty("items") val items: List[PaymentItemDto]=new ArrayList[PaymentItemDto]()) {

}
