package auto.model;

import auto.data.enums.ChartSeries;
import auto.data.enums.PanelSettingTypes;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class Panel {
    @Builder.Default
    private PanelSettingTypes type = PanelSettingTypes.CHART;
    private String dataProfile;
    private String displayName;
    public String getTrimPanelName() {
        return displayName.replace(" ", " ");
    }
    private String chartTitle;
    private ChartSeries series;
}
