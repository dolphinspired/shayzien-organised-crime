package com.dylange.organisedcrime.models;

public class GangInfo {
    private String locationMessage;
    private String timeMessage;
    private int world;
    private long timeRead;
    private OrganisedCrimeLocation correspondingLocation;

    public GangInfo(String locationMessage, String timeMessage, int world, long timeRead) {
        this.locationMessage = locationMessage;
        this.timeMessage = timeMessage;
        this.world = world;
        this.timeRead = timeRead;
    }

    public String getLocationMessage() {
        return locationMessage;
    }

    public String getTimeMessage() {
        return timeMessage;
    }

    public int getWorld() {
        return world;
    }

    public long getTimeRead() {
        return timeRead;
    }

    public OrganisedCrimeLocation getLocation() throws IllegalStateException {
        if (correspondingLocation != null) return correspondingLocation;

        for (OrganisedCrimeLocation loc : OrganisedCrimeLocations.allLocations) {
            if (loc.getLocationMessage().equals(this.locationMessage)) {
                correspondingLocation = loc;
            }
        }
        if (correspondingLocation != null) {
            return correspondingLocation;
        } else {
            throw new IllegalStateException("Corresponding location info not found for data read from information board.");
        }
    }
}
