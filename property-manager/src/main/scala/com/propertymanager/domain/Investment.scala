package com.propertymanager.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "investments")
class Investment(var itsType: String,var amount: Double) {

  @Id
  private val id: String = null

  override def toString = s"Investment($id, $itsType, $amount)"
}
