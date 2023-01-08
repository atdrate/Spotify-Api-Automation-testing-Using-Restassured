package com.bridgelabz.qa.api_automation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Json_Server_Api_Automation_Test {
	
	@Test
	public void get_All_Post() {
		Response response = RestAssured.get("http://localhost:3000/posts");
		System.out.println("Response code: " +response.getStatusCode());
		Assert.assertEquals(200, response.getStatusCode());
		response.prettyPrint();	
	}

	@Test
	public void get_Specific_Post() {
		Response response = RestAssured.get("http://localhost:3000/posts/2");
		System.out.println("Response code: " +response.getStatusCode());
		Assert.assertEquals(200, response.getStatusCode());
		response.prettyPrint();	
	}
	
	@Test
	public void create_Post() {
	RequestSpecification requestSpecification = RestAssured.given();
	requestSpecification.header("Content-Type","application/json");
	JSONObject json = new JSONObject();
	json.put("id", 9);
	json.put("title", "nineth post");
	json.put("author", "cqa");
	requestSpecification.body(json.toJSONString());
	Response response = requestSpecification.post("http://localhost:3000/posts");
	System.out.println("Response code : " +response.getStatusCode());
	Assert.assertEquals(201, response.getStatusCode());
	response.prettyPrint();	
	}
	
	@Test
	public void put_Update_Post() {
	RequestSpecification requestSpecification = RestAssured.given();
	requestSpecification.header("Content-Type","application/json");
	JSONObject json = new JSONObject();
	//json.put("id", 7);
	json.put("title", "seventh updated post");
	json.put("author", "cqa");
	requestSpecification.body(json.toJSONString());
	Response response = requestSpecification.put("http://localhost:3000/posts/7");
	System.out.println("Response code : " +response.getStatusCode());
	Assert.assertEquals(200, response.getStatusCode());
	response.prettyPrint();	
	}
	
	@Test
	public void patch_Update_Post() {
	RequestSpecification requestSpecification = RestAssured.given();
	requestSpecification.header("Content-Type","application/json");
	JSONObject json = new JSONObject();
	//json.put("title", "seventh updated post");
	json.put("author", "patch cqa");
	requestSpecification.body(json.toJSONString());
	Response response = requestSpecification.patch("http://localhost:3000/posts/7");
	System.out.println("Response code : " +response.getStatusCode());
	Assert.assertEquals(200, response.getStatusCode());
	response.prettyPrint();	
	}
	
	@Test
	public void delete_Post() {
		Response response = RestAssured.delete("http://localhost:3000/posts/9");
		System.out.println("Response code: " +response.getStatusCode());
		Assert.assertEquals(200, response.getStatusCode());
		response.prettyPrint();	
	}
	
	@Test
	public void get_All_Comment() {
		Response response = RestAssured.get("http://localhost:3000/comments");
		System.out.println("Response code: " +response.getStatusCode());
		Assert.assertEquals(200, response.getStatusCode());
		response.prettyPrint();	
	}
	
	@Test
	public void get_Specific_Comment() {
		Response response = RestAssured.get("http://localhost:3000/comments/2");
		System.out.println("Response code: " +response.getStatusCode());
		Assert.assertEquals(200, response.getStatusCode());
		response.prettyPrint();	
	}
	
	@Test
	public void create_Comment() {
	RequestSpecification requestSpecification = RestAssured.given();
	requestSpecification.header("Content-Type","application/json");
	JSONObject json = new JSONObject();
	json.put("id", 7);
	json.put("body", "Seventh comment for second post");
	json.put("postId", 2);
	requestSpecification.body(json.toJSONString());
	Response response = requestSpecification.post("http://localhost:3000/comments");
	System.out.println("Response code : " +response.getStatusCode());
	Assert.assertEquals(201, response.getStatusCode());
	response.prettyPrint();	
	}
	
	@Test
	public void put_Update_Comment() {
	RequestSpecification requestSpecification = RestAssured.given();
	requestSpecification.header("Content-Type","application/json");
	JSONObject json = new JSONObject();
	json.put("title", "Seventh updated comment for second post");
	json.put("postId", "2");
	requestSpecification.body(json.toJSONString());
	Response response = requestSpecification.put("http://localhost:3000/comments/6");
	System.out.println("Response code : " +response.getStatusCode());
	Assert.assertEquals(200, response.getStatusCode());
	response.prettyPrint();	
	}
	
	@Test
	public void delete_Comment() {
		Response response = RestAssured.delete("http://localhost:3000/comments/7");
		System.out.println("Response code: " +response.getStatusCode());
		Assert.assertEquals(200, response.getStatusCode());
		response.prettyPrint();	
	}
	
	@Test
	public void get_All_Comment_For_Perticular_Post() {
		Response response = RestAssured.get("http://localhost:3000/comments?postId=1");
		System.out.println("Response code: " +response.getStatusCode());
		Assert.assertEquals(200, response.getStatusCode());
		response.prettyPrint();	
	}
	
	@Test
	public void get_All_Profile() {
		Response response = RestAssured.get("http://localhost:3000/profile");
		System.out.println("Response code: " +response.getStatusCode());
		Assert.assertEquals(200, response.getStatusCode());
		response.prettyPrint();	
	}
	
	@Test
	public void create_Profile() {
	RequestSpecification requestSpecification = RestAssured.given();
	requestSpecification.header("Content-Type","application/json");
	JSONObject json = new JSONObject();
	json.put("name", "tester");
	requestSpecification.body(json.toJSONString());
	Response response = requestSpecification.post("http://localhost:3000/profile");
	System.out.println("Response code : " +response.getStatusCode());
	Assert.assertEquals(201, response.getStatusCode());
	response.prettyPrint();	
	}
	
	@Test
	public void put_Update_Profile() {
	RequestSpecification requestSpecification = RestAssured.given();
	requestSpecification.header("Content-Type","application/json");
	JSONObject json = new JSONObject();
	json.put("name", "testing");
	requestSpecification.body(json.toJSONString());
	Response response = requestSpecification.put("http://localhost:3000/profile");
	System.out.println("Response code : " +response.getStatusCode());
	Assert.assertEquals(200, response.getStatusCode());
	response.prettyPrint();	
	}
	


}
