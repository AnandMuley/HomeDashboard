package com.propertymanager.resources

import java.io.IOException
import javax.ws.rs.core.{MediaType, Response}
import javax.ws.rs.{Consumes, POST, Path, Produces}

import com.propertymanager.domain.Investment
import com.propertymanager.services.InvestmentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
@Path("investments")
@Consumes(Array(MediaType.APPLICATION_JSON))
@Produces(Array(MediaType.APPLICATION_JSON))
class InvestmentResource(@Autowired val investmentService: InvestmentService) {

  @POST
  def create(investment: Investment): Response = {
    try {
      Response.ok(investmentService.add(investment)).build()
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
