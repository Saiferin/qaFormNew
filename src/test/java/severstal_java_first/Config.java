package severstal_java_first;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class Config {
    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
}
