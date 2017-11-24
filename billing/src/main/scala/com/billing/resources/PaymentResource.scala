package com.billing.resources

import javax.ws.rs._
import javax.ws.rs.core.{MediaType, Response}

import com.billing.dtos.PaymentDto
import com.billing.services.PaymentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
@Path("payments")
@Consumes(Array(MediaType.APPLICATION_JSON))
@Produces(Array(MediaType.APPLICATION_JSON))
class PaymentResource(@Autowired val paymentService: PaymentService) {

  @POST
  def create(paymentDto: PaymentDto) = Response.ok(paymentService.create(paymentDto)).build()

  @GET
  def getAll() = Response.ok(paymentService.fetchAll()).build()

  @PUT
  def update(paymentDto: PaymentDto) = {
    paymentService.update(paymentDto)
    Response.noContent().build()
  }

  @DELETE
  @Path("{id}")
  def delete(@PathParam("id") id: String) = {
    paymentService.delete(id)
    Response.noContent().build()
  }

}
