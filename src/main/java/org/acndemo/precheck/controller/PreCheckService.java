package org.acndemo.precheck.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acndemo.precheck.models.IntakeRecord;
import org.acndemo.precheck.models.StateMachineRecord;
import org.acndemo.precheck.client.IntakeRecordClient;
import org.acndemo.precheck.client.StateMachineRecordClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/PreCheck")
@Produces(MediaType.APPLICATION_JSON)
public class PreCheckService {
    @Inject
    @RestClient
    IntakeRecordClient intakeClient;

    @Inject
    @RestClient
    StateMachineRecordClient stateClient;

    @GET
    @Path("/validate")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> validateIntakeRecords() {
        List<IntakeRecord> intakeRecords = intakeClient.list();
        List<String> validatedRecords = new ArrayList<String>();
        for(IntakeRecord intake : intakeRecords) {
            StateMachineRecord stateRecord = stateClient.getStatus(intake.getClaimNumber());
            validatedRecords.add(stateRecord.getClaimNumber() + " with status " + stateRecord.getStatus() + " was validated and overpayment record was created");
        }
        return validatedRecords;
    }

    @GET
    @Path("/prechecktest")
    @Produces(MediaType.APPLICATION_JSON)
    public String testValidation()  {
        return "Hello - Validation was successful";
    }

    
}
