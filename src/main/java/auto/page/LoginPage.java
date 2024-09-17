package auto.page;

import auto.model.User;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement usernameTbx = $(By.id("username"));
    private final SelenideElement passwordTbx = $(By.id("password"));
    private final SelenideElement loginBtn = $(By.xpath("//body//div[@class='btn-login']"));

    public void enterLoginInfo(String username, String password) {
        usernameTbx.setValue(username);
        passwordTbx.setValue(password);
    }

    public void clickLoginButton() {
        loginBtn.click();
    }

    @Step("Login")
    public void login(User user) {
        enterLoginInfo(user.getUsername(), user.getPassword());
        clickLoginButton();
    }
}
