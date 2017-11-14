package com.propertymanager.resources

import javax.ws.rs._
import javax.ws.rs.core.{MediaType, Response}

import com.propertymanager.model.Payment
import com.propertymanager.services._
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
@Path("payments")
@Consumes(Array(MediaType.APPLICATION_JSON))
@Produces(Array(MediaType.APPLICATION_JSON))
class PaymentResource(@Autowired val paymentService: PaymentService) {

  @GET
  def getAll(): Response = Response.ok(paymentService.getDetails()).build()

  @POST
  def addNew(payment: Payment): Response = {
    try {
      Response.ok(paymentService.save(payment)).build()
    } catch {
      case ex: Exception => Response.serverError().build()
    }
  }

  @GET
  @Path("/total/{recipient}")
  def totalAmountPaid(@PathParam("recipient") recipient: String) = Response.ok(paymentService.totalAmount)

}
