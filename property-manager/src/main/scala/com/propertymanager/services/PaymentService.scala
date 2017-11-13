package com.propertymanager.services

import com.propertymanager.model.Payment
import com.propertymanager.repositories.PaymentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PaymentService(@Autowired paymentRepository: PaymentRepository) {

  def getDetails(): String = {
    val payment = new Payment("Bill Payment")
    paymentRepository.save(payment)
    s"Details Saved Successfully : ${payment.getId()}"
  }

}
