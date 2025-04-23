import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetRequest_ResponseBody_Yazdirma {

    @Test
    public void Test() {
        //1-Request body ve endpoint hazırlama
        //2- Expected Data hazırlama
        //3-Request gönderip, dönen response'u kaydetme
        //4- Assertion

        //https://restful-booker.herokuapp.com/booking/10 urle'sine bir GET isteği at ve dönen responsu yazdır.

        String url = "https://restful-booker.herokuapp.com/booking/10";

        Response response = given().when().get(url);
        //response 'un body'sini yazdırır.
        response.prettyPrint();
        int statusCode= response.getStatusCode();
        System.out.println("Status Code:"+statusCode);
        System.out.println("Content Type:"+response.getContentType());
        System.out.println("Server Header Type:"+ response.getHeader("Server"));
        System.out.println("Status Line:"+response.getStatusLine());
        System.out.println("Response Süresi:"+response.getTime());


        


    }
}
