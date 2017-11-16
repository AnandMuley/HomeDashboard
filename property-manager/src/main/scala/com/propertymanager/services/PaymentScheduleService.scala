package com.propertymanager.services

import com.propertymanager.domain.PaymentSchedule
import com.propertymanager.repositories.PaymentScheduleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class PaymentScheduleService(@Autowired paymentScheduleRepository: PaymentScheduleRepository) {

  def add(paymentSchedule: PaymentSchedule): PaymentSchedule = {
    paymentScheduleRepository.save(paymentSchedule);
  }
}
