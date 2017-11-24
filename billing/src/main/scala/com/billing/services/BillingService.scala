package com.billing.services

import java.time.temporal.{TemporalAdjuster, TemporalAdjusters}
import java.time.{LocalDate, ZoneOffset}
import java.util.Date

import com.billing.dtos.BillingDto
import com.billing.entities.Bill
import com.billing.repositories.BillingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import scala.collection.JavaConverters._

@Service
class BillingService(@Autowired val billingRepository: BillingRepository, @Autowired val paymentService: PaymentService) {

  def getById(id: String) = {
    val bill = billingRepository.findOne(id)
    new BillingDto(bill.billingType, bill.frequency, bill.notes, bill.billDate)
  }

  def getStatus() = {
    val startDate = Date.from(LocalDate.now().`with`(TemporalAdjusters.firstDayOfMonth()).atStartOfDay().toInstant(ZoneOffset.UTC))
    val endDate = Date.from(LocalDate.now().`with`(TemporalAdjusters.lastDayOfMonth()).atStartOfDay().toInstant(ZoneOffset.UTC))

    val bills = billingRepository.findAll()

    bills.asScala.map(bi => {
      val payment = paymentService.getStatus(bi.id, startDate, endDate)
      val billingDto = new BillingDto(bi.billingType, bi.frequency, bi.notes, bi.billDate)
      if (payment != null) {
        billingDto.setStatus("PAID")
      }
      billingDto
    }).toList.asJava

  }

  def create(billingDto: BillingDto): BillingDto = {
    val billing = new Bill(billingDto.billType, billingDto.frequency, billingDto.notes, billingDto.billDate)
    billingRepository.save(billing)
    billingDto.id = billing.id
    billingDto
  }

  def update(billingDto: BillingDto) = {
    val bill = new Bill(billingDto.billType, billingDto.frequency, billingDto.notes, billingDto.billDate)
    bill.id = billingDto.id
    billingRepository.save(bill)
  }

  def delete(id: String) = billingRepository.delete(id)

  def fetchAll() = {
    val bills = billingRepository.findAll()
    bills.asScala.toList.map(bill => {
      val billingDto = new BillingDto(bill.billingType, bill.frequency, bill.notes, bill.billDate)
      billingDto.id = bill.id
      billingDto
    }
    ).asJava
  }

}
