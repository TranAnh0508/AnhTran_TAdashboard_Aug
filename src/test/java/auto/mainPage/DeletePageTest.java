package auto.mainPage;

import auto.TestBase;
import auto.data.enums.GlobalSettings;
import auto.data.provider.DataDeletePageTest;
import auto.model.Page;
import auto.model.User;
import auto.page.DashboardMainPage;
import auto.page.LoginPage;
import auto.page.NewPageDialog;
import auto.listeners.RetryAnalyzer;
import auto.utils.AlertUtils;
import auto.utils.MessageUtils;
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

    @Test(description = "Verify that Public pages can be visible and accessed by all users of working repository", dataProvider = "TC_17", dataProviderClass = DataDeletePageTest.class, retryAnalyzer = RetryAnalyzer.class)
    public void TC_17(Page parentPage, Page childPage) {
        dashboardMainPage.selectGlobalSettingOption(GlobalSettings.ADD_PAGE);
        newPageDialog.completePageInfoDialog(parentPage);

        dashboardMainPage.selectGlobalSettingOption(GlobalSettings.ADD_PAGE);
        newPageDialog.completePageInfoDialog(childPage);

        String parentPageName = parentPage.getTrimPageName();
        String childPageName = childPage.getTrimPageName();

        dashboardMainPage.deletePage(parentPageName);
        Assert.assertEquals(AlertUtils.getAlertText(), MessageUtils.getAlertMessage("confirmDeletePage"),"Parent Page delete alert is displayed");
        AlertUtils.acceptAlert();
        Assert.assertEquals(AlertUtils.getAlertText(),String.format(MessageUtils.getAlertMessage("warningDeletePage"), parentPage.getPageName()),"Warning alert is displayed");
        AlertUtils.acceptAlert();

        dashboardMainPage.deletePage(parentPageName, childPageName);
        Assert.assertEquals(AlertUtils.getAlertText(),MessageUtils.getAlertMessage("confirmDeletePage"),"Children Page delete alert is displayed");
        AlertUtils.acceptAlert();
        dashboardMainPage.verifyChildPageDisplayed(childPageName);
//        Assertion.assertFalse(dashboardMainPage.verifyChildPageDisplayed(childPageName), childPageName + " page is deleted");

        dashboardMainPage.deletePage(parentPageName);
        Assert.assertEquals(AlertUtils.getAlertText(),MessageUtils.getAlertMessage("confirmDeletePage"), parentPageName + " Page delete alert is displayed");
        AlertUtils.acceptAlert();
        dashboardMainPage.verifyChildPageDisplayed(parentPageName);
//        Assertion.assertFalse(dashboardMainPage.verifyChildPageDisplayed(parentPageName), parentPageName + " page is deleted");

        dashboardMainPage.selectPage("Overview");
        dashboardMainPage.verifyGlobalSettingOptionDisplayed(GlobalSettings.DELETE);
//        Assertion.assertFalse(dashboardMainPage.verifyGlobalSettingOptionDisplayed(GlobalSettings.DELETE), GlobalSettings.DELETE.value() + " button disappears");
    }
}
