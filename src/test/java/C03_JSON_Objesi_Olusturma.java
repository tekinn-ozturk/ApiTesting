import org.json.JSONObject;
import org.junit.Test;

public class C03_JSON_Objesi_Olusturma {

    @Test
    public void test01() {

        /*
        {
            "title" : "Tekin",
            "body" : "Merhaba",
            "userId" : 1

        }
        */

        JSONObject obj1 = new JSONObject();
        obj1.put("title","Tekin");
        obj1.put("body","Merhaba");
        obj1.put("userId",1);

        System.out.println(obj1);

    }


    @Test
    public void test02(){
        /*
        {
            "firstname" : "Jim",
            "additionalneeds": "Breakfast",
            "bookingdates" : {
            "checkin":"2025-01-01",
            "checkout":"2026-01-01"

            },
            "totalprice" : 111,
            "depositpaid": true,
            "lastname":"Brown"
        }
         */

        //İÇ İÇE JSON OBJELERİNDE ÖNCE İÇTEKİ JSON OBJELERİ OLUŞTURULUR DAHA SONRA ASIL OBJEYE EKLENİR.
        JSONObject dateJSONObj = new JSONObject();
        dateJSONObj.put("checkin","2025-01-01");
        dateJSONObj.put("checkout","2026-01-01");

        JSONObject JSONObj = new JSONObject();
        JSONObj.put("firstname","Jim");
        JSONObj.put("additionalneeds","Breakfast");
        JSONObj.put("bookingdates",dateJSONObj);
        JSONObj.put("totalprice",111);
        JSONObj.put("depositpaid",true);
        JSONObj.put("lastname","Brown");

        System.out.println(JSONObj);




    }

}
