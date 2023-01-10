package test;

import baseUrl.RestfulBaseUrl;
import org.junit.Test;
import static io.restassured.RestAssured.given;

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

    // Deserialization
    @Test
    public void test04(){
        spec01.pathParam("p", "booking");


    }

    // Pojo
    @Test
    public void test05(){
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

    // ObjectMapper
    @Test
    public void test06(){
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

}

