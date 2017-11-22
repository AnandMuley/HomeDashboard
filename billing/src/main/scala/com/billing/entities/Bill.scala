package com.billing.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import scala.beans.BeanProperty
import java.util.Date

@Document(collection = "bills")
class Bill(
            @BeanProperty val billingType: String,
            @BeanProperty val frequency: String,
            @BeanProperty val notes: String,
            @BeanProperty val billDate: Date
          ) {

  @Id
  @BeanProperty
  var id: String = null

}
