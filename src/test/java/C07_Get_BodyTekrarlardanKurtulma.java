import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C07_Get_BodyTekrarlardanKurtulma {

    @Test
    public void test01() {

        /*
        https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde
donen Response’un,
status code’unun 200,
ve content type’inin application-json,
ve response body’sindeki
"firstname“in, "Susan",
ve "lastname“in, "Jackson",
ve "totalprice“in, 1000 den küçük olduğu,
ve "depositpaid“in, false,
ve "additionalneeds“in, boş bırakılmadığı
oldugunu test edin
        */


        //1-Request body ve endpoint hazırlama
        String url = "https://restful-booker.herokuapp.com/booking/10";
        //request body yok get isteği atılıyor.

        //2- Expected Data hazırlama

        //3-Request gönderip, dönen response'u kaydetme

        Response response = given().when().get(url);
        response.prettyPrint();

        //4- Assertion
        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Mark"))
                .body("lastname", equalTo("Jackson"))
                .body("totalprice", Matchers.lessThan(1000))
                .body("depositpaid", equalTo(true))
                .body("additionalneeds", Matchers.notNullValue());


    }


    @Test
    public void test02() {
        //1-Request body ve endpoint hazırlama
        String url = "https://restful-booker.herokuapp.com/booking/10";
        //request body yok get isteği atılıyor.

        //2- Expected Data hazırlama

        //3-Request gönderip, dönen response'u kaydetme

        Response response = given().when().get(url);

        //respons'u görebilmek için yazıyorum(gerek yok yazmaya).
        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).body(
                "firstname",equalTo("Sally"),
                "lastname", equalTo("Jones"),
                "totalprice", lessThan(1000),
                "depositpaid", equalTo(true),
                "additionalneeds", notNullValue()




        );



    }
}
