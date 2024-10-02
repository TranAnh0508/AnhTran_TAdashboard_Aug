package auto.model.panel;

import auto.data.enums.PanelSettingTypes;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
public class DisplaySettings {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisplaySettings that = (DisplaySettings) o;
        return type == that.type
                && Objects.equals(dataProfile, that.dataProfile)
                && Objects.equals(displayName, that.displayName);
    }

    @Builder.Default
    private PanelSettingTypes type = PanelSettingTypes.CHART;
    private String dataProfile;
    private String displayName;
}
