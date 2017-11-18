package com.propertymanager.repositories

import com.propertymanager.domain.PaymentItem
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
trait PaymentScheduleRepository extends MongoRepository[PaymentItem, String] {

}
