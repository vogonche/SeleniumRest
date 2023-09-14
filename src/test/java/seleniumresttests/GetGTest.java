package seleniumresttests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetGTest {

	@Test(groups = { "Api Testing" })
	public void GetProduct() {
		// get https://search.gigatron.rs/v1/search/get?pojam=logitech g935
		RestAssured.baseURI = "https://search.gigatron.rs/";
		String getPlaceResponse = given().log().all().queryParam("pojam", "logitech g935").when().get("/v1/search/get")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println("*****************************************************");
		System.out.println(getPlaceResponse);

	}
}
