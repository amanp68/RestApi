package SkyScanner;

import io.restassured.path.json.JsonPath;


public class ReusableMethod {

	public static JsonPath rawTojson(String PlaceResponse) {
		JsonPath gp  =new JsonPath(PlaceResponse);
		return gp;
		
	}

}
