package generic;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {
	@BeforeMethod 
	public RequestSpecification Request(String url)
	{
		RequestSpecBuilder spec= new RequestSpecBuilder();
		RequestSpecification req = spec.setBaseUri(url).
		setContentType(ContentType.JSON).build();
		return req;
	}
	@AfterMethod
	public ResponseSpecification Response(int code)
	{
		ResponseSpecBuilder spec= new ResponseSpecBuilder();
		ResponseSpecification res = spec.expectStatusCode(code).
		expectContentType(ContentType.JSON).build();
		return res;
	}

}
