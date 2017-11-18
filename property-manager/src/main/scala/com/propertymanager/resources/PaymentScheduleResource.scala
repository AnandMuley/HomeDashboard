package com.propertymanager.resources

import javax.ws.rs._
import javax.ws.rs.core.{MediaType, Response}

import com.propertymanager.dtos.{PaymentScheduleDto, ResponseDto}
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
  def add(paymentScheduleDto: PaymentScheduleDto): Response = {
    try {
      Response.ok(paymentScheduleService.createIfNotExists(paymentScheduleDto)).build()
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
        Response.status(Response.Status.NOT_FOUND).entity(new ResponseDto("No record found")).build()
      }
      case ex: Exception => {
        Response.serverError().build()
      }
    }
  }

  @PUT
  def update(paymentScheduleDto: PaymentScheduleDto): Response = {
    try {
      Response.ok(paymentScheduleService.update(paymentScheduleDto)).build()
    } catch {
      case ex: NoPaymentScheduleFoundException => {
        Response.status(Response.Status.NOT_FOUND).entity(new ResponseDto("No record found")).build()
      }
      case ex: Exception => {
        Response.serverError().build()
      }
    }
  }

}
