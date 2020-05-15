package com.restassured.api;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Test01_Get {

	@Test
	public void test1() {

		given().get("https://reqres.in/api/users?page=2").then().
		statusCode(200).
		body("data.id[1]", equalTo(8)).
		body("data.first_name", hasItems("Michael","Lindsay")).
		log().all();

	}

}
