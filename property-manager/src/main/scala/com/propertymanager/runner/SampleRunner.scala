package com.propertymanager.runner

import com.propertymanager.domain.Investment

object SampleRunner {

  def main(args: Array[String]): Unit = {
    val investment = new Investment("Ronnie", 1200)
    println(s" ID : ${investment.amount}")
  }

}
