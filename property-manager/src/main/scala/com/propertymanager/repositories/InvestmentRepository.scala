package com.propertymanager.repositories

import com.propertymanager.domain.Investment
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
trait InvestmentRepository extends MongoRepository[Investment, String] {

}
