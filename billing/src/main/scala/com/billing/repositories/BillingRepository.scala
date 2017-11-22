package com.billing.repositories

import com.billing.entities.Bill
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
trait BillingRepository extends MongoRepository[Bill, String] {

}
