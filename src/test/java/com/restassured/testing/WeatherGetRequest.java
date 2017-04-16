package com.restassured.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class WeatherGetRequest {

	@Test(enabled=false)
	public void simpleGETRequest() {
		
		Response resp= when().
				       get("http://samples.openweathermap.org/data/2.5/weather?q=London&appid=b1b15e88fa797225412429c1c50c122a1");
		
		Assert.assertEquals(resp.getStatusCode(), 200);

	}
	
	@Test(enabled=false)
	public void simpleGETRequestUsingParam() {
		
		Response resp= 	given().
						param("q", "London").
						param("appid","b1b15e88fa797225412429c1c50c122a1").
						when().
						get("http://samples.openweathermap.org/data/2.5/weather?q=London&appid=b1b15e88fa797225412429c1c50c122a1");
		
		Assert.assertEquals(resp.getStatusCode(), 200);

	}
	
	
	@Test(enabled=false)
	public void simpleGETRequest_Assertion() {
		
						given().
						param("q", "London").
						param("appid","b1b15e88fa797225412429c1c50c122a1").
						when().
						get("http://samples.openweathermap.org/data/2.5/weather").
						then().
						assertThat().
						statusCode(200);

	}
	
	@Test(enabled=false)
	public void checkResponse(){
		
		Response response = given().
							param("q", "London").
							param("appid","b1b15e88fa797225412429c1c50c122a1").
							when().
							get("http://samples.openweathermap.org/data/2.5/weather");
		
		System.out.println(response.asString());
		
	}
	
	
	@Test(enabled=false)
	public void anotherGet(){
		
		Response response = given().
							param("id", "2172797").
							param("appid","b1b15e88fa797225412429c1c50c122a1").
							when().
							get("http://samples.openweathermap.org/data/2.5/weather");
		
		Assert.assertEquals(response.getStatusCode(), 200);


		
	}
	
	@Test(enabled=false)
	public void ohjustanotherGet(){
		
		Response response = given().
							param("zip", "201010,in").
							param("appid","b1b15e88fa797225412429c1c50c122a1").
							when().
							get("http://samples.openweathermap.org/data/2.5/weather");
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	@Test(enabled=false)
	public void responseExtraction(){
		
	String weatherDesc =	given().
							param("id", "2172797").
							param("appid","b1b15e88fa797225412429c1c50c122a1").
							when().
							get("http://samples.openweathermap.org/data/2.5/weather").
							then().
							contentType(ContentType.JSON).
							extract().
							path("weather[0].description");
	
	System.out.println("Wweather Description: " + weatherDesc);
		
		
	}
	
	@Test(enabled=true)
	public void responseExtractionn(){
		
	Response response =	    given().
							param("id", "2172797").
							param("appid","b1b15e88fa797225412429c1c50c122a1").
							when().
							get("http://samples.openweathermap.org/data/2.5/weather");
	
	
		String weatherDesc=	response.	
							then().
							contentType(ContentType.JSON).
							extract().
							path("weather[0].description");
	
	  System.out.println("Wweather Description: " + weatherDesc);
	
	  
	  Float longitude=	response.	
						then().
						contentType(ContentType.JSON).
						extract().
						path("coord.lon");

	  System.out.println("Wweather Description: " + longitude.toString());
	  
	  
	  Float latitude=	response.	
						then().
						contentType(ContentType.JSON).
						extract().
						path("coord.lat");

	  System.out.println("Wweather Description: " + latitude.toString());
	  
	  
	  String responsebyCoordinates =	given().
										param("latitude", latitude.toString()).
										param("longitude", longitude.toString()).
										param("appid","b1b15e88fa797225412429c1c50c122a1").
										when().
										get("http://samples.openweathermap.org/data/2.5/weather").
										then().
										contentType(ContentType.JSON).
										extract().
										path("weather[0].description");
	  
	  System.out.println("Wweather Description: " + responsebyCoordinates);
		
		
	}

}
