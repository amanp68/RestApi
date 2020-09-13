package SkyScanner;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetMethodCalls extends ReusableMethod {

	@Test
	public void getListPlaces() {
		String expectedPlaceId = "ARN-sky";
		RestAssured.baseURI = "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/"; // base URL to get places														
		String PlaceResponse = given().log().all()
				.header("x-rapidapi-key", "76fe064b0cmsh17bf07ad57399c5p17bca7jsnc8faf69fbe2f").when() // key to be used for the connection with SkyScanner URL																						
				.get("apiservices/autosuggest/v1.0/UK/GBP/en-GB/?query=Stockholm").then().log().all().assertThat() // URL resources
				.statusCode(200).extract().response().asString();
		System.out.println(PlaceResponse);
		// Using JsonPath to traverse nested JSON response and searching for the PlaceId of 2nd place
		JsonPath gp = ReusableMethod.rawTojson(PlaceResponse);
		String actualPlaceId = gp.get("Places[1].PlaceId"); // traversing in the JSON response
		System.out.println(actualPlaceId);
		if (actualPlaceId.equalsIgnoreCase(expectedPlaceId)) {
			String message = gp.get("Places[1].PlaceId").toString();
			System.out.println("Place id of 2nd place is = " + actualPlaceId);
			Assert.assertEquals(message, expectedPlaceId); // Using assert method to compare the expected and Actual output
		}
	}

	@Test
	public void getBrowseRoutes() {
		RestAssured.baseURI = "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/"; // base URLto get routes
		String routesAvailable = given().log().all()
				.header("x-rapidapi-key", "76fe064b0cmsh17bf07ad57399c5p17bca7jsnc8faf69fbe2f").when()
				.get("apiservices/browseroutes/v1.0/US/USD/en-US/SFO-sky/ORD-sky/2021-09-01?inboundpartialdate=2021-12-01")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(routesAvailable);
		// Nested JSON response traversing
		JsonPath gp = ReusableMethod.rawTojson(routesAvailable);
		int count = gp.getInt("Places.size()");
		System.out.println("Total number of places on 01/12/2021 are " + count);
		for (int i = 0; i < count; i++) {
			String PlacesCityname = gp.get("Places[" + i + "].CityName");
			System.out.println("Place available " + PlacesCityname);
		}
	}
}
