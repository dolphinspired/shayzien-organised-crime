package com.dylange.organisedcrime.models;

public class GangExpectedTime {
    private static final long STALE_THRESHOLD = 3 * 60 * 1000L;

    private long timeRead;
    private long initialMinutesUntilAppearance;

    public GangExpectedTime(long timeRead, int initialMinutesUntilAppearance) {
        this.timeRead = timeRead;
        this.initialMinutesUntilAppearance = initialMinutesUntilAppearance;
    }

    public boolean isStale() {
        long deltaTimeMillis = (timeRead + (initialMinutesUntilAppearance * 60 * 1000)) - System.currentTimeMillis();

        return deltaTimeMillis * -1f > STALE_THRESHOLD;
    }

    @Override
    public String toString() {
        long deltaTimeMillis = (timeRead + (initialMinutesUntilAppearance * 60 * 1000)) - System.currentTimeMillis();
        long deltaTimeMinutes = deltaTimeMillis / 1000 / 60;

        if (deltaTimeMinutes == 0) {
            return "Expected now";
        } else if (deltaTimeMinutes > 0) {
            return String.format("~%s minutes until appearance", deltaTimeMinutes);
        } else {
            long minutesSinceAppearance = deltaTimeMinutes * -1;
            return String.format("~%s minutes late", minutesSinceAppearance);
        }
    }
}
