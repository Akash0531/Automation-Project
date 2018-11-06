package com.dikshatech.tst.utilitylibrary;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestApiScript {

	@Test(priority= 0, enabled= true)
	public void restGet() {
		Response resp = RestAssured.get("http://localhost:3000/posts");
		int actual = resp.getStatusCode();
		System.out.println("Status code is : " + actual);
		Assert.assertEquals(actual, 200);
	}
	
	@Test(priority= 1, enabled= true)
	public void restPost() {

		RequestSpecification req = RestAssured.given();
		req.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("id", "18");
		json.put("title", "Post Method");
		json.put("author", "Automation Script");

		req.body(json.toJSONString());
		Response resp =req.post("http://localhost:3000/posts");
		int actual = resp.getStatusCode();
		System.out.println("Status code is : " + actual);
		Assert.assertEquals(actual, 201);
	}

	@Test(priority= 2, enabled= true)
	public void restPut() {
		RequestSpecification req = RestAssured.given();
		req.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("id", "1");
		json.put("title", "Put Method");
		json.put("author", "Selenium Script");

		req.body(json.toJSONString());
		Response resp =req.put("http://localhost:3000/posts/1");
		int actual = resp.getStatusCode();
		System.out.println("Status code is : " + actual);
		Assert.assertEquals(actual, 200);

	}

	@Test(priority= 3, enabled= true)
	public void restDelete() {

		Response resp = RestAssured.delete("http://localhost:3000/posts/14");
		int actual = resp.getStatusCode();
		System.out.println("Status code is : " + actual);
		Assert.assertEquals(actual, 200);
	}
}
