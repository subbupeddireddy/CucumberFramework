package stepDefinitions;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import API.SAP_API;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.CommonResponse;
import webPages.StockTransferOrderPage;

public class StockDispatchStepDefinition2 {

	SubbuSharing share;
	RequestSpecification requestSpec;
	Response response;
	String myOrder = "0716459908";
	StockTransferOrderPage stop;

	String baseURI = "http://10.10.10.53:30123";

	SAP_API api = new SAP_API();

	String vehicleNo = "TestVehicle";
	String truckNo = "TestTruck";
	String sealNo = "TestSeal";
	String salesrequestEndPoint = "/sap/v1/doInvoiceDetails";
	String postPickListrequestEndPoint = "/sap/v1/send/sto/tosap";
	String storequestEndPoint ="/sap/v1/detailsSTO";

	public RequestSpecification getRequestSpec() {

		RequestSpecification reqSpec = new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri(baseURI)
				.addHeader("Authorization", "Bearer" + getToken()) // Authorization
				.log(LogDetail.ALL).build();

		return reqSpec;

	}

	public ResponseSpecification getResponseSpec(int statusCode) {

		ResponseSpecification resSpec = new ResponseSpecBuilder().expectStatusCode(statusCode)
				.expectContentType(ContentType.JSON).log(LogDetail.ALL).build();
		return resSpec;
	}

	public void sendSales() {

		SAP_API ap = new SAP_API();
		Response response = given().spec(getRequestSpec()).body(ap.getSalesPayload()).when().post(salesrequestEndPoint)
				.then().spec(getResponseSpec(200)).extract().response();

		CommonResponse resp = response.as(CommonResponse.class);

		System.out.println(resp.getMessage());
		System.out.println(resp.getStatus());

	}
	
	@Test
	public void cancelSalesOrder() {

		SAP_API ap = new SAP_API();
		Response response = given().spec(getRequestSpec()).body(ap.cancelSalesPayload()).when().post(salesrequestEndPoint)
				.then().spec(getResponseSpec(200)).extract().response();

		CommonResponse resp = response.as(CommonResponse.class);

		System.out.println(resp.getMessage());
		System.out.println(resp.getStatus());

	}

	
	public void sendPostPickList() {

		SAP_API ap = new SAP_API();
		String response = given().spec(getRequestSpec()).body(ap.postPickListPayload()).when()
				.post(postPickListrequestEndPoint).then().extract().response().asString();

		JsonPath js = new JsonPath(response);

		System.out.println(js.getString("Header.tripNo"));
		System.out.println(js.getString("Header.response"));
		System.out.println(js.getString("Header.responseType"));

	}

	// @Test(priority = 0)
	public void the_user_uses_sto_api() {

		response = given().spec(getRequestSpec())
				.when().post(storequestEndPoint)
				.then().spec(getResponseSpec(201))
				.extract().response();
		CommonResponse res = response.as(CommonResponse.class);

		Assert.assertTrue(Integer.parseInt(res.getStatus()) == (201));
		Assert.assertEquals(res.getMessage(), "Delivery Payload Received Successfully");

	}

	public String getToken() {

		String tokenRes = given()
				.auth().preemptive().basic("Ctel", "CteL12$")
				.formParam("scope", "read")
				.formParam("grant_type", "client_credentials")
				.log().all()
				.when().log().all()
				.post("http://10.10.10.53:30123/oauth/token")
				.then().log().all().extract()
				.response().asString();

		JsonPath js = new JsonPath(tokenRes);
		System.out.println(js.get("access_token") + "----------------->");
		return js.get("access_token");

	}

}
