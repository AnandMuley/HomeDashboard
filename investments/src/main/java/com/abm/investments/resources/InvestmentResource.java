package com.abm.investments.resources;

import com.abm.investments.dtos.InvestmentDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.UUID;

@Path("investments")
public class InvestmentResource {

    @GET
    public Response getAll() {
        return Response.ok(Arrays.asList(new InvestmentDto(UUID.randomUUID().toString(), "LIC"), new InvestmentDto(UUID.randomUUID().toString(), "Mutual Funds"))).build();
    }

}
