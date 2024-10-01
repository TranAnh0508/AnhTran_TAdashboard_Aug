package auto.data.enums;

public enum Administer {
    DATA_PROFILES("Data Profiles"),
    PANELS("Panels");

    private String value;

    Administer(String value) { this.value = value; }

    public String value() { return value; }
}