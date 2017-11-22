package com.paidbills.dtos

import java.util.Date

import com.fasterxml.jackson.annotation.{JsonCreator, JsonFormat, JsonProperty}
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import scala.beans.BeanProperty

@Document(collection = "paidbills")
class BillDto @JsonCreator()(
                              @BeanProperty @JsonProperty("billNumber") val billNumber: String,
                              @BeanProperty @JsonProperty("billAmount") val billAmount: Double,
                              @BeanProperty @JsonProperty("description") val description: String,
                              @BeanProperty @JsonProperty("billDate") @JsonFormat(pattern="dd-MMM-yyyy") val billDate: Date
                            ) {
  @Id
  @BeanProperty
  val id: String = null

}
