package com.propertymanager.resources

import java.io.IOException
import javax.ws.rs._
import javax.ws.rs.core.{MediaType, Response}

import com.propertymanager.dtos.{PaymentScheduleSummaryDto, ResponseDto}
import com.propertymanager.exceptions.{NoPaymentScheduleFoundException, ScheduleAlreadyExistsException}
import com.propertymanager.services.PaymentScheduleService
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
      Response.ok(paymentScheduleService.createIfNotExists(paymentScheduleSummaryDto)).build()
    } catch {
      case ex: ScheduleAlreadyExistsException => {
        Response.status(Response.Status.BAD_REQUEST).entity(new ResponseDto(ex getMessage)).build()
      }
      case ex: Exception => {
        Response.serverError().build()
      }
    }
  }

  @GET
  @Path("{propertyName}")
  def getScheduleByPropertyName(@PathParam("propertyName") propertyName: String): Response = {
    try {
      Response.ok(paymentScheduleService.findByPropertyName(propertyName)).build()
    } catch {
      case ex: NoPaymentScheduleFoundException => {
        Response.status(Response.Status.NOT_FOUND).entity("No record found").build()
      }
      case ex: Exception => {
        Response.serverError().build()
      }
    }
  }

}
