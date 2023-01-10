package test;

import baseUrl.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.RestfulTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;


public class M03_GetRequest03 extends RestfulBaseUrl {

    /*
    https://restful-booker.herokuapp.com/booking/7 url'ine
        accept type'i "application/json" olan GET request'i yolladigimda gelen response'un
        status kodunun 200 ve
        content type'inin "application/json"

            "firstname": "Susan",
            "lastname": "Brown",
            "totalprice": 189,
            "depositpaid": false,
            "bookingdates": {
                    "checkin": "2017-08-15",
                    "checkout": "2018-12-01"
            "additionalneeds": "Breakfast"
    }
        oldugunu test edin
    */

    // Matchers
    @Test
    public void test02(){

        spec01.pathParams("p1", "booking", "p2", "1");
        Response response2 = given().contentType(ContentType.JSON).spec(spec01).when().get("{p1}/{p2}");

        HashMap<String, Object> actData = response2.as(HashMap.class);

        RestfulTestData bookingObject = new RestfulTestData();
        HashMap<String, Object> expData = bookingObject.booking7DataSetUp();

        response2.then().statusCode((Integer) expData.get("statusCode")).
                headers("Content-Type", equalTo(expData.get("contentType")),
                        "Via", equalTo(expData.get("Via"))).
                body("firstname", equalTo(expData.get("firstname")),
                "lastname", equalTo(expData.get("lastname")),
                "totalprice", equalTo(expData.get("totalprice")),
                "depositpaid", equalTo(expData.get("depositpaid")),
                "bookingDates.checkin", equalTo(expData.get("bookingDates.checkin")),
                "bookingDates.checkout", equalTo(expData.get("bookingDates.checkout")),
                "additionalneeds", equalTo(expData.get("additionalneeds")));
    }

    // Jsonpath
    @Test
    public void test03(){
        spec01.pathParams("p1", "booking", "p2", "1");
        Response response = given().contentType(ContentType.JSON).spec(spec01).when().get("{p1}/{p2}");

        HashMap<String, Object> actData = response.as(HashMap.class);

        RestfulTestData bookingObject = new RestfulTestData();
        HashMap<String, Object> expData = bookingObject.booking7DataSetUp();

        response.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8");
        JsonPath json = response.jsonPath();
        assertEquals(expData.get("firstname"),  json.getString("firstname"));
        assertEquals(expData.get("lastname"), json.getString("lastname"));
        assertEquals(expData.get("totalprice"), json.getInt("totalprice"));
        assertEquals(expData.get("depositpaid"), json.getBoolean("depositpaid"));
        assertEquals(expData.get("bookingdates.checkin"), json.getString("bookingdates.checkin"));
        assertEquals(expData.get("bookingdates.checkin"), json.getString("bookingdates.checkin"));
    }

    // Deserialization
    @Test
    public void test04(){
        spec01.pathParams("p1", "booking", "p2", "1");
        Response response = given().contentType(ContentType.JSON).spec(spec01).when().get("{p1}/{p2}");

        RestfulTestData restfulTestData = new RestfulTestData();
        HashMap<String, Object> expData = restfulTestData.booking7DataSetUp();
        assertEquals(expData.get("statusCode"), response.statusCode());
        assertEquals(expData.get("contentType"), response.contentType());

        HashMap<String, Object> actData = response.as(HashMap.class);

        assertEquals(expData.get("firstname"), actData.get("firstname"));
        assertEquals(expData.get("lastname"), actData.get("lastname"));
        assertEquals(expData.get("totalprice"), actData.get("totalprice"));
        assertEquals(expData.get("depositpaid"), actData.get("depositpaid"));
        assertEquals(  ((Map) expData.get("bookingdates")).get("checkin"), ((Map) actData.get("bookingdates")).get("checkin")  );
        assertEquals(  ( (Map) expData.get("bookingdates")).get("checkout"), ( (Map) actData.get("bookingdates")).get("checkout")  );
        assertEquals( (Map) expData.get("additionalneeds"), (Map) actData.get("additionalneeds"));

        /*
        status kodunun 200 ve
        content type'inin "application/json"

            "firstname": "Susan",
            "lastname": "Brown",
            "totalprice": 189,
            "depositpaid": false,
            "bookingdates": {
                    "checkin": "2017-08-15",
                    "checkout": "2018-12-01"
            "additionalneeds": "Breakfast"
        */
    }

    // Pojo
    @Test
    public void test05(){
        spec01.pathParams("p1", "booking", "p2", "1");
        Response response2 = given().contentType(ContentType.JSON).spec(spec01).when().get("{p1}/{p2}");


    }

    // ObjectMapper
    @Test
    public void test06(){
        spec01.pathParams("p1", "booking", "p2", "1");
        Response response2 = given().contentType(ContentType.JSON).spec(spec01).when().get("{p1}/{p2}");


    }

}
