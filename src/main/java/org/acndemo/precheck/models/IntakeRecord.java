package org.acndemo.precheck.models;

import java.time.LocalDate;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class IntakeRecord extends PanacheMongoEntity {
    private String claimNumber;
    private String entryId;
    private LocalDate recordDate;
    
    public String getClaimNumber() {
        return claimNumber;
    }
    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }
    public String getEntryId() {
        return entryId;
    }
    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }
    public LocalDate getRecordDate() {
        return recordDate;
    }
    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    
}
