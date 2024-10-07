package auto.data.provider;

import auto.model.Page;
import auto.utils.NameUtils;
import org.testng.annotations.DataProvider;

public class DataVisiblePageTest {
    @DataProvider(name = "TC_14")
    public static Object[][] tc14Data() {
        Page firstPageInfo;

        firstPageInfo = Page.builder()
                .pageName(NameUtils.getRandomPageName())
                .isPublic(true)
                .build();

        return new Object[][]{
                {firstPageInfo}
        };
    }
}
