package com.sc.sc.model;

public enum role {
    ADMIN("Admin"),
    CUSTOMER("Customer"),
    DELIVERY_STATION("Delivery_Station");

    private final String displayName;

    role(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}