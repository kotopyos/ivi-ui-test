package pages;

import io.qameta.allure.Step;
import pages.components.HeaderTopComponent;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    HeaderTopComponent headerTopComponent = new HeaderTopComponent();

    @Step("Open Main page")
    public MainPage openMainPage(){
        open(baseUrl);

        return this;
    }

    @Step("Open Movies page")
    public MoviesPage openMoviesPage(){
        headerTopComponent.openMoviesPage();

        return new MoviesPage();
    }

}
