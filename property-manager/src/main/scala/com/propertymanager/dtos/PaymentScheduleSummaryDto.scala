package com.propertymanager.dtos

import com.fasterxml.jackson.annotation.{JsonCreator, JsonProperty}
import com.propertymanager.domain.PaymentSchedule

import scala.beans.BeanProperty
import java.util._

class PaymentScheduleSummaryDto @JsonCreator()(
                                                @BeanProperty @JsonProperty("propertyName") val propertyName: String,
                                                @BeanProperty @JsonProperty("items") val items: List[PaymentSchedule]) {

}
