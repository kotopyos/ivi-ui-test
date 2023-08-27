package tests.api;


import api.models.AddToFavouriteModel;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@Tag("api")
@Owner("staya_kotyat")
@DisplayName("API tests")
@Feature("Favourite movies")
public class ApiTests extends TestBase {

    @Test
    @DisplayName("Add movie to favourites")
    void addMovieToFavourites(){
        AddToFavouriteModel bodyModel = new AddToFavouriteModel();
        bodyModel.setId(513760);
        bodyModel.setSession("2f56cab92087821604_1708957377-721636760Le4PLzaRydPSLLUy1z82qg");
        given()
                .contentType(ContentType.URLENC)
                .formParams("id", 513760,
                        "session", bodyModel.getSession()).relaxedHTTPSValidation()
                .when()
                .post("https://api2.ivi.ru/mobileapi/video/favourite/v5/add")
                .then()
                .log().body()
                .statusCode(200)
                .body("result", is("ok"));

    }

}
