package com.sc.sc.model;

public enum ProductionStatus {

    DISPATCHED("dispatched"),
    DELIVERED("delivered"),
    ACCEPTED("accepted");
 
    
    private final String displayName;

    ProductionStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

