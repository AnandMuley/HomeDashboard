package com.billing.repositories

import com.billing.entities.Payment
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.Date
import java.util.List

@Repository
trait PaymentRepository extends MongoRepository[Payment, String] {

  def findByBillIdAndPaymentDateBetween(billId: String, startDate: Date, endDate: Date): Payment

}
