package pages;

import io.qameta.allure.Step;
import pages.components.FilterComponent;
import pages.components.SuggestionListComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MoviesPage {
    SuggestionListComponent suggestionListComponent = new SuggestionListComponent();
    FilterComponent filterComponent = new FilterComponent();




    @Step("Open Movies page via direct adress")
    public MoviesPage openMoviesPage(){
        open(baseUrl + "/movies");
        return this;
    }

    @Step("Open {0} category via Suggestion list")
    public MoviesPage setCategoryViaSuggestions(String category){
        suggestionListComponent.setCategory(category);

        return this;
    }

    @Step("Set Free category via Suggestion list")
    public MoviesPage setCategoryFree(){
        suggestionListComponent.setCategoryFree();

        return this;
    }

    @Step("Set {genres} genres via Filter carousel")
    public MoviesPage setGenreViaFilterCarousel(String ...genres){

        filterComponent.openGenresDropDownMenu();
        filterComponent.setGenreByCarousel(genres[0]);
        filterComponent.openGenresDropDownMenu();

        for (int i = 1; i < genres.length; i++){

            filterComponent.setGenreByCarousel(genres[i]);
        }

        return this;
    }

    @Step("Set {genres} genres via Filter list")
    public MoviesPage setGenreViaFilterList(String ...genres) {
        filterComponent.openGenresDropDownMenu();
        filterComponent.setGenreByCarousel(genres[0]);
        filterComponent.openGenresDropDownMenu();

        for (int i = 1; i < genres.length; i++){

            filterComponent.setGenreByList(genres[i]);
        }

        return this;
    }
    @Step("Set {rating} genres via Filter list")
    public MoviesPage setRatingFilter(String rating) {
        filterComponent.setRating(rating);

        return this;
    }

    @Step("Set {options} options in sausage list")
    public MoviesPage setSausageListOptions(String ...options){
        for (String option : options){

            filterComponent.setSausageListOption(option);
        }
        return this;
    }

    @Step("Verify Suggestion list appears")
    public void verifySuggestionListAppears(){
        suggestionListComponent.getSuggestionListElement().shouldBe(appear);
    }

    @Step("Verify {params} filter params appears")
    public void verifyParamsFilterAppears(String ...params){

        for (String param : params){

            $(".parameters__info").shouldHave(text(param));
        }
    }






}
