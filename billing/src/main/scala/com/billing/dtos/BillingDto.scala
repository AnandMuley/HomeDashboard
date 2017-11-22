package com.billing.dtos

import java.util.Date

import com.fasterxml.jackson.annotation.{JsonCreator, JsonFormat, JsonProperty}

import scala.beans.BeanProperty

class BillingDto @JsonCreator()(
                                 @BeanProperty @JsonProperty("billingType") val billType: String,
                                 @BeanProperty @JsonProperty("frequency") val frequency: String,
                                 @BeanProperty @JsonProperty("billDate") @JsonFormat(pattern = "dd-MMM-yyyy") val billDate: Date) {

}