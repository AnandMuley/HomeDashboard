package com.propertymanager.services

import java.util

import com.propertymanager.model.Payment
import com.propertymanager.repositories.PaymentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PaymentService(@Autowired paymentRepository: PaymentRepository) {

  def save(payment: Payment): Payment = paymentRepository.save(payment)

  def getDetails(): util.List[Payment] = paymentRepository.findAll()

}
