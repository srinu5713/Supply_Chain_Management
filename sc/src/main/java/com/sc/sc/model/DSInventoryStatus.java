
package com.sc.sc.model;

public enum DSInventoryStatus {
    
    CANCELLED("cancelled"),
    RETURNED("returned");

    private final String displayName;

    DSInventoryStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
