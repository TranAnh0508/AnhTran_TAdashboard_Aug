package auto.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DashboardMainPage {
    private final SelenideElement administratorDrop = $(By.xpath("//div[@class='container']//li//a[@href='#Welcome']"));
    private final SelenideElement administerDrop = $(By.xpath("//div[@class='container']//li//a[@href='#Administer']"));
    private final SelenideElement administerDropOptions = $(By.xpath("xpath=//ul[@id='ulAdminister']//a[text()='%s']"));
    private final SelenideElement logoutBtn = $(By.xpath("//a[@href='logout.do']"));

    @Step("Logout")
    public void logout() {
        administratorDrop.click();
        logoutBtn.click();
    }

    @Step("Check the Administrator dropdown is existed")
    public boolean isAdminDropdownDisplayed() {
        administratorDrop.shouldBe(Condition.enabled);
        return administratorDrop.isDisplayed();
    }
}
