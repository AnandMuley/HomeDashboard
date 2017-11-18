package com.propertymanager.mappers

import java.util.List

import com.propertymanager.domain.{PaymentItem, PaymentScheduleSummary}
import com.propertymanager.dtos.{PaymentItemDto, PaymentScheduleDto}

import scala.collection.JavaConverters._

object DtoToEntityMapper {

  def map(paymentScheduleSummaryDto: PaymentScheduleDto): PaymentScheduleSummary = new PaymentScheduleSummary(
    paymentScheduleSummaryDto.getPropertyName,
    map(paymentScheduleSummaryDto.getItems)
  )

  def map(items: List[PaymentItemDto]): List[PaymentItem] = items.asScala.map(dto => map(dto)).asJava

  def map(paymentItemDto: PaymentItemDto): PaymentItem = new PaymentItem(
    paymentItemDto.paymentNumber,
    paymentItemDto.description,
    paymentItemDto.amount
  )

}
