package com.restassured.testing;

import static com.jayway.restassured.RestAssured.given;

import org.testng.annotations.Test;

import apitesting.com.org.classes.Info;
import apitesting.com.org.classes.PersonalData;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class ComplexPosts {
	
	
	@Test(enabled=true)
	public void testComplexPost() {
		
		Info info = new Info();
		info.setEmail("dhage.gaurav@gmail.com");
		info.setPhone("9890144396");
		info.setAddress("Mahadik Colony");
		
		PersonalData messageBody = new PersonalData();
		messageBody.setAuthor("Rambow 1");
		messageBody.setId("10");
		messageBody.setTitle("Khatarnak Khiladi");
		messageBody.setInfo(info);
		
		Response resp = 	given().
							body(messageBody).
							when().
							contentType(ContentType.JSON).
							post("http://localhost:3000/posts");

		System.out.println("complex post response " + resp.asString());	
	}

}
