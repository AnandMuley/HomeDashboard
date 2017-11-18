package com.propertymanager.domain

import java.util.Date

import com.fasterxml.jackson.annotation.{JsonCreator, JsonFormat, JsonProperty}
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import scala.beans.BeanProperty

@Document(collection = "payments")
class Payment @JsonCreator()(@BeanProperty @JsonProperty("recipient") val recipient: String,
                             @BeanProperty @JsonProperty("amount") val amount: Double,
                             @BeanProperty @JsonProperty("mode") val mode: String,
                             @BeanProperty @JsonProperty("date") @JsonFormat(pattern = "dd-MMM-yyyy") val date: Date,
                             @BeanProperty @JsonProperty("fromAccount") val fromAccount: String
                            ) {

  @Id
  @BeanProperty
  val id: String = null

  override def toString = s"Payment($id, $recipient, $amount, $mode, $date, $fromAccount)"

}
