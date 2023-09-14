package seleniumresttests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GetSearchSpecBuilderTest {

	@Test(groups = "Api Testing")
	public void GetProductData() {

		// get https://search.gigatron.rs/v1/search/get?pojam=logitech g935
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://search.gigatron.rs/")
				.addQueryParam("pojam", "logitech g935").setContentType(ContentType.JSON).build();
		// Assert status code in response
		ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
				.build();

		RequestSpecification response = given().spec(req);

		Response resp = response.when().get("/v1/search/get").then().spec(res).extract().response();

		String responseString = resp.asString();

		// response string -> json
		JsonPath js1 = new JsonPath(responseString);
		String productName = js1.get("hits.hits[0]._source.search_result_data.name");
		String productBrand = js1.get("hits.hits[0]._source.search_result_data.brand");

		// Soft Assert for couple of fields in response - one will fail
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(
				productName.equalsIgnoreCase("LOGITECH gejmerske slušalice G935 Wireless (Bela) 981 000744"));
		softAssert.assertTrue(productBrand.equalsIgnoreCase("Logitech"));
		System.out.println(productName);
		System.out.println(productBrand);
		softAssert.assertAll();

	}

}
