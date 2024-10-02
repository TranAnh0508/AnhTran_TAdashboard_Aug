package auto.mainPage;

import auto.TestBase;
import auto.data.enums.GlobalSettings;
import auto.model.Page;
import auto.model.User;
import auto.page.DashboardMainPage;
import auto.page.LoginPage;
import auto.page.NewPageDialog;
import auto.listeners.RetryAnalyzer;
import auto.utils.Assertion;
import auto.utils.DriverUtils;
import auto.utils.MessageUtils;
import auto.utils.NameUtils;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners
public class DeletePageTest extends TestBase {
    private final LoginPage loginPage = new LoginPage();
    private final DashboardMainPage dashboardMainPage = new DashboardMainPage();
    private final NewPageDialog newPageDialog = new NewPageDialog();

    private final User user = User.getAdminAcc();

    @BeforeMethod(description = "Set up objects")
    public void setUpObjects() {
        loginPage.login(user);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethodPositive() {
        dashboardMainPage.logout();
    }

    @DataProvider(name = "tc17Data")
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

    @Test(description = "Verify that Public pages can be visible and accessed by all users of working repository", dataProvider = "tc17Data", retryAnalyzer = RetryAnalyzer.class)
    public void TC_17(Page parentPage, Page childPage) {
        dashboardMainPage.selectGlobalSettingOption(GlobalSettings.ADD_PAGE);
        newPageDialog.completePageInfoDialog(parentPage);

        dashboardMainPage.selectGlobalSettingOption(GlobalSettings.ADD_PAGE);
        newPageDialog.completePageInfoDialog(childPage);

        String parentPageName = parentPage.getTrimPageName();
        String childPageName = childPage.getTrimPageName();

        dashboardMainPage.deletePage(parentPageName);

        Assert.assertEquals(DriverUtils.getAlertText(), MessageUtils.getAlertMessage("confirmDeletePage"),"Parent Page delete alert is displayed");
        DriverUtils.acceptAlert();

        Assert.assertEquals(DriverUtils.getAlertText(),String.format(MessageUtils.getAlertMessage("warningDeletePage"), parentPage.getPageName()),"Warning alert is displayed");
        DriverUtils.acceptAlert();

        dashboardMainPage.deletePage(parentPageName, childPageName);

        Assert.assertEquals(DriverUtils.getAlertText(),MessageUtils.getAlertMessage("confirmDeletePage"),"Children Page delete alert is displayed");
        DriverUtils.acceptAlert();

        Assertion.assertFalse(dashboardMainPage.isChildPageDisplayed(childPageName), childPageName + " page is deleted");

        dashboardMainPage.deletePage(parentPageName);

        Assert.assertEquals(DriverUtils.getAlertText(),MessageUtils.getAlertMessage("confirmDeletePage"), parentPageName + " Page delete alert is displayed");
        DriverUtils.acceptAlert();

        Assertion.assertFalse(dashboardMainPage.isChildPageDisplayed(parentPageName), parentPageName + " page is deleted");

        dashboardMainPage.selectPage("Overview");

        Assertion.assertFalse(dashboardMainPage.isGlobalSettingOptionDisplayed(GlobalSettings.DELETE), GlobalSettings.DELETE.value() + " button disappears");
    }
}
