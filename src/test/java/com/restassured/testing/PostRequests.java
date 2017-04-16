package com.restassured.testing;

import static com.jayway.restassured.RestAssured.given;

import org.testng.annotations.Test;

import apitesting.com.org.classes.Posts;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class PostRequests {
	

	@Test(enabled=false)
	public void testGet() {
		
		Response resp= 	given().
						when().
						get("http://localhost:3000/posts");
		
		System.out.println("Response is " + resp.asString());
	}
	

	@Test(enabled=false)
	public void testPost() {
		
	String messageBody = "{"
						+"\"id\": \"2\","
						+"\"title\": \"Rambow2\","
						+"\"author\": \"Prashant\""
						+"}";
	
		
		Response resp= 	given().
						body(messageBody).
						when().
						contentType(ContentType.JSON).
						post("http://localhost:3000/posts");
		
		System.out.println("post response " + resp.asString());

	}
	
	
	@Test(enabled=true)
	public void testPost2() {
		
		Posts posts = new Posts();
		posts.setId("3");
		posts.setTitle("QTP");
		posts.setAuthor("Gaurav");
		
		Response resp = 	given().
							body(posts).
							when().
							contentType(ContentType.JSON).
							post("http://localhost:3000/posts");

		System.out.println("post response " + resp.asString());	
		
		

	}
	
	
	

}
