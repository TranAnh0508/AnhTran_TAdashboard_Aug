package auto;

import auto.TestBase;
import org.testng.annotations.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class GoogleSearchTest extends TestBase {

    @Test
    public void googleSearchTest() {
//        // Mở trang Google
//        open("https://www.google.com");

        // Tìm kiếm từ khóa "Selenide"
        $("[name='q']").setValue("Selenide").pressEnter();

        // Kiểm tra xem kết quả có chứa từ "Selenide"
        $$("#search .g").first().shouldHave(text("Selenide"));
    }
}