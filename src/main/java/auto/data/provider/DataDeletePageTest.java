package auto.data.provider;

import auto.model.Page;
import auto.utils.NameUtils;
import org.testng.annotations.DataProvider;

public class DataDeletePageTest {
    @DataProvider(name = "TC_17")
    public static Object[][] tc17Data() {
        Page parentPage, childPage;

        parentPage = Page.builder()
                .pageName(NameUtils.getRandomPageName())
                .isPublic(false)
                .build();
        childPage = Page.builder()
                .pageName(NameUtils.getRandomPageName())
                .parentPage(parentPage.getTrimPageName())
                .isPublic(false)
                .build();

        return new Object[][] {
                {parentPage, childPage}
        };
    }
}
