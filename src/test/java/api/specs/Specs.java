package api.specs;

import com.github.javafaker.Faker;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomApiListener.withCustomTemplates;
import static api.utils.RandomFilmExtractor.randomFilmNumber;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static org.hamcrest.Matchers.is;

public class Specs {

    static Faker faker = new Faker();
    private static Integer randomFilmNum;
    static {
        try {
            randomFilmNum = randomFilmNumber();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static RequestSpecification favouriteRequestSpec = with()
                    .filter(withCustomTemplates())
                    .log().uri()
                    .log().headers()
                    .log().body()
                    .contentType(ContentType.URLENC)
                    .baseUri("https://api2.ivi.ru/mobileapi")
                    .basePath("/video/favourite/v5")
                    .formParams("id", randomFilmNum,
                            "session", "2f56cab92087821604_1708957377-721636760Le4PLzaRydPSLLUy1z82qg") //todo Add config.api
                    .relaxedHTTPSValidation();


    public static RequestSpecification rateRequestSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().headers()
            .log().body()
            .contentType(ContentType.URLENC)
            .baseUri("https://api2.ivi.ru/mobileapi")
            .basePath("/video/user/rate/v5/")
            .formParams("id", randomFilmNum,
                    "rate", faker.number().numberBetween(1, 10),
                    "session", "2f56cab92087821604_1708957377-721636760Le4PLzaRydPSLLUy1z82qg") //todo Add config.api
            .relaxedHTTPSValidation();



    public static ResponseSpecification commonResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody("result", is("ok"))
            .build();


}
