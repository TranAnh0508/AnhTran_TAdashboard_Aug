package auto.model;

import auto.utils.Constants;
import auto.utils.JsonUtils;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Page {
    private String pageName;
    private String parentPage;
    @Builder.Default
    private Integer numberOfColumns = 2;
    private String displayAfter;
    private boolean isPublic;

    public static Page getDefaultPage() {
        return JsonUtils.to(Constants.PAGE_DEFAULT_PATH, "defaultPage", Page.class);
    }

    public String getTrimPageName() {
        return pageName.replace(" ", " ");
    }

    public String getTrimParentName() {
        return parentPage.replace(" ", " ");
    }
}

