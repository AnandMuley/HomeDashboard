package com.propertymanager.services

import com.propertymanager.domain.Payment
import com.propertymanager.dtos.Summary
import com.propertymanager.repositories.PaymentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import scala.collection.JavaConverters._

@Service
class PaymentService(@Autowired paymentRepository: PaymentRepository) {

  def save(payment: Payment) = paymentRepository.save(payment)

  def delete(id: String) = paymentRepository.delete(id)

  def getDetails() = {
    val payments = paymentRepository.findAll()
    val total = payments.asScala.toList.map(p => p.getAmount).sum
    new Summary(payments, total)
  }

}
