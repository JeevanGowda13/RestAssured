package ShopperProfile;

import org.testng.annotations.Test;

import generic.SpecBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.Framework_Constants;
import utils.Get_Property;

public class Create_Shopper implements Framework_Constants{
	@Test
	public void Create() {
		Get_Property gp = new Get_Property();
		String baseUrl = gp.GetProperty("baseUrl");
		String endpoint = gp.GetProperty("createShopper");
		SpecBuilder spec= new SpecBuilder();
		RequestSpecification req = spec.Request(baseUrl);
		ResponseSpecification res = spec.Response(Created);
		Response resp = RestAssured.given().spec(req).body("{\r\n"
				+ "  \"city\": \"Bangalore\",\r\n"
				+ "  \"country\": \"India\",\r\n"
				+ "  \"email\": \"jeevan99fjk8@gmail.com\",\r\n"
				+ "  \"firstName\": \"power\",\r\n"
				+ "  \"gender\": \"MALE\",\r\n"
				+ "  \"lastName\": \"Star\",\r\n"
				+ "  \"password\": \"Power@123\",\r\n"
				+ "  \"phone\": 9876543210,\r\n"
				+ "  \"state\": \"Karnataka\",\r\n"
				+ "  \"zoneId\": \"ALPHA\"\r\n"
				+ "}").when().post(endpoint).then().spec(res).extract().response();
		String respo = resp.asString();
		/*
		 * if (respo.matches(respo)) { System.out.println("pass");
		 * 
		 * } else { System.out.println("fail");
		 * 
		 * }
		 */
		System.out.println(resp.getStatusCode());
	}
	
	
}
