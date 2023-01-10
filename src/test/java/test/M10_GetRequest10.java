package test;


import baseUrl.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import testData.RestfulTestData;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class M10_GetRequest10 extends DummyBaseUrl {
    /*
    http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
    Status kodun 200 olduğunu,
    5. Çalışan isminin "Airi Satou" olduğunu ,
    çalışan sayısının 24 olduğunu,
    Sondan 2. çalışanın maaşının 106450 olduğunu
    40,21 ve 19 yaslarında çalışanlar olup olmadığını
    11. Çalışan bilgilerinin
    {
        “id”:”11”
        "employee_name": "Jena Gaines",
        "employee_salary": "90560",
        "employee_age": "30",
        "profile_image": "" }
    }   olduğunu test edin.
*/


    // Matchers without Testdata class
    @Test
    public void test01(){
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "employees");
        Response response = given().spec(spec02).when().get("{p1}/{p2}/{p3}");

        response.then().assertThat().statusCode(200).
                body("data[4].employee_name", equalTo("Airi Satou"),
                "data.id", hasSize(24),
                "data[-2].employee_salary", equalTo(106450),
                "data.employee_age", hasItems(40,21, 19));

        response.then().body("data[10].id", equalTo(11),
                    "data[10].employee_name", equalTo("Jena Gaines"),
                "data[10].employee_salary", equalTo(90560),
                "data[10].employee_age", equalTo(30),
                "data[10].profile_image", equalTo(""));
    }

    // Jsonpath
    @Test
    public void test02(){
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "employees");
        Response response = given().spec(spec02).when().get("{p1}/{p2}/{p3}");

        HashMap<String, Object> actData = response.as(HashMap.class);

        RestfulTestData restfulTestData = new RestfulTestData();
        HashMap<String, Object> expData = restfulTestData.emp10ExpdataMap();

        JsonPath json = response.jsonPath();
        List<Integer> ageList = json.getList("data.employee_age");
        // System.out.println(ageList);
        Integer dataSize = ageList.size();

        assertEquals(expData.get("4themployee_name"), json.get("data[4].employee_name"));
        assertEquals(expData.get("dataSize"), dataSize);
        assertEquals(expData.get("TheLastButEmployeeSalary"), json.get("data[-2].employee_salary"));

        List<Integer> expAgeList = Arrays.asList(19, 21, 40);
        // System.out.println(expAgeList);

        assertTrue(ageList.containsAll(expAgeList));
        assertEquals(expData.get("10thEmployeeId"), json.get("data[10].id"));
        assertEquals(expData.get("10thEmployeeName"), json.get("data[10].employee_name"));
        assertEquals(expData.get("10thEmployeeSalary"), json.get("data[10].employee_salary"));
        assertEquals(expData.get("10thEmployeeAge"), json.get("data[10].employee_age"));
        assertEquals(expData.get("10thEmployeeProfileImage"), json.get("data[10].profile_image"));
    }

    // Deserialization
    @Test
    public void test03(){
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "employees");
        Response response = given().spec(spec02).when().get("{p1}/{p2}/{p3}");

        HashMap<String, Object> actData = response.as(HashMap.class);

        RestfulTestData restfulTestData = new RestfulTestData();
        HashMap<String, Object> expData = restfulTestData.emp10ExpdataMap();

        JsonPath json = response.jsonPath();

        assertEquals(expData.get("statusCode"), actData.get("statusCode"));
        assertEquals(expData.get("4themployee_name"), actData.get("data[4].employee_name"));
        assertEquals(expData.get("dataSize"), ((HashMap) actData.get("data.id")).size());
        assertEquals(expData.get(""), actData.get(""));
        assertEquals(expData.get(""), actData.get(""));
        assertEquals(expData.get(""), actData.get(""));
        assertEquals(expData.get(""), actData.get(""));
        assertEquals(expData.get(""), actData.get(""));
        assertEquals(expData.get(""), actData.get(""));
        assertEquals(expData.get(""), actData.get(""));
        assertEquals(expData.get(""), actData.get(""));
        assertEquals(expData.get(""), actData.get(""));

    /*
    Status kodun 200 olduğunu,
    5. Çalışan isminin "Airi Satou" olduğunu ,
    çalışan sayısının 24 olduğunu,
    Sondan 2. çalışanın maaşının 106450 olduğunu
    40,21 ve 19 yaslarında çalışanlar olup olmadığını
    11. Çalışan bilgilerinin
    {
        “id”:”11”
        "employee_name": "Jena Gaines",
        "employee_salary": "90560",
        "employee_age": "30",
        "profile_image": "" }
    }   olduğunu test edin.
    */
    }

    // Pojo
    @Test
    public void test04(){
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "employees");
        Response response = given().spec(spec02).when().get("{p1}/{p2}/{p3}");

    /*
    Status kodun 200 olduğunu,
    5. Çalışan isminin "Airi Satou" olduğunu ,
    çalışan sayısının 24 olduğunu,
    Sondan 2. çalışanın maaşının 106450 olduğunu
    40,21 ve 19 yaslarında çalışanlar olup olmadığını
    11. Çalışan bilgilerinin
    {
        “id”:”11”
        "employee_name": "Jena Gaines",
        "employee_salary": "90560",
        "employee_age": "30",
        "profile_image": "" }
    }   olduğunu test edin.
    */
    }

    // ObjectMapper
    @Test
    public void test05(){
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "employees");
        Response response = given().spec(spec02).when().get("{p1}/{p2}/{p3}");

    /*
    http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
    Status kodun 200 olduğunu,
    5. Çalışan isminin "Airi Satou" olduğunu ,
    çalışan sayısının 24 olduğunu,
    Sondan 2. çalışanın maaşının 106450 olduğunu
    40,21 ve 19 yaslarında çalışanlar olup olmadığını
    11. Çalışan bilgilerinin
    {
        “id”:”11”
        "employee_name": "Jena Gaines",
        "employee_salary": "90560",
        "employee_age": "30",
        "profile_image": "" }
    }   olduğunu test edin.
    */
    }

}
