package com.restassured.testing;

import static com.jayway.restassured.RestAssured.given;

import org.testng.annotations.Test;

import apitesting.com.org.classes.Posts;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class PatchRequest {
	
	/* Patch is also an update transaction
	 * In patch request it is not mandatory to send all tags.
	 * Only required tags can be sent, rest all tag values will remain same
	 */
	
	
	@Test(priority=1,enabled=false)
	public void testPatch1() {
		
		/*
		 * In put request it is mandatory to send all tags
		 */
		
		Posts posts = new Posts();
		posts.setAuthor("Munnabhai");
		
		/*
		 * if u use object as message body, then non-use tags will be null. So always use String as message body.
		 */
		
		Response resp = 	given().
							body(posts).
							when().
							contentType(ContentType.JSON).
							patch("http://localhost:3000/posts/3");

		System.out.println("patch response " + resp.asString());	

	}
	
	
	
	@Test(priority=2,enabled=true)
	public void testPatch2() {
		
		/*
		 * In put request it is mandatory to send all tags
		 */
		
		String messageBody = "{"
							+"\"title\": \"MBBS FAQ\""
							+"}";
		
		Response resp = 	given().
							body(messageBody).
							when().
							contentType(ContentType.JSON).
							patch("http://localhost:3000/posts/3");

		System.out.println("patch response " + resp.asString());	

	}

}
