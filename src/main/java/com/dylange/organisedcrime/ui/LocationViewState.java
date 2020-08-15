package com.dylange.organisedcrime.ui;

import java.util.Map;

public class LocationViewState {
    private final String description;
    private final String image;
    private final Map<Integer, String> worldToTimeRemainingText;

    public LocationViewState(String description, String image, Map<Integer, String> worldToTimeRemainingText) {
        this.description = description;
        this.image = image;
        this.worldToTimeRemainingText = worldToTimeRemainingText;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Map<Integer, String> getWorldToTimeRemainingText() {
        return worldToTimeRemainingText;
    }

    @Override
    public String toString() {
        return "LocationViewState{" +
                "description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", worldToTimeRemainingText=" + worldToTimeRemainingText +
                '}';
    }
}
