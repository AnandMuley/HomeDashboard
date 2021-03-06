package com.propertymanager.repositories

import com.propertymanager.domain.Payment
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
trait PaymentRepository extends MongoRepository[Payment, String] {

}
