package com.propertymanager.repositories

import com.propertymanager.domain.PaymentSchedule
import org.springframework.data.mongodb.repository.MongoRepository

trait PaymentScheduleRepository extends MongoRepository[PaymentSchedule, String]{

}
