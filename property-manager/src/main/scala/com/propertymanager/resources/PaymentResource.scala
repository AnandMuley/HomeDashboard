package com.propertymanager.resources

import javax.ws.rs.{GET, Path}
import javax.ws.rs.core.Response
import com.propertymanager.services._

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
@Path("payments")
class PaymentResource(@Autowired val paymentService: PaymentService) {

  @GET
  def ping(): Response = {
    Response.ok(paymentService.getDetails()).build()
  }

}
