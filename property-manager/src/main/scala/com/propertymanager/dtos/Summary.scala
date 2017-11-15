package com.propertymanager.dtos

import com.propertymanager.model.Payment

import scala.beans.BeanProperty
import java.util._

class Summary(@BeanProperty val items: List[Payment], @BeanProperty val total: Double) {

}
