package com.billing.resources

import javax.ws.rs._
import javax.ws.rs.core.{MediaType, Response}

import com.billing.dtos.BillingDto
import com.billing.services.BillingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
@Path("bills")
@Consumes(Array(MediaType.APPLICATION_JSON))
@Produces(Array(MediaType.APPLICATION_JSON))
class BillingResource(@Autowired val billingService: BillingService) {

  @POST
  def create(billingDto: BillingDto): Response = Response.ok(billingService.create(billingDto)).build()

  @GET
  def getAll() = Response.ok(billingService.fetchAll()).build()

  @PUT
  def update(billingDto: BillingDto): Response = {
    billingService.update(billingDto)
    Response.status(Response.Status.NO_CONTENT).build()
  }

  @DELETE
  @Path("{id}")
  def delete(@PathParam("id") id: String) = {
    billingService.delete(id)
    Response.noContent().build()
  }

  @GET
  @Path("status")
  def getStatus(): Response = Response.ok(billingService.getStatus()).build()

}
