package com.paidbills.resources

import java.io.InputStream
import javax.ws.rs.core.{MediaType, Response}
import javax.ws.rs.{QueryParam, _}

import com.paidbills.dtos.BillDto
import com.paidbills.services.PaidBillService
import org.glassfish.jersey.media.multipart.{FormDataContentDisposition, FormDataParam}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
@Path("bills")
@Produces(Array(MediaType.APPLICATION_JSON))
class PaidBillResource(@Autowired val paidBillService: PaidBillService) {

  @GET
  @Consumes(Array(MediaType.APPLICATION_JSON))
  def getAll(@QueryParam("lastOneMonth") lastOneMonth: Boolean): Response = {
    Response.ok(paidBillService.getDeatils(lastOneMonth)).build()
  }

  @POST
  @Consumes(Array(MediaType.APPLICATION_JSON))
  def addNew(billDto: BillDto): Response = {
    Response.ok(paidBillService.save(billDto)).build();
  }

  @POST
  @Consumes(Array(MediaType.MULTIPART_FORM_DATA))
  @Path("/uploadbills")
  def upload(@FormDataParam("file") uploadedInputStream: InputStream, @FormDataParam("file") fileDetail: FormDataContentDisposition): Response = {
    Response.ok(paidBillService.upload(uploadedInputStream, fileDetail)).build();
  }

}
