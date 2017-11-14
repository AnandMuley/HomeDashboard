package com.propertymanager.domain

import com.fasterxml.jackson.annotation.{JsonCreator, JsonProperty}
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "investments")
class Investment @JsonCreator()(@JsonProperty("itsType") val itsType: String, @JsonProperty("amount") val amount: Double) {

  @Id
  private val id: String = null

  override def toString = s"Investment($id, $itsType, $amount)"
}
