package com.abm.investments.resources;

import com.abm.investments.dtos.InvestmentDto;
import com.abm.investments.model.Amount;
import com.abm.investments.model.Investment;
import com.abm.investments.repositories.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("investments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InvestmentResource {

    @Autowired
    private InvestmentRepository investmentRepository;

    @GET
    public Response getAll() {
        return Response.ok(investmentRepository.findAll()).build();
    }

    @POST
    public Response create(InvestmentDto investmentDto) {
        Investment investment = new Investment(investmentDto.getName(), new Amount(investmentDto.getAmount()));
        return Response.ok(investmentRepository.save(investment)).build();
    }

    @PUT
    public void update(Investment investment) {
        investmentRepository.save(investment);
    }

}
