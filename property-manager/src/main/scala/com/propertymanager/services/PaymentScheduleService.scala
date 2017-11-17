package com.propertymanager.services

import com.propertymanager.domain.{PaymentSchedule, PaymentScheduleSummary}
import com.propertymanager.dtos.PaymentScheduleSummaryDto
import com.propertymanager.exceptions.{NoPaymentScheduleFoundException, ScheduleAlreadyExistsException}
import com.propertymanager.repositories.PaymentScheduleSummaryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import com.propertymanager.mappers.EntityToDtoMapper._

import scala.collection.JavaConverters._

@Component
class PaymentScheduleService(@Autowired paymentScheduleSummaryRepository: PaymentScheduleSummaryRepository) {

  def findByPropertyName(propertyName: String): PaymentScheduleSummaryDto = {

    Option.apply(paymentScheduleSummaryRepository.findByPropertyName(propertyName)) match {
      case Some(paymentScheduleSummary) => map(paymentScheduleSummary)
      case None => throw new NoPaymentScheduleFoundException
    }

  }

  def createIfNotExists(paymentScheduleSummaryDto: PaymentScheduleSummaryDto): PaymentScheduleSummary = {

    Option.apply(paymentScheduleSummaryRepository.findByPropertyName(paymentScheduleSummaryDto.propertyName)) match {
      case Some(summary) => throw new ScheduleAlreadyExistsException("Schedule already exist")
      case None => {
        val items = paymentScheduleSummaryDto.items.asScala.map(it => new PaymentSchedule(it.paymentNumber, it.amount, it.description)).asJava

        paymentScheduleSummaryRepository.save(
          new PaymentScheduleSummary(paymentScheduleSummaryDto.propertyName, items)
        )

      }
    }


  }
}
