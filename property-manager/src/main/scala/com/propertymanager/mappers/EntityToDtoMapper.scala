package com.propertymanager.mappers

import com.propertymanager.domain.{PaymentItem, PaymentScheduleSummary}
import com.propertymanager.dtos.{PaymentItemDto, PaymentScheduleDto}

import scala.collection.JavaConverters._

object EntityToDtoMapper {

  def map(paymentScheduleSummary: PaymentScheduleSummary): PaymentScheduleDto = {
    new PaymentScheduleDto(paymentScheduleSummary.propertyName, paymentScheduleSummary.items.asScala.map(sch => map(sch)).toList.asJava)
  }

  def map(paymentItem: PaymentItem): PaymentItemDto = new PaymentItemDto(
    paymentItem.paymentNumber,
    paymentItem.amount,
    paymentItem.description
  )

}
