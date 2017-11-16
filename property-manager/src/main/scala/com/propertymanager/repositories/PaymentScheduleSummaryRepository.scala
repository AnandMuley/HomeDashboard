package com.propertymanager.repositories

import com.propertymanager.domain.PaymentScheduleSummary
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
trait PaymentScheduleSummaryRepository extends MongoRepository[PaymentScheduleSummary, String] {

}
