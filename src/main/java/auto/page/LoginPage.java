package auto.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public static SelenideElement usernameTbx = $(By.id("username"));
    public static SelenideElement passwordTbx = $(By.id("password"));
    public static SelenideElement loginBtn = $(By.xpath("//body//div[@class='btn-login']"));

    public void enterLoginInfo(String username, String password) {
        usernameTbx.setValue(username);
        passwordTbx.setValue(password);
    }

    public void clickLoginButton() {
        loginBtn.click();
    }

    public void login(String username, String password) {
        enterLoginInfo(username, password);
        clickLoginButton();
    }
}
