import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiTest {
    @Test
    public void name() {
        RestAssured.baseURI="https://rahulshettyacademy.com";
        String response = given().
                log().all().
                queryParam("key","qaclick123").
                header("Content-Type","application/json").
                body(payload.postBody()).
        when().
                post("maps/api/place/add/json").
        then().
                assertThat().
                statusCode(200).
                body("scope",equalTo("APP")).
                header("Server","Apache/2.4.18 (Ubuntu)").
                extract().response().asString();

//        System.out.println(response);
        JsonPath js=new JsonPath(response);
        String place_id=js.getString("place_id");
        System.out.println(place_id);


        String response1=
        given().
                log().all().
                queryParam("key","qaclick123").
                queryParam("place_id",place_id).
                body(payload.updateBody(place_id)).
        when().
                put("maps/api/place/update/json").
        then().
                extract().response().asString();

        JsonPath js1=new JsonPath(response1);
        System.out.println(js1.getString("msg"));

        String response2=
        given().
                queryParam("place_id",place_id).
                queryParam("key","qaclick123").
        when().
                get("maps/api/place/get/json").
        then().extract().response().asString();

        JsonPath js2=new JsonPath(response2);
        System.out.println("The new Address is "+js2.getString("address"));


    }
}
