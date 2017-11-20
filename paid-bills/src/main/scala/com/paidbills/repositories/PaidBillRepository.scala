package com.paidbills.repositories

import java.util.Date

import com.paidbills.dtos.BillDto
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
trait PaidBillRepository extends MongoRepository[BillDto, String] {

  def findByBillDateGreaterThan(billDate: Date) : java.util.List[BillDto]
}
