import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_Get_Response_Degerlerini_Otomasyon_Ile_Test_Etme {

    @Test

    public void test() {

        //https://restful-booker.herokuapp.com/booking/10 urle'sine bir GET isteği at
        //Dönen response'un status code'nun 200 olduğu
        //Content Type'ının application/json; charset=utf-8 olduğu
        //Server isimli Header'ı değerinin Cowboy olduğu,
        //Status Line Değerinin HTTP/1.1 200 OK olduğunu test edin.


        //Çözüm
        //1-Request body ve endpoint hazırlama
        //2- Expected Data hazırlama
        //3-Request gönderip, dönen response'u kaydetme
        //4- Assertion

        String url = "https://restful-booker.herokuapp.com/booking/10";

        //Bu kod verdiğimiz url'e gidip request atıp, bir response dönderiyor ve bu response'ı response nesnesinde tutuyoruz.
        Response response = given().when().get(url);

        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","Cowboy")
                .statusLine("HTTP/1.1 200 OK");

    }
}
