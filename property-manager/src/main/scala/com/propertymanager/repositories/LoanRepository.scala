package com.propertymanager.repositories

import com.propertymanager.domain.Loan
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
trait LoanRepository extends MongoRepository[Loan, String] {

}
