package com.propertymanager.runner

import com.propertymanager.model.Payment

object SampleRunner {

  def main(args: Array[String]): Unit = {
    val payment = new Payment("Online")
    println(s" ID : ${payment.getId()}")
  }

}
