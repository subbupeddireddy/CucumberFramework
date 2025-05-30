package API;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.TeritaryResponse;

public class TeritaryAPI {
	
	
	String baseURI = "http://10.10.10.53:30123/";
	
	String encryptEndPoint="tertiary/v1/encrypt/data";
	String decryptEndPoint="tertiary/v1/decrypt/data";
	String loginEndPoint="v1/login";
	

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

	public RequestSpecification getRequestSpec() {

		RequestSpecification reqSpec = new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri(baseURI)
				.addHeader("Authorization", "Bearer" + getToken()) // Authorization
				.log(LogDetail.ALL).build();

		return reqSpec;

	}

	public ResponseSpecification getResponseSpec(int statusCode) {

		ResponseSpecification resSpec = new ResponseSpecBuilder().expectStatusCode(statusCode)
				.expectContentType("text/plain;charset=UTF-8").log(LogDetail.ALL).build();
		return resSpec;
	}

	
	
	public void encryptData() {
		
		
		String userId="B5200";
		String encryptedval=given().spec(getRequestSpec())
				.body("{\r\n"
						+ "    \"username\": \""+userId+"\",\r\n"
						+ "    \"password\": \"e86f78a8a3caf0b60d8e74e5942aa6d86dc150cd3c03338aef25b7d2d7e3acc7\"\r\n"
						+ "}")
		.when().post(encryptEndPoint)
		.then().spec(getResponseSpec(200)).extract().asString();
		
		System.out.println(encryptedval);
		
		
		
		
	String loginRespone=	given().spec(getRequestSpec())
			.body("{\r\n"
				    + "\"dataKey\" : \"" + encryptedval + "\"\r\n" + "}")

		.when().post(loginEndPoint)
		.then().extract().asString();
	
 String ad=new JsonPath(loginRespone).getString("userResponse");
		
		System.out.println("--***--->"+ad);
		
		
		
		String decryptedData=	given().spec(getRequestSpec())
		.body("{\r\n"
				+ "\"dataKey\" : \""+ad+"\"}")
		.when().post(decryptEndPoint).then().extract().response().asString();
		
		
     TeritaryResponse resp = new JsonPath(decryptedData).getObject("", TeritaryResponse.class);
   


	System.out.println(	resp.getUserDetails().getUserName());
	System.out.println(	resp.getUserDetails().getFirstName());
	System.out.println(	resp.getUserDetails().getRolePermissionMap().get(0).getId());
	
//	 Assert.	assertEquals( resp.getUserDetails().getUse(),equalTo("M66"));
	// Assert.	assertEquals( resp.getUserDetails().getRolePermissionMap(),hasSize(5));
	
//     assertThat("Role permission map should have 5 elements", resp.getUserDetails().getRolePermissionMap(), hasSize(5));

	
		
	}
	
	
	@Test
	public void binMap() {
		
		
		
		String caseBarcode="890B7245357B56225035211213SERACmokhiAMrG00128",
		 palletNo="5200061221S09302",
		locCode="5200";
		String binMapGenerateEndPoint="autobinmaping/v1/thirdparty/casestorageMapping";
		String binMapCompleteEndPoint="autobinmaping/thirdparty/casestorageMappingComplete";
		
		RequestSpecification reqSpec=new RequestSpecBuilder(). 
									addHeader("Content-Type", "application/json\r\n"
											+ "")
									.setBaseUri(baseURI)
									.addHeader("Authorization", "Bearer "+getToken())
									.log(LogDetail.ALL)				
									.build();
		
		ResponseSpecification resSpec=new ResponseSpecBuilder()
									.expectContentType(ContentType.JSON)
								
									.build();
		
		
		
		
	String response=	given().spec(reqSpec)
				.body("{\r\n"
						+ "    \"stackingNo\": \""+palletNo+"\",\r\n"
						+ "    \"caseBarcode\": \""+caseBarcode+"\",\r\n"
						+ "    \"locCode\": "+locCode+"\r\n"
						+ "}")
				.when()
				.post(binMapGenerateEndPoint)
				.then().spec(resSpec)
				.extract().asString();
		
		
		
	JsonPath js=new JsonPath(response);
	
	int status=js.get("status");
	String message=js.get("message");
	int scannedCases=js.get("payload.scannedCases");
	int stackingCapacity=js.get("payload.stackingCapacity");
	
	
	
	System.out.println(status);
	System.out.println(message);
	System.out.println(scannedCases);
	System.out.println(stackingCapacity);
	
	

	
	String response2=	given().spec(reqSpec)
			.body("{\r\n"
					+ "\"type\": \"CASE\",\r\n"
					+ "\"locCode\": \""+locCode+"\",\r\n"
					+ "\"stackingNo\": \""+palletNo+"\"\r\n"
					+ "}")
			.when()
			.post(binMapCompleteEndPoint)
			.then().spec(resSpec)
			.extract().asString();
	System.out.println(response2);
	
		
		
	}
	
	
	

}
