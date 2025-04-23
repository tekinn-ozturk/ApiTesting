import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;

public class C04_Put_ResponseBilgileriAssertion {



    @Test
    public void test01() {

    //https://jsonplaceholder.typicode.com/posts/70
     /*url’ine asagidaki Json formatindaki body ile bir
PUT request gonderdigimizde
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}
donen Response’un,
status code’unun 200,
ve content type’inin application/json; charset=utf-8,
ve Server isimli Header’in degerinin cloudflare,
ve status Line’in HTTP/1.1 200 OK
*/



        //1-Request body ve endpoint hazırlama

        //request body
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("title","Ahmet");
        jsonObj.put("body","Merhaba");
        jsonObj.put("userId",10);
        jsonObj.put("id",70);

        //endpoint
        String url = "https://jsonplaceholder.typicode.com/posts/70";

        //2- Expected Body hazırlama
        //tüm datanın nasıl olması gerektiğini test etmiyoruz.

        //3-Request gönderip, dönen response'u kaydetme
        //postmande de post işlemleri yapılırken content-type ve body girişi yapılır.
        Response response = given()
                            .contentType(ContentType.JSON)
                            .when().body(jsonObj.toString())
                            .put(url);


        response.prettyPrint();

        //4- Assertion
        response
                .then()
                .assertThat().statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","cloudflare")
                .statusLine("HTTP/1.1 200 OK");

    }
}
