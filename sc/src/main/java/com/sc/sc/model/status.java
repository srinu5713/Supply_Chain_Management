package com.sc.sc.model;

public enum status {
    SHIPPED("Shipped"),
    CANCELLED("Cancelled"),
    RETURNED("Returned"),
    DELIVERED("Delivered");

    private final String displayName;

    status(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
