package com.dylange.organisedcrime.models;

public class OrganisedCrimeLocation {

    private String locationMessage;
    private String description;
    private boolean isMultiCombat;

    public OrganisedCrimeLocation(String locationMessage, String description, boolean isMultiCombat) {
        this.locationMessage = locationMessage;
        this.description = description;
        this.isMultiCombat = isMultiCombat;
    }

    public String getLocationMessage() {
        return locationMessage;
    }

    public String getDescription() {
        return description;
    }

    public boolean isMultiCombat() {
        return isMultiCombat;
    }
}
