package com.sc.sc.model;

public enum Status {
    SHIPPED("shipped"),
    CANCELLED("cancelled"),
    RETURNED("returned"),
    DELIVERED("delivered"),
    ACCEPTED("accepted"),
    OUT_FOR_DELIVERY("out_for_delivery");
    
    private final String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

