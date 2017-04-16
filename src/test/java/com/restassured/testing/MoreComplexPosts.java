package com.restassured.testing;

import static com.jayway.restassured.RestAssured.given;

import org.testng.annotations.Test;

import apitesting.com.org.classes.GenericData;
import apitesting.com.org.classes.Information;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class MoreComplexPosts {
	
	@Test(enabled=true)
	public void testMoreComplexPost() {
		
		Information info1 = new Information ();
		info1.setEmail("dhage.gaurav_1@gmail.com");
		info1.setPhone("123456789");
		info1.setAddress("Mahadik Colony_1");
		
		
		Information info2 = new Information ();
		info2.setEmail("dhage.gaurav_2@gmail.com");
		info2.setPhone("223456789");
		info2.setAddress("Mahadik Colony_2");
		
		GenericData messageBody = new GenericData();
		messageBody.setAuthor("Rambow 1");
		messageBody.setId("100");
		messageBody.setTitle("Khatarnak Khiladi");
		messageBody.setInformation(new Information[]{info1,info2});
		
		Response resp = 	given().
							body(messageBody).
							when().
							contentType(ContentType.JSON).
							post("http://localhost:3000/posts");

		System.out.println("More complex post response " + resp.asString());	
	}

}
