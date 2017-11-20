package com.paidbills.services

import java.time.{LocalDate, ZoneId}
import java.util.Date

import com.paidbills.dtos.BillDto
import com.paidbills.repositories.PaidBillRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PaidBillService(@Autowired val paidBillRepo: PaidBillRepository) {

  def getDeatils(lastOneMonth: Boolean) = {
    if (lastOneMonth) {
      val date1 = LocalDate.now().minusMonths(1L);
      paidBillRepo.findByBillDateGreaterThan(Date.from(
        date1.atStartOfDay(
          ZoneId.of("America/Montreal")
        ).toInstant()
      ));
    } else {
      paidBillRepo.findAll();
    }
  }

  def save(billDto: BillDto) = paidBillRepo.save(billDto);

}
