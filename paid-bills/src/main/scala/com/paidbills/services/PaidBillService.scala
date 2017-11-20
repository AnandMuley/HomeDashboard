package com.paidbills.services

import com.paidbills.dtos.BillDto
import com.paidbills.repositories.PaidBillRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PaidBillService(@Autowired val paidBillRepo : PaidBillRepository ){

  def getDeatils() = {
    paidBillRepo.findAll();
  }

  def save(billDto: BillDto) = paidBillRepo.save(billDto);

}
