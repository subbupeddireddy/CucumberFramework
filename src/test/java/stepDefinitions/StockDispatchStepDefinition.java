package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.GetPayLoad;
import webPages.StockTransferOrderPage;

public class StockDispatchStepDefinition {

	SubbuSharing share;
	RequestSpecification requestSpec;
	Response response;
	String myOrder = "0716459908";
	StockTransferOrderPage stop;

	String vehicleNo = "TestVehicle";
	String truckNo = "TestTruck";
	String sealNo = "TestSeal";

	public StockDispatchStepDefinition(SubbuSharing share) throws Exception {
		this.share = share;
		stop = share.pages.getStockTransferOrderPage();
	}

	public String getToken() {

		String tokenRes = given().auth().preemptive().basic("Ctel", "CteL12$").formParam("scope", "read")
				.formParam("grant_type", "client_credentials").log().all().when().log().all()
				.post("http://10.10.10.53:30123/oauth/token").then().log().all().extract().response().asString();

		JsonPath js = new JsonPath(tokenRes);
		System.out.println(js.get("access_token") + "----------------->");
		return js.get("access_token");

	}

	@Given("the user uses STO API")
	public void the_user_uses_sto_api() {

		String baseURI = "http://10.10.10.53:30123";
		String token = getToken();
		System.out.println("MY token-->" + token);
		requestSpec = new RequestSpecBuilder().setBaseUri(baseURI).setContentType(ContentType.JSON)
				.addHeader("Authorization", "Bearer" + token).setBody(GetPayLoad.getSTOAPI(myOrder)).build();

	}

	@Given("the user is on the STO order page")
	public void userIsOnstoPage() throws Exception {
		share.driver.get(share.utils.getProperty("maindevurl"));

		share.pages.getLoginPage().signIn("T5300", "Admin@123");

		share.driver.get(share.utils.getProperty("bottlingwms"));

	}

	@When("the user clicks on {string} to add transport details")
	public void addTransportDetails(String status) throws Exception {
		stop.searchOrder(myOrder);
		String actualOrderNo = stop.getOrderNumber();
		Assert.assertEquals(actualOrderNo, myOrder, "Incorrect order no");
		stop.clickOnAction();
		stop.enterVehicleNumber(vehicleNo);
		stop.enterTruckNumber(truckNo);
		stop.enterSealNumber(sealNo);

	}

	@When("the user submits the vehicle information")
	public void clickOnTransportDetails() {
		stop.clickOnSaveBtn();
		System.out.println("After click");
	}

	@Then("the vehicle details are displayed")
	public void verifyVehicleDetails() {
		System.out.println("order number fecthinh--->"+myOrder);
		stop.searchOrder(myOrder);
		System.out.println("order number searched--->"+myOrder);

		String actualOrderNo = stop.getOrderNumber();
		Assert.assertEquals(actualOrderNo, myOrder, "Incorrect order no");
		String actualvehicleNo = stop.fetchVehicleNumber();

		Assert.assertEquals(actualvehicleNo, vehicleNo);
	}

	@Then("the status is updated to {string}")
	public void verifyStatus(String status) {

		stop.searchOrder(myOrder);
		String actualOrderNo = stop.getOrderNumber();
		Assert.assertEquals(actualOrderNo, myOrder, "Incorrect order no");
		String actualStatus = stop.getStatus();
		Assert.assertEquals(actualStatus, status, "Not corect");

	}

	@When("the user sends a POST request")
	public void the_user_sends_a_post_request() {

		response = given().spec(requestSpec).when().log().all().post("/sap/v1/detailsSTO");
	}

	@Then("a success response should be displayed")
	public void a_success_response_should_be_displayed() {
		response.then().

				log().all().assertThat().statusCode(201)
				.body("message", equalTo("Delivery Payload Received Successfully")).extract().response().asString();

	}

	@Then("the STO order should be displayed in the web application")
	public void the_sto_order_should_be_displayed_in_the_web_application() throws Exception {

		userIsOnstoPage();
		stop.searchOrder(myOrder);
		String actualOrderNo = stop.getOrderNumber();
		String actualOrderNoStatus = stop.getOrderNumberStatus();

		System.out.println(actualOrderNo + "----&&&------" + actualOrderNoStatus);
		Assert.assertEquals(actualOrderNo, myOrder, "Incorrect order no");
		Assert.assertEquals(actualOrderNoStatus, "New", "Incorrect Order status");

	}

}
