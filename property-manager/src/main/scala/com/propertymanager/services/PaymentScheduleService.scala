package com.propertymanager.services

import com.propertymanager.domain.PaymentScheduleSummary
import com.propertymanager.dtos.{PaymentItemDto, PaymentScheduleDto}
import com.propertymanager.exceptions.{NoPaymentScheduleFoundException, ScheduleAlreadyExistsException}
import com.propertymanager.mappers.DtoToEntityMapper
import com.propertymanager.repositories.PaymentScheduleSummaryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import com.propertymanager.mappers.EntityToDtoMapper

import scala.collection.JavaConverters._

@Component
class PaymentScheduleService(@Autowired paymentScheduleSummaryRepository: PaymentScheduleSummaryRepository) {

  def update(paymentScheduleSummaryDto: PaymentScheduleDto) = paymentScheduleSummaryRepository.save(DtoToEntityMapper.map(paymentScheduleSummaryDto))


  def findByPropertyName(propertyName: String): PaymentScheduleDto = {

    Option.apply(paymentScheduleSummaryRepository.findByPropertyName(propertyName)) match {
      case Some(paymentScheduleSummary) => EntityToDtoMapper.map(paymentScheduleSummary)
      case None => throw new NoPaymentScheduleFoundException
    }

  }

  def createIfNotExists(paymentScheduleSummaryDto: PaymentScheduleDto): PaymentScheduleSummary = {

    Option.apply(paymentScheduleSummaryRepository.findByPropertyName(paymentScheduleSummaryDto.propertyName)) match {
      case Some(summary) => throw new ScheduleAlreadyExistsException("Schedule already exist")
      case None => {
        val items = paymentScheduleSummaryDto.items.asScala.map(it => new PaymentItemDto(it.paymentNumber, it.amount, it.description)).asJava

        paymentScheduleSummaryRepository.save(
          new PaymentScheduleSummary(paymentScheduleSummaryDto.propertyName, DtoToEntityMapper.map(items))
        )

      }
    }


  }
}
