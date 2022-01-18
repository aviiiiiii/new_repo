import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class dynamicJson {

    @Test(dataProvider = "booksData")
    public void testName(String isbn,String isle) {
        RestAssured.baseURI="http://216.10.245.166";
        String response=
        given().
                log().all().
                header("Content-Type","application/json").
                body(payload.addBook(isbn,isle)).
        when().
                post("Library/Addbook.php").
        then().
                log().all().
                assertThat().statusCode(200).
                extract().response().asString();

        JsonPath js=new JsonPath(response);
        String id=js.getString("ID");
        System.out.println("ID is "+id);
    }

    @DataProvider(name = "booksData")
    public Object[][] getData(){
        return new Object[][] {{"2","b"},{"3","c"},{"4","d"},{"5","e"}};
    }
}
