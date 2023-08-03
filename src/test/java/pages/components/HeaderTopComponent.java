package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;


public class HeaderTopComponent {
    private final SelenideElement moviesButton = $x("//a[@title='Фильмы онлайн']");


    @Step("Open Movies page")
    public void openMoviesPage(){
        moviesButton.click();

    }
}



