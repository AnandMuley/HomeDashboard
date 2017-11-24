package com.billing.services

import java.util.Date

import com.billing.dtos.PaymentDto
import com.billing.dtos.response.PaymentResponseDto
import com.billing.entities.Payment
import com.billing.repositories.{BillingRepository, PaymentRepository}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import scala.collection.JavaConverters._

@Service
class PaymentService(@Autowired paymentRepository: PaymentRepository, @Autowired billingRepository: BillingRepository) {

  def getStatus(billId: String, startDate: Date, endDate: Date): PaymentDto = {
    val payment = paymentRepository.findByBillIdAndPaymentDateBetween(billId, startDate, endDate)
    var dto: PaymentDto = null
    if (payment != null) {
      dto = new PaymentDto(payment.billId, payment.paymentDate, payment.amount, payment.isPaid)
    }
    dto
  }

  def getPaymentStatus(isPaid: Boolean): String = if (isPaid) "PAID" else "UNPAID"

  def create(paymentDto: PaymentDto) = {
    val payment = new Payment(paymentDto.billId, paymentDto.paymentDate, paymentDto.amount, true)
    paymentRepository.save(payment)
  }

  def update(paymentDto: PaymentDto) = {
    val payment = new Payment(paymentDto.billId, paymentDto.paymentDate, paymentDto.amount, paymentDto.paid)
    payment.id = paymentDto.id
    paymentRepository.save(payment)
  }

  def delete(id: String) = paymentRepository.delete(id)

  def fetchAll() = {
    val payments = paymentRepository.findAll()
    payments.asScala.map(payment => {
      var dto = new PaymentResponseDto(payment.billId, payment.paymentDate, payment.amount, payment.isPaid)
      dto.id = payment.id
      dto.billName = billingRepository.findOne(dto.billId).notes
      dto
    }).asJava
  }

}
