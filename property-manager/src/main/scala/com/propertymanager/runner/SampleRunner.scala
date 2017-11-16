package com.propertymanager.runner

import com.propertymanager.domain.{Investment, Payment}

object SampleRunner {

  def main(args: Array[String]): Unit = {
    val investment = new Payment("Life Republic",1200,"CHEQUE",new java.util.Date(),"LICHFL")
    println(s" ID : ${investment.id}")
  }

}
