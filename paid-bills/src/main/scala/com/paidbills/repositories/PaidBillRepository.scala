package com.paidbills.repositories

import com.paidbills.dtos.BillDto
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
trait PaidBillRepository extends MongoRepository[BillDto, String] {

}
