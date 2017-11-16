package com.propertymanager.resources

import java.io.IOException
import javax.ws.rs.{Consumes, POST, Path, Produces}
import javax.ws.rs.core.{MediaType, Response}

import com.propertymanager.domain.{Investment, PaymentSchedule}
import com.propertymanager.dtos.PaymentScheduleSummaryDto
import com.propertymanager.services.{InvestmentService, PaymentScheduleService}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
@Path("paymentschedules")
@Consumes(Array(MediaType.APPLICATION_JSON))
@Produces(Array(MediaType.APPLICATION_JSON))
class PaymentScheduleResource(@Autowired val paymentScheduleService: PaymentScheduleService) {

  @POST
  def add(paymentScheduleSummaryDto: PaymentScheduleSummaryDto): Response = {
    try {
      Response.ok(paymentScheduleService.add(paymentScheduleSummaryDto)).build()
    } catch {
      case ex: IOException => {
        Response.status(Response.Status.BAD_REQUEST).build()
      }
      case ex: Exception => {
        Response.serverError().build()
      }
    }
  }
}
