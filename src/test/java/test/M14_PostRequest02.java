package test;

import baseUrl.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

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
              "checkin": "2020-09-01",
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
                "checkin": "2020-09-01",
                "checkout": " 2020-09-21” },
            }   olduğunu test edin      */
    }

    // Deserialization
    @Test
    public void test04(){
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
              "checkin": "2020-09-01",
              "checkout": " 2020-09-21” },
        }   olduğunu test edin      */
    }

    // Pojo
    @Test
    public void test05(){
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
              "checkin": "2020-09-01",
              "checkout": " 2020-09-21” },
        }   olduğunu test edin      */
    }

    // ObjectMapper
    @Test
    public void test06(){
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
              "checkin": "2020-09-01",
              "checkout": " 2020-09-21” },
        }   olduğunu test edin      */
    }

}
