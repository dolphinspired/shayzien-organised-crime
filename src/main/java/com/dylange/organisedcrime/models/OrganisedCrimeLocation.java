package com.dylange.organisedcrime.models;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganisedCrimeLocation that = (OrganisedCrimeLocation) o;
        return isMultiCombat == that.isMultiCombat &&
                locationMessage.equals(that.locationMessage) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationMessage, description, isMultiCombat);
    }
}
