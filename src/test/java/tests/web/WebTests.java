package tests.web;

import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

@Tag("web")
@Owner("staya_kotyat")
@Feature("UI: Movies page")
@DisplayName("Web tests")
public class WebTests extends TestBase {

    @Test
    @Disabled("Issue is TBD")
    @Story("Movies filter")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Suggestion list filter")
    void suggestionListTest(){

       mainPage.openMainPage()
               .openMoviesPage()
               .setCategoryViaSuggestions("2022");




    }

    @Test
    @Story("Movies filter")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Genres filter using carousel")
    void genresFilterUsingCarouselTest(){
        moviesPage.openMoviesPage()
                .setGenreViaFilterCarousel(data.boeviki, data.trilleri, data.drami, data.priklucheniya, data.komedii)
                .verifyParamsFilterAppears(data.boeviki, data.trilleri, data.drami, data.priklucheniya, data.komedii);
    }
    @Test
    @Story("Movies filter")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Genres filter using list")
    void genresFilterUsingListTest(){
        moviesPage.openMoviesPage()
                .setGenreViaFilterList(data.boeviki, data.trilleri, data.drami, data.priklucheniya, data.komedii)
                .verifyParamsFilterAppears(data.boeviki, data.trilleri, data.drami, data.priklucheniya, data.komedii);
    }

    @Test
    @Story("Movies filter")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Sausage list filter")
    void sausageListFilterTest(){
        moviesPage.openMoviesPage()
                .setSausageListOptions(data.poPodpiske, data.naYazikeOriginala, data.sSubtitrami, data.obiemniyZvuk)
                .verifyParamsFilterAppears(data.poPodpiske, data.naYazikeOriginala, data.sSubtitrami, data.obiemniyZvuk);

    }


    @Test
    @Story("Movies filter")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Rating filter")
    void ratingFilterTest(){
        moviesPage.openMoviesPage()
                .setRatingFilter(data.ratingBolwe6)
                .verifyParamsFilterAppears(data.ratingBolwe6);

    }





}
