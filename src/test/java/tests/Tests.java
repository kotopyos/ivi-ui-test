package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("remote")
public class Tests extends TestBase {

    @Test
    @Disabled("Issue is TBD")
    @Feature("Movies page")
    @Story("Movies filter")
    @Owner("staya_kotyat")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Suggestion list filter")
    void suggestionListTest(){

       mainPage.openMainPage()
               .openMoviesPage()
               .setCategoryViaSuggestions("2022");




    }

    @Test
    @Feature("Movies page")
    @Story("Movies filter")
    @Owner("staya_kotyat")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Genres filter using carousel")
    void genresFilterUsingCarouselTest(){
        moviesPage.openMoviesPage()
                .setGenreViaFilterCarousel(data.boeviki, data.trilleri, "Драмы", "Приключения", "Комедии") //todo add javafaker+selection randomizer
                .verifyParamsFilterAppears(data.boeviki, data.trilleri, "Драмы", "Приключения", "Комедии");
    }
    @Test
    @Feature("Movies page")
    @Story("Movies filter")
    @Owner("staya_kotyat")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Genres filter using list")
    void genresFilterUsingListTest(){
        moviesPage.openMoviesPage()
                .setGenreViaFilterList(data.boeviki, data.trilleri, "Драмы", "Приключения", "Комедии") //todo add javafaker+selection randomizer
                .verifyParamsFilterAppears(data.boeviki, data.trilleri, "Драмы", "Приключения", "Комедии");
    }

    @Test
    @Feature("Movies page")
    @Story("Movies filter")
    @Owner("staya_kotyat")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Sausage list filter")
    void sausageListFilterTest(){
        moviesPage.openMoviesPage()
                .setSausageListOptions("По подписке", "На языке оригинала", "С субтитрами", "Объёмный звук")
                .verifyParamsFilterAppears("По подписке", "На языке оригинала", "С субтитрами", "Объёмный звук");

    }


    @Test
    @Feature("Movies page")
    @Story("Movies filter")
    @Owner("staya_kotyat")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Rating filter")
    void ratingFilterTest(){
        moviesPage.openMoviesPage()
                .setRatingFilter(data.ratingBolwe6)
                .verifyParamsFilterAppears(data.ratingBolwe6);

    }





}
