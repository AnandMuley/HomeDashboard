package com.propertymanager.dtos

import scala.beans.BeanProperty
import java.util._

import com.propertymanager.domain.Payment

class Summary(@BeanProperty val items: List[Payment], @BeanProperty val total: Double) {

}
