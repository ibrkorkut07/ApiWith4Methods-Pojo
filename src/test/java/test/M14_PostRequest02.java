package test;

import baseUrl.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.RestfulTestData;
import utilities.JsonUtil;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class M14_PostRequest02 extends RestfulBaseUrl {
  /*  https://restful-booker.herokuapp.com/booking
      { "firstname": "Selim",
        "lastname": "Ak",
        "totalprice": 11111,
        "depositpaid": true,
        "bookingdates": {
               "checkin": "2020-09-09",
               "checkout": "2020-09-21"  }  }
    gönderildiğinde, Status kodun 200 olduğunu ve dönen response body nin ,
    "booking": {
         "firstname": " Selim ",
         "lastname": " Ak ",
         "totalprice":  11111,
         "depositpaid": true,
         "bookingdates": {
              "checkin": "2020-09-09",
              "checkout": " 2020-09-21” },
        }   olduğunu test edin      */

    // Matchers without Testdata class
    @Test
    public void test01(){
        spec01.pathParams("p1", "booking");
//
////        JSONObject postRequestdata = new JSONObject();
////        postRequestdata.put("firstname", "Selim");
////        postRequestdata.put("lastname", "Ak");
////        postRequestdata.put("totalprice", 11111);
////        postRequestdata.put("depositpaid", true);
////        postRequestdata.put("bookingdates.checkin", "2020-09-09");
////        postRequestdata.put("bookingdates.checkout", "2020-09-21");
//
//        JSONObject bookingDates = new JSONObject();
//        bookingDates.put("checkin", "2020-09-09");
//        bookingDates.put("checkout", "2020-09-21");
//        JSONObject postRequestdata = new JSONObject();
//        postRequestdata.put("firstname", "Selim");
//        postRequestdata.put("lastname", "Ak");
//        postRequestdata.put("totalprice", 11111);
//        postRequestdata.put("depositpaid", true);
//        postRequestdata.put("bookingdates", bookingDates);
//
//        Response response = given().spec(spec01).contentType(ContentType.JSON).
//                            body(postRequestdata.toString()).when().post("{p1}");
//
//        response.then().assertThat().statusCode(200).body("booking.firstname", equalTo(postRequestdata.get("firstname")),
//                    "booking.lastname", equalTo(postRequestdata.get("lastname")),
//                    "booking.totalprice", equalTo(postRequestdata.get("totalprice")),
//                    "booking.depositpaid", equalTo(postRequestdata.get("depositpaid")),
//                    "booking.bookingdates.checkin", equalTo(postRequestdata.get("bookingdates.checkin")),
//                    "booking.bookingdates.checkout", equalTo(postRequestdata.get("bookingdates.checkout")));
    }

    // Jsonpath
    @Test
    public void test03(){
        spec01.pathParams("p1", "booking");

      /*  https://restful-booker.herokuapp.com/booking
      { "firstname": "Selim",
        "lastname": "Ak",
        "totalprice": 11111,
        "depositpaid": true,
        "bookingdates": {
               "checkin": "2020-09-09",
               "checkout": "2020-09-21"  }  }
        gönderildiğinde, Status kodun 200 olduğunu ve dönen response body nin ,
        "booking": {
            "firstname": " Selim ",
            "lastname": " Ak ",
            "totalprice":  11111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2020-09-09",
                "checkout": " 2020-09-21” },
            }   olduğunu test edin      */
    }

    // Deserialization
    @Test
    public void test04(){
        spec01.pathParams("p1", "booking");
        RestfulTestData restfulTestData = new RestfulTestData();
        JSONObject expData = restfulTestData.bookingPostRequestMap();

        Response response = given().contentType(ContentType.JSON).spec(spec01).body(expData.toString()).when().post("{p1}");
        HashMap<String, Object> actData = response.as(HashMap.class);

        assertEquals(expData.get("firstname"), ((HashMap) actData.get("booking")).get("firstname"));
        assertEquals(expData.get("lastname"), ((HashMap) actData.get("booking")).get("lastname"));
        assertEquals(expData.get("totalprice"), ((HashMap) actData.get("booking")).get("totalprice"));
        assertEquals(expData.get("depositpaid"), ((HashMap) actData.get("booking")).get("depositpaid"));
        assertEquals( "2020-09-09", ((HashMap<?,?>) ((HashMap<?,?>) actData.get("booking")).get("bookingdates")).get("checkin") );
        assertEquals( "2020-09-09", ((HashMap<?,?>) ((HashMap<?,?>) actData.get("booking")).get("bookingdates")).get("checkout") );

//        assertEquals( (JSONObject) expData.get("bookingdatescheckin"), ((HashMap<?,?>) ((HashMap<?,?>) actData.get("booking")).get("bookingdates")).get("checkin") );
//        assertEquals( (JSONObject) expData.get("bookingdatescheckout"), ((HashMap<?,?>) ((HashMap<?,?>) actData.get("booking")).get("bookingdates")).get("checkout") );

    /*
    public JSONObject bookingPostRequestMap () {
    JSONObject bookingDates = new JSONObject();
    bookingDates.put("checkin", "2020-09-09");
    bookingDates.put("checkout", "2020-09-21");
    JSONObject postRequestdata = new JSONObject();
    postRequestdata.put("firstname", "Selim");
    postRequestdata.put("lastname", "Ak");
    postRequestdata.put("totalprice", 11111);
    postRequestdata.put("depositpaid", true);
    postRequestdata.put("bookingdates", bookingDates);
    return postRequestdata;
    }
     */

    /*  https://restful-booker.herokuapp.com/booking
      { "firstname": "Selim",
        "lastname": "Ak",
        "totalprice": 11111,
        "depositpaid": true,
        "bookingdates": {
               "checkin": "2020-09-09",
               "checkout": "2020-09-21"  }  }
    gönderildiğinde, Status kodun 200 olduğunu ve dönen response body nin ,
    "booking": {
         "firstname": " Selim ",
         "lastname": " Ak ",
         "totalprice":  11111,
         "depositpaid": true,
         "bookingdates": {
              "checkin": "2020-09-09",
              "checkout": " 2020-09-21” },
        }   olduğunu test edin      */
    }

    // Pojo
    @Test
    public void test05(){
        spec01.pathParams("p1", "booking");

        //1) URL
        //2) EXPECTED DATA
        //3) REQUEST & RESPONSE
        //4) ASSERTION

    /*  https://restful-booker.herokuapp.com/booking
      { "firstname": "Selim",
        "lastname": "Ak",
        "totalprice": 11111,
        "depositpaid": true,
        "bookingdates": {
               "checkin": "2020-09-09",
               "checkout": "2020-09-21"  }  }
    gönderildiğinde, Status kodun 200 olduğunu ve dönen response body nin ,
    "booking": {
         "firstname": " Selim ",
         "lastname": " Ak ",
         "totalprice":  11111,
         "depositpaid": true,
         "bookingdates": {
              "checkin": "2020-09-09",
              "checkout": " 2020-09-21” },
        }   olduğunu test edin      */
    }

    // ObjectMapper
    @Test
    public void test06(){

        //1) URL
        spec01.pathParams("p1", "booking");

        //2) EXPECTED DATA
        String postRequestData = "{ \"firstname\": \"Selim\",\n" +
                "        \"lastname\": \"Ak\",\n" +
                "        \"totalprice\": 11111,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "               \"checkin\": \"2020-09-09\",\n" +
                "               \"checkout\": \"2020-09-21\"  }  }";
        HashMap postData = JsonUtil.convertJsonToJava(postRequestData, HashMap.class);

        String jsonData = "{\n" +
                "    \"bookingid\": 17844,\n" +
                "    \"booking\": {\n" +
                "        \"firstname\": \"Selim\",\n" +
                "        \"lastname\": \"Ak\",\n" +
                "        \"totalprice\": 11111,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2020-09-09\",\n" +
                "            \"checkout\": \"2020-09-21\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        HashMap expData = JsonUtil.convertJsonToJava(jsonData, HashMap.class);

        //3) REQUEST & RESPONSE
        Response response = given().contentType(ContentType.JSON).spec(spec01).body(postData).when().post("{p1}");

        //4) ASSERTION
        HashMap actData = JsonUtil.convertJsonToJava(response.asString(), HashMap.class);

        assertEquals(expData.get("booking.firstname"), actData.get("booking.firstname"));
        assertEquals(expData.get("booking.lastname"), actData.get("booking.lastname"));
        assertEquals(expData.get("booking.totalprice"), actData.get("booking.totalprice"));
        assertEquals(expData.get("booking.depositpaid"), actData.get("booking.depositpaid"));
        assertEquals(expData.get("booking.bookingdates.checkin"), actData.get("booking.bookingdates.checkin"));
        assertEquals(expData.get("booking.bookingdates.checkout"), actData.get("booking.bookingdates.checkout"));

    /*  https://restful-booker.herokuapp.com/booking
      { "firstname": "Selim",
        "lastname": "Ak",
        "totalprice": 11111,
        "depositpaid": true,
        "bookingdates": {
               "checkin": "2020-09-09",
               "checkout": "2020-09-21"  }  }
    gönderildiğinde, Status kodun 200 olduğunu ve dönen response body nin;
    {
    "booking": {
        "firstname": "Selim",
        "lastname": "Ak",
        "totalprice": 11111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2020-09-09",
            "checkout": "2020-09-21"
        }
    }
}
        }   olduğunu test edin      */
    }

}
