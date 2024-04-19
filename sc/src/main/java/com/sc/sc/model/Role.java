package com.sc.sc.model;

public enum Role {
    ADMIN("Admin"),
    CUSTOMER("Customer"),
    PRODUCTION("Production"),
    DELIVERY_STATION("Delivery_Station");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}


