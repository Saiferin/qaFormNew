package severstal_java_first;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import severstal_java_first.Attach.Attach;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Config {
    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        String user = System.getProperty("login");
        String password = System.getProperty("password");
        String remoteUrl = System.getProperty("remoteUrl");
        String browser = System.getProperty("browser");
        String version = System.getProperty("version");

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.remote = String.format("https://%s:%s@%s", user, password, remoteUrl);
        Configuration.browser = browser;
        Configuration.browserVersion = version;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }

}
