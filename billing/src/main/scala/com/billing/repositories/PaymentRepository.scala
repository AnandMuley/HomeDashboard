package com.billing.repositories

import com.billing.entities.Payment
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
trait PaymentRepository extends MongoRepository[Payment, String] {

}
