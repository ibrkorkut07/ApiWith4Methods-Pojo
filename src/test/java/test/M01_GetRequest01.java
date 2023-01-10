package test;

import baseUrl.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class M01_GetRequest01 extends RestfulBaseUrl {

   /*
    https://restful-booker.herokuapp.com/booking/3 adresine bir request gonderildiginde
    donecek cevap(response) icin
        HTTP status kodunun 200
        Content Type’in Json
        Ve Status Line’in HTTP/1.1 200 OK
    Oldugunu test edin
   */

    @Test
    public void test02(){
        spec01.pathParams("p1", "booking", "p2", "3");
        Response response = given().spec(spec01).when().get("{p1}/{p2}");

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("application/json; charset=utf-8", response.contentType());
        Assert.assertEquals("HTTP/1.1 200 OK", response.statusLine());
    }

    // Pojo
    @Test
    public void test05(){
        spec01.pathParams("p1", "booking", "p2", "3");
        Response response = given().spec(spec01).when().get("{p1}/{p2}");


                /*
        status kodunun 200
        Content Type’in Json
        Ve Status Line’in HTTP/1.1 200 OK
         */
    }

    // ObjectMapper
    @Test
    public void test06(){
        spec01.pathParams("p1", "booking", "p2", "3");
        Response response = given().spec(spec01).when().get("{p1}/{p2}");

                /*
        status kodunun 200
        Content Type’in Json
        Ve Status Line’in HTTP/1.1 200 OK
         */
    }

}
