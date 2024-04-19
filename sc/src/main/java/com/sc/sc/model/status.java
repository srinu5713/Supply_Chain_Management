package com.sc.sc.model;

public enum status {
    SHIPPED("shipped"),
    CANCELLED("cancelled"),
    RETURNED("returned"),
    DELIVERED("delivered"),
    ACCEPTED("accepted"),
    OUT_FOR_DELIVERY("out_for_delivery");
    
    private final String displayName;

    status(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

