package com.runelite.organisedcrime.models;

public class GangInfo {
    private String location;
    private String timeText;
    private int world;
    private long timeRead;

    public GangInfo(String location, String timeText, int world, long timeRead) {
        this.location = location;
        this.timeText = timeText;
        this.world = world;
        this.timeRead = timeRead;
    }

    public String getLocation() {
        return location;
    }

    public String getTimeText() {
        return timeText;
    }

    public int getWorld() {
        return world;
    }

    public long getTimeRead() {
        return timeRead;
    }
}
