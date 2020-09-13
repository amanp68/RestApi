SkyScanner Rest API GET Method

GOAL of the Project - To fetch the data from SkyScanner public URL using Rest Assured Api.

API Method used - Rest API method GET Method

Platform and Language used - Eclipse (JAVA)

Framework - TestNG // Maven 

Libraries -             import org.testng.Assert;<br>
                        import org.testng.Assert; <br>
						import org.testng.annotations.Test;<br>
						import static io.restassured.RestAssured.*;<br>
						import io.restassured.RestAssured;<br>
						import io.restassured.path.json.JsonPath;</br>

Source URL's  - https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/autosuggest/v1.0/UK/GBP/en-GB/?query=Stockholm         

			<br>https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browseroutes/v1.0/US/USD/en-US/SFO-sky/ORD-sky/2021-09-01?inboundpartialdate=2021-12-01               
				
Methods used - JSON Path to traverse nested JSON response 
				Assert Method to compare Expected and Actual Result 
				
ACTUAL OUTPUT - 
1. Fetch response for List of Places using 1st Url and params//headers after that I used assertion to compare the Expected and Actual Result  and used JSON Path	to traverse in JSON path to get Place ID at 2nd place. <br>
2. Fetch response for the places available on on future date = 01/12/2021  and then traversed to Nested loop to bring all the places(Destinations) which can be visited.
		
