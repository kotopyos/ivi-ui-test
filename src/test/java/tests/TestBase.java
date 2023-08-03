package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriverProvider;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import pages.MainPage;
import pages.MoviesPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {
    MainPage mainPage = new MainPage();
    MoviesPage moviesPage = new MoviesPage();
    TestData data = new TestData();
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
    void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
