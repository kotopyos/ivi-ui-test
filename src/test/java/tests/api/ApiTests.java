package tests.api;


import api.requests.AddToFavouriteRequestModel;
import api.responses.AddToFavouriteResponeModel;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static helpers.CustomApiListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("api")
@Owner("staya_kotyat")
@DisplayName("API tests")
@Feature("Favourite movies")
public class ApiTests extends TestBase {

    @Test
    @DisplayName("Add movie to favourites")
    void addMovieToFavourites(){
        AddToFavouriteRequestModel body = new AddToFavouriteRequestModel();
        body.setId(513760);
        body.setSession("2f56cab92087821604_1708957377-721636760Le4PLzaRydPSLLUy1z82qg");
        AddToFavouriteResponeModel res = step("Making request for adding movie to favourites", ()->
         given()
                .filter(withCustomTemplates())
                .contentType(ContentType.URLENC)
                .formParams("id", body.getId(),
                        "session", body.getSession()).relaxedHTTPSValidation()
                .when()
                .post("https://api2.ivi.ru/mobileapi/video/favourite/v5/add")
                .then()
                .log().body()
                .statusCode(200)
                .extract().as(AddToFavouriteResponeModel.class)
        );
        step("Asserting 'result' field",()->{
        assertThat(res.getResult()).isEqualTo("ok");
        });
    }

}
