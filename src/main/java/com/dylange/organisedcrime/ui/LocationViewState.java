package com.dylange.organisedcrime.ui;

import com.dylange.organisedcrime.models.GangExpectedTime;

import java.util.Map;

public class LocationViewState {
    private final String description;
    private final String image;
    private final Map<Integer, GangExpectedTime> worldToGangExpectedTime;

    public LocationViewState(String description, String image, Map<Integer, GangExpectedTime> worldToTimeRemainingText) {
        this.description = description;
        this.image = image;
        this.worldToGangExpectedTime = worldToTimeRemainingText;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Map<Integer, GangExpectedTime> getWorldToExpectedTime() {
        return worldToGangExpectedTime;
    }

    @Override
    public String toString() {
        return "LocationViewState{" +
                "description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", worldToGangExpectedTime=" + worldToGangExpectedTime +
                '}';
    }
}
