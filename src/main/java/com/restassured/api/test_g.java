package com.restassured.api;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class test_g {
	@Test
	public void Get_test() {

		baseURI="http://localhost:3000/";
		//GET-1
		given().
		get("/users").then().
		statusCode(200).
		log().all();

		//GET-2
		given().
		param("name", "Maths").
		get("/subjects").then().
		statusCode(200).
		log().all();
	}
	@Test
	public void POST_test() {
		baseURI="http://localhost:3000/";
		//POST-1
		JSONObject request = new JSONObject();
		request.put("firstName", "Adhi");
		request.put("lastName", "Thilakumara");
		request.put("subjectID", 1);

		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		header("Content-Type", "application/json").
		body(request.toJSONString()).
		when().
		post("/users").
		then().statusCode(201).
		log().all();
	}
	@Test	
	public void PATCH_test() {
		baseURI="http://localhost:3000/";
		//POST-1
		JSONObject request = new JSONObject();
		request.put("lastName", "Weerasinghe");


		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		header("Content-Type", "application/json").
		body(request.toJSONString()).
		when().patch("/users/3").
		then().statusCode(200).
		log().all();
	}
	@Test	
	public void PUT_test1() {
		baseURI="http://localhost:3000/";

		//POST-1
		JSONObject request = new JSONObject();
		request.put("firstName", "Chaya");
		request.put("lastName", "Thilakumara");
		request.put("subjectID", 1);

		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		header("Content-Type", "application/json").
		body(request.toJSONString()).
		when().
		put("/users/6").
		then().statusCode(200).
		log().all();
	}
	@Test	
	public void DELETE_test1() {
		baseURI="http://localhost:3000/";
		JSONObject request = new JSONObject();
		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		header("Content-Type", "application/json").
		body(request.toJSONString()).
		when().delete("/users/4").
		then().statusCode(200).
		log().all();
	}


}