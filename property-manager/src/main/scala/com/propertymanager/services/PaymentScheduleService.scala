package com.propertymanager.services

import com.propertymanager.domain.{PaymentSchedule, PaymentScheduleSummary}
import com.propertymanager.dtos.PaymentScheduleSummaryDto
import com.propertymanager.repositories.PaymentScheduleSummaryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import scala.collection.JavaConverters._

@Component
class PaymentScheduleService(@Autowired paymentScheduleSummaryRepository: PaymentScheduleSummaryRepository) {

  def add(paymentScheduleSummaryDto: PaymentScheduleSummaryDto): PaymentScheduleSummary = {
    val items = paymentScheduleSummaryDto.items.asScala.map(it => new PaymentSchedule(it.paymentNumber, it.amount, it.description)).asJava
    paymentScheduleSummaryRepository.save(
      new PaymentScheduleSummary(paymentScheduleSummaryDto.propertyName, items)
    )
  }
}
