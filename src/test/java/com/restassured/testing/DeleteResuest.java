package com.restassured.testing;

import static com.jayway.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class DeleteResuest {
	
	
	@Test(enabled=true)
	public void testDelete() {
		
		Response resp= 	given().
						when().
						delete("http://localhost:3000/posts/2");
		
		System.out.println("Delete response " + resp.asString());

	}

}
