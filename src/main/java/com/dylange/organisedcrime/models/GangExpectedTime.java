package com.dylange.organisedcrime.models;

public class GangExpectedTime implements Comparable<GangExpectedTime> {
    private static final long STALE_THRESHOLD = 5 * 60 * 1000L; // 5 minutes

    private long timeRead;
    private long initialMinutesUntilAppearance;

    public GangExpectedTime(long timeRead, int initialMinutesUntilAppearance) {
        this.timeRead = timeRead;
        this.initialMinutesUntilAppearance = initialMinutesUntilAppearance;
    }

    public boolean isStale() {
        long deltaTimeMillis = getExpectedAppearanceTime() - System.currentTimeMillis();

        return deltaTimeMillis * -1f > STALE_THRESHOLD;
    }

    @Override
    public String toString() {
        long deltaTimeMillis = getExpectedAppearanceTime() - System.currentTimeMillis();
        long deltaTimeMinutes = (deltaTimeMillis / 1000 / 60);

        if (deltaTimeMinutes == 0) {
            return "Now";
        } else if (deltaTimeMinutes > 0) {
            return String.format("~%s mins", deltaTimeMinutes + 1);
        } else {
            long minutesSinceAppearance = (deltaTimeMinutes * -1) + 1;
            return String.format("~%s mins ago", minutesSinceAppearance);
        }
    }

    @Override
    public int compareTo(GangExpectedTime other) {
        return (int)(this.getExpectedAppearanceTime() - other.getExpectedAppearanceTime());
    }

    private Long getExpectedAppearanceTime() {
        return (timeRead + (initialMinutesUntilAppearance * 60 * 1000));
    }
}
