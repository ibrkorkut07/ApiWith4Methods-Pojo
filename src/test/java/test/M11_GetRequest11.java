package test;

import baseUrl.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.DummyTestData;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class M11_GetRequest11 extends DummyBaseUrl {

    /*
    http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
    Status kodun 200 olduğunu,
    En yüksek maaşın 725000 olduğunu,
    En küçük yaşın 19 olduğunu,
    İkinci en yüksek maaşın 675000  olduğunu test edin.
     */

    // Jsonpath
    @Test
    public void test02(){
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "employees");
        Response response = given().spec(spec02).when().get("{p1}/{p2}/{p3}");

        response.then().assertThat().statusCode(200);
        JsonPath json = response.jsonPath();

        List<Integer> salaryList = json.getList("data.employee_salary");
        Collections.sort(salaryList);
        Assert.assertEquals((Integer) 725000, salaryList.get(salaryList.size()-1));
        List<Integer> ageList = json.getList("data.employee_age");
        Collections.sort(ageList);
        Assert.assertEquals((Integer) 19, ageList.get(0));
        Assert.assertEquals((Integer) 675000, salaryList.get(salaryList.size()-2));
    }

    // Deserialization
    @Test
    public void test03(){
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "employees");
        Response response = given().spec(spec02).when().get("{p1}/{p2}/{p3}");


    /*
    http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
    Status kodun 200 olduğunu,
    En yüksek maaşın 725000 olduğunu,
    En küçük yaşın 19 olduğunu,
    İkinci en yüksek maaşın 675000  olduğunu test edin.
    */
    }

    // Pojo
    @Test
    public void test04(){
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "employees");
        Response response = given().spec(spec02).when().get("{p1}/{p2}/{p3}");

    /*
    http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
    Status kodun 200 olduğunu,
    En yüksek maaşın 725000 olduğunu,
    En küçük yaşın 19 olduğunu,
    İkinci en yüksek maaşın 675000  olduğunu test edin.
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
    En yüksek maaşın 725000 olduğunu,
    En küçük yaşın 19 olduğunu,
    İkinci en yüksek maaşın 675000  olduğunu test edin.
    */
    }

}
