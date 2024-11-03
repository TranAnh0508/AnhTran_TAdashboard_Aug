package auto.data.enums;

import java.util.Random;

public enum ChartSeries {
    NAME("Name"),
    LOCATION("Location"),
    DESCRIPTION("Description"),
    REVISION_TIMESTAMP("Revision Timestamp"),
    ASSIGNED_USER("Assigned user"),
    STATUS("Status"),
    LAST_UPDATE_DATE("Last update date"),
    LAST_UPDATE_BY("Last updated by"),
    CREATION_DATE("Creation date"),
    CREATION_BY("Created by"),
    NOTES("Notes"),
    URL("URL");

    private final String value;

    ChartSeries(String value) {
        this.value = value;
    }

    public static ChartSeries getRandomSeries() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

    public String value() {
        return " " + value;
    }
}
