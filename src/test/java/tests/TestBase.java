package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.WebDriverProvider;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import pages.MainPage;
import pages.MoviesPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {
    public MainPage mainPage = new MainPage();
    public MoviesPage moviesPage = new MoviesPage();
    public TestData data = new TestData();
    @BeforeAll
    static void setUp() {
        WebDriverProvider.setConfig();
        Configuration.pageLoadStrategy = "eager";
        Configuration.pageLoadTimeout = 100000;
        Configuration.timeout = 15000;
    }

    @BeforeEach
    void addListener()
    {
        SelenideLogger.addListener("allure", new AllureSelenide());

    }

    @AfterEach
    void afterEach() {
        switch (System.getProperty("taskName")) {

            case "web":
                Attach.screenshotAs("Last screenshot");
                Attach.pageSource();
                Attach.browserConsoleLogs();
                Attach.addVideo();
                closeWebDriver();
            case "api":
                break;
            default:
                throw new RuntimeException("Wrong task name");
        }
    }
}
