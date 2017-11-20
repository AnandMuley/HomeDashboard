package com.paidbills.resources

import javax.ws.rs.core.{MediaType, Response}
import javax.ws.rs.{QueryParam, _}

import com.paidbills.dtos.BillDto
import com.paidbills.services.PaidBillService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
@Path("bills")
@Consumes(Array(MediaType.APPLICATION_JSON))
@Produces(Array(MediaType.APPLICATION_JSON))
class PaidBillResource(@Autowired val paidBillService: PaidBillService) {

  @GET
  def getAll(@QueryParam("lastOneMonth") lastOneMonth: Boolean): Response = {
    Response.ok(paidBillService.getDeatils(lastOneMonth)).build()
  }

  @POST
  def addNew(billDto: BillDto): Response = {
    Response.ok(paidBillService.save(billDto)).build();
  }

}
