package org.acndemo.precheck.client;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acndemo.precheck.models.StateMachineRecord;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Singleton
@Path("/StateMachine")
@RegisterRestClient
public interface StateMachineRecordClient {

    @GET
    @Path("/{claimNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    StateMachineRecord getStatus(@PathParam("claimNumber") String cno);
}

