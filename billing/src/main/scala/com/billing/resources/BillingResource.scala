package com.billing.resources

import javax.ws.rs.core.{MediaType, Response}
import javax.ws.rs.{Consumes, POST, Path, Produces}

import com.billing.dtos.BillingDto
import org.springframework.stereotype.Component

@Component
@Path("bills")
@Consumes(Array(MediaType.APPLICATION_JSON))
@Produces(Array(MediaType.APPLICATION_JSON))
class BillingResource {

  @POST
  def create(billingDto: BillingDto): Response = Response.ok(billingDto).build()

}
