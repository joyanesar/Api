package Api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetTest {
    String url = "https://jsonplaceholder.typicode.com/todos";

    @Test
    public void getRequest() {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(url);

        //print and verify status code
        System.out.println(response.statusCode());
        assertEquals(200, response.statusCode());
        //assert body
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");
        System.out.println(response.contentType());

    }

    @Test
    public void PostRequest() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .when().post(url);

        //print post code
        System.out.println(response.statusCode());
        //verify
        assertEquals(201, response.statusCode());
        //verify body
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");
        //print body
        System.out.println(response.contentType());

    }
    @Test
    public void putRequest(){

        Response response = RestAssured.given().contentType(ContentType.JSON)
                        .when().put(url);

        System.out.println(response.statusCode());
        assertEquals(response.statusCode(),204);

}
    @Test
    public void deleteRequest(){
      Response response = RestAssured.given().accept(ContentType.JSON)
              .and().contentType(ContentType.JSON)
              .when().delete(url);

      //print status code
        System.out.println(response.statusCode());
        //verify
       // assertEquals(204,response.statusCode());
        //body
        Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");
    }
}
