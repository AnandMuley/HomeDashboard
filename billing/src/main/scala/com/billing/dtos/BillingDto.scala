package com.billing.dtos

import java.time.LocalDate
import java.util._

class BillingDto(id: String, billType: String, frequency: String,
                 billDate: LocalDate, payments: List[PaymentDto]) {

}
