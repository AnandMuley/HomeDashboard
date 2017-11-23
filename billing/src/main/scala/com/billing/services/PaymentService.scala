package com.billing.services

import java.util.Date

import com.billing.dtos.PaymentDto
import com.billing.entities.Payment
import com.billing.repositories.PaymentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import scala.collection.JavaConverters._

@Service
class PaymentService(@Autowired paymentRepository: PaymentRepository) {

  def getStatus(billId: String, startDate: Date, endDate: Date): PaymentDto = {
    val payment = paymentRepository.findByBillIdAndPaymentDateBetween(billId, startDate, endDate)
    var dto: PaymentDto = null
    if (payment != null) {
      dto = new PaymentDto(payment.billId, payment.paymentDate, payment.amount, payment.isPaid)
    }
    dto
  }

  def create(paymentDto: PaymentDto) = {
    val payment = new Payment(paymentDto.billId, paymentDto.paymentDate, paymentDto.amount, paymentDto.isPaid)
    paymentRepository.save(payment)
  }

  def fetchAll() = {
    val payments = paymentRepository.findAll()
    payments.asScala.map(payment => new PaymentDto(payment.billId, payment.paymentDate, payment.amount, payment.isPaid)).asJava
  }

}
