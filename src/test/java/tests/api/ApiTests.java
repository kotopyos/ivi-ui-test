package tests.api;


import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;
import static api.specs.Specs.*;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("api")
@Owner("staya_kotyat")
@DisplayName("API tests")
@Feature("API: Favourite movies")
public class ApiTests extends TestBase {


    @Test
    @DisplayName("Add movie to favourites")
    void addMovieToFavourites(){
        given()
                .spec(favouriteRequestSpec)
                .when()
                .post("/add")
                .then()
                .spec(commonResponseSpec);

    }

    @Test
    @DisplayName("Delete movie from favourites")
    void deleteMovieFromFavourites(){
        given()
                .spec(favouriteRequestSpec)
                .when()
                .post("/delete")
                .then()
                .spec(commonResponseSpec);

    }

    @Test
    @DisplayName("Rate random movie from db/films.csv")
    void rateRandomMovieFromDB(){

        given()
                .spec(rateRequestSpec)
                .when()
                .post()
                .then().spec(commonResponseSpec);

    }




}
