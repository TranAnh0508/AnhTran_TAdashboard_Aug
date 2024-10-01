package auto.data.enums;

public enum GlobalSettings {
    ADD_PAGE("Add Page"),
    CREATE_PROFILE("Create Profile"),
    CREATE_PANEL("Create PanelSuper"),
    EDIT("Edit"),
    DELETE("Delete");

    private String value;

    GlobalSettings(String value) { this.value = value; }

    public String value() { return value; }
}
