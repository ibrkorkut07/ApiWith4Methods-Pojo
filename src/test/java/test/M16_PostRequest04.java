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
import java.util.HashSet;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class M16_PostRequest04 extends RestfulBaseUrl {
    /*  https://restful-booker.herokuapp.com/booking
        request body
        {   "firstname": "Selim",
            "lastname": "Ak",
            "totalprice": 15000,
            "depositpaid": true,
            "bookingdates": {
                       "checkin": "2020-09-09",
                       "checkout": "2020-09-21" }   }
        Status code is 200
        response body
        {   "bookingid": 11,
            "booking": {
                     "firstname": "Selim",
                     "lastname": "Ak",
                     "totalprice": 15000,
                     "depositpaid": true,
                     "bookingdates": {
                               "checkin": "2020-09-09",
                               "checkout": "2020-09-21" }   }   }   */

    // Matchers
    @Test
    public void test01(){
        spec01.pathParam("p", "booking");

    /*  https://restful-booker.herokuapp.com/booking
        request body
        {   "firstname": "Selim",
            "lastname": "Ak",
            "totalprice": 15000,
            "depositpaid": true,
            "bookingdates": {
                       "checkin": "2020-09-09",
                       "checkout": "2020-09-21" }   }
        Status code is 200
        response body
        {   "bookingid": 11,
            "booking": {
                     "firstname": "Selim",
                     "lastname": "Ak",
                     "totalprice": 15000,
                     "depositpaid": true,
                     "bookingdates": {
                               "checkin": "2020-09-09",
                               "checkout": "2020-09-21" }   }   }   */
    }

    // Jsonpath
    @Test
    public void test02(){
        spec01.pathParam("p", "booking");

    /*  https://restful-booker.herokuapp.com/booking
        request body
        {   "firstname": "Selim",
            "lastname": "Ak",
            "totalprice": 15000,
            "depositpaid": true,
            "bookingdates": {
                       "checkin": "2020-09-09",
                       "checkout": "2020-09-21" }   }
        Status code is 200
        response body
        {   "bookingid": 11,
            "booking": {
                     "firstname": "Selim",
                     "lastname": "Ak",
                     "totalprice": 15000,
                     "depositpaid": true,
                     "bookingdates": {
                               "checkin": "2020-09-09",
                               "checkout": "2020-09-21" }   }   }   */
    }

    // Deserialization
    @Test
    public void test03(){
        spec01.pathParam("p", "booking");
        RestfulTestData restfulTestData = new RestfulTestData();
        JSONObject expData = restfulTestData.bookingPostExpData();

        Response response = given().contentType(ContentType.JSON).spec(spec01).body(expData.toString()).when().post("{p}");
        HashMap<String, Object> actDataMap = response.as(HashMap.class);
        System.out.println("actDataMap = " + actDataMap);

        assertEquals(expData.get("statusCode"), response.statusCode());


    /*
        public HashMap<String, Object> bookingPostExpData () {
        HashMap<String, Object> postExpData = new HashMap<>();
        postExpData.put("statusCode", 200);
        postExpData.put("firstname", "Selim");
        postExpData.put("lastname", "Ak");
        postExpData.put("totalprice", 11111);
        postExpData.put("depositpaid", true);
        postExpData.put("bookingdates.checkin", "2020-09-09");
        postExpData.put("bookingdates.checkout", "2020-09-21");
        return postExpData;
     */
    /*  https://restful-booker.herokuapp.com/booking
        request body
        {   "firstname": "Selim",
            "lastname": "Ak",
            "totalprice": 15000,
            "depositpaid": true,
            "bookingdates": {
                       "checkin": "2020-09-09",
                       "checkout": "2020-09-21" }   }
        Status code is 200
        response body
        {   "bookingid": 11,
            "booking": {
                     "firstname": "Selim",
                     "lastname": "Ak",
                     "totalprice": 15000,
                     "depositpaid": true,
                     "bookingdates": {
                               "checkin": "2020-09-09",
                               "checkout": "2020-09-21" }   }   }   */
    }

    // Pojo
    @Test
    public void test04(){
        spec01.pathParam("p", "booking");

        //1) URL
        //2) EXPECTED DATA
        //3) REQUEST & RESPONSE
        //4) ASSERTION

    /*  https://restful-booker.herokuapp.com/booking
        request body
        {   "firstname": "Selim",
            "lastname": "Ak",
            "totalprice": 15000,
            "depositpaid": true,
            "bookingdates": {
                       "checkin": "2020-09-09",
                       "checkout": "2020-09-21" }   }
        Status code is 200
        response body
        {   "bookingid": 11,
            "booking": {
                     "firstname": "Selim",
                     "lastname": "Ak",
                     "totalprice": 15000,
                     "depositpaid": true,
                     "bookingdates": {
                               "checkin": "2020-09-09",
                               "checkout": "2020-09-21" }   }   }   */
    }

    // ObjectMapper
    @Test
    public void test05(){

        //1) URL
        spec01.pathParam("p", "booking");

        //2) EXPECTED DATA
        String postRequestData = "{   \"firstname\": \"Selim\",\n" +
                "            \"lastname\": \"Ak\",\n" +
                "            \"totalprice\": 15000,\n" +
                "            \"depositpaid\": true,\n" +
                "            \"bookingdates\": {\n" +
                "                       \"checkin\": \"2020-09-09\",\n" +
                "                       \"checkout\": \"2020-09-21\" }   }";

        HashMap postJsondata = JsonUtil.convertJsonToJava(postRequestData, HashMap.class);

        String expJsonData = "{   \"bookingid\": 11,\n" +
                "            \"booking\": {\n" +
                "                     \"firstname\": \"Selim\",\n" +
                "                     \"lastname\": \"Ak\",\n" +
                "                     \"totalprice\": 15000,\n" +
                "                     \"depositpaid\": true,\n" +
                "                     \"bookingdates\": {\n" +
                "                               \"checkin\": \"2020-09-09\",\n" +
                "                               \"checkout\": \"2020-09-21\" }   }   }";

        HashMap expData = JsonUtil.convertJsonToJava(expJsonData, HashMap.class);

        //3) REQUEST & RESPONSE
        Response response = given().contentType(ContentType.JSON).spec(spec01).body(postJsondata).when().post("{p}");

        //4) ASSERTION
        HashMap actdata = JsonUtil.convertJsonToJava(response.asString(), HashMap.class);

        assertEquals(expData.get("booking.firstname"), actdata.get("booking.firstname"));
        assertEquals(expData.get("booking.lastname"), actdata.get("booking.lastname"));
        assertEquals(expData.get("booking.totalprice"), actdata.get("booking.totalprice"));
        assertEquals(expData.get("booking.depositpaid"), actdata.get("booking.depositpaid"));
        assertEquals(expData.get("booking.bookingdates.checkin"), actdata.get("booking.bookingdates.checkin"));
        assertEquals(expData.get("booking.bookingdates.checkout"), actdata.get("booking.bookingdates.checkout"));

    /*  https://restful-booker.herokuapp.com/booking
        request body
        {   "firstname": "Selim",
            "lastname": "Ak",
            "totalprice": 15000,
            "depositpaid": true,
            "bookingdates": {
                       "checkin": "2020-09-09",
                       "checkout": "2020-09-21" }   }
        Status code is 200
        response body
        {
    "booking": {
        "firstname": "Selim",
        "lastname": "Ak",
        "totalprice": 15000,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2020-09-09",
            "checkout": "2020-09-21"
        }
    }
}   */
    }

}

