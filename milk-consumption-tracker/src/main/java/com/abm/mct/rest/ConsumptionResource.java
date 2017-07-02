package com.abm.mct.rest;

import com.abm.mct.model.Consumption;
import com.abm.mct.repository.ConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("consumption")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ConsumptionResource {

  @Autowired
  private ConsumptionRepository consumptionRepository;

  @POST
  public Response create(Consumption consumption) {
    return Response.ok(consumptionRepository.save(consumption)).build();
  }

  @GET
  public Response getAll() {
    return Response.ok(consumptionRepository.findAll()).build();
  }

  @PUT
  public Response update(Consumption consumption) {
    consumptionRepository.save(consumption);
    return Response.noContent().build();
  }

}
