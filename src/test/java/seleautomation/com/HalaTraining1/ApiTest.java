package seleautomation.com.HalaTraining1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ApiTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testPostsApi() {
        Response response = RestAssured.get("/posts");

        // Test for successful response
        Assert.assertEquals(response.statusCode(), 200);

        // Test for title of post with id 17
        List<Object> posts = response.jsonPath().getList("");
        Object post17 = posts.get(16); // Index 16 for id 17
        Assert.assertEquals(post17.toString(), "{\"userId\":1, \"id\":17, \"title\":\"fugiat voluptas sed molestias voluptatem provident\", \"body\":\"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"}");

        // Test for non-empty values in required keys
        for (Object post : posts) {
            Assert.assertNotNull(post.get("userId"));
            Assert.assertNotNull(post.get("id"));
            Assert.assertNotNull(post.get("body"));
            Assert.assertNotNull(post.get("title"));
        }
    }

    @Test
    public void testUsersApi() {
        Response response = RestAssured.get("/users");

        // Test for successful response
        Assert.assertEquals(response.statusCode(), 200);

        // Count the number of ids
        int numberOfIds = response.jsonPath().getList("id").size();
        System.out.println("Number of ids: " + numberOfIds);

        // Print each id with the relative name
        List<Object> users = response.jsonPath().getList("");
        for (Object user : users) {
            System.out.println("Id: " + user.get("id") + ", Name: " + user.get("name"));
        }
    }
}