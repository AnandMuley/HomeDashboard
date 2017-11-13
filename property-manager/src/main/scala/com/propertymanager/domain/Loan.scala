package com.propertymanager.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "loans")
class Loan(bankName: String, loanAmount: Double) {

  @Id
  private val id: String = null

  def getId(): String = {
    id
  }


  override def toString = s"Loan($id,$bankName,$Double)"

}
