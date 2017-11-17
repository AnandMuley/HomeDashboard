package com.propertymanager.mappers

import com.propertymanager.domain.{PaymentSchedule, PaymentScheduleSummary}
import com.propertymanager.dtos.{PaymentItemDto, PaymentScheduleSummaryDto}

import scala.collection.JavaConverters._

object EntityToDtoMapper {

  def map(paymentScheduleSummary: PaymentScheduleSummary): PaymentScheduleSummaryDto = {
    new PaymentScheduleSummaryDto(paymentScheduleSummary.propertyName, paymentScheduleSummary.items.asScala.map(sch => map(sch)).toList.asJava)
  }

  def map(paymentSchedule: PaymentSchedule): PaymentItemDto = new PaymentItemDto(
    paymentSchedule.paymentNumber,
    paymentSchedule.amount,
    paymentSchedule.description
  )

}
