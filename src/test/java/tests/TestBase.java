package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import configs.ApiConfig;
import configs.WebDriverConfig;
import drivers.WebDriverProvider;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import pages.MainPage;
import pages.MoviesPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


public class TestBase {
    public static WebDriverConfig webConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    public static ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());

    public MainPage mainPage = new MainPage();
    public MoviesPage moviesPage = new MoviesPage();
    public TestData data = new TestData();

    @BeforeAll
    static void setUp() {
        WebDriverProvider.setWebConfig();

    }

    @BeforeEach
    void addListener()
    {
        SelenideLogger.addListener("allure", new AllureSelenide());
        if (!System.getProperty("taskName").equals("api")) open();

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
