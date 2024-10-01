package auto.data.enums;

public enum PermanentPages {
    OVERVIEW("Overview"),
    EXECUTION_DASHBOARD("Execution Dashboard");

    private String value;

    PermanentPages(String value) { this.value = value; }

    public String value() { return value; }
}