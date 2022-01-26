package org.acndemo.precheck.client;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acndemo.precheck.models.IntakeRecord;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Singleton
@Path("/IntakeRecord")
@RegisterRestClient
public interface IntakeRecordClient {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<IntakeRecord> list();
}
