package com.billing.services

import java.util.stream.Collectors

import com.billing.dtos.BillingDto
import com.billing.entities.Bill
import com.billing.repositories.BillingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import scala.collection.JavaConverters._

@Service
class BillingService(@Autowired val billingRepository: BillingRepository) {

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
