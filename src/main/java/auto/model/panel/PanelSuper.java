package auto.model.panel;

import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class PanelSuper {
    private DisplaySettings displaySettings;
    private Filters filters;
}
