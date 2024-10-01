package auto.data.enums;

public enum PanelSettingTypes {
    CHART("Chart"),
    INDICATOR("Indicator"),
    REPORT("Report"),
    HEAT_MAP("Heat Map");

    private String value;

    PanelSettingTypes(String value) { this.value = value; }

    public String value() { return value; }
}
