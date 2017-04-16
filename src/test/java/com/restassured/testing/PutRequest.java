package com.restassured.testing;

import static com.jayway.restassured.RestAssured.given;

import org.testng.annotations.Test;

import apitesting.com.org.classes.Posts;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class PutRequest {
	
	
	@Test(enabled=true)
	public void testPut1() {
		
		/*
		 * In put request it is mandatory to send all tags
		 */
		
		Posts posts = new Posts();
		posts.setId("3");
		posts.setTitle("Selenium");
		posts.setAuthor("Raghu");
		
		Response resp = 	given().
							body(posts).
							when().
							contentType(ContentType.JSON).
							put("http://localhost:3000/posts/3");

		System.out.println("put response " + resp.asString());	
		
		

	}
	

}
