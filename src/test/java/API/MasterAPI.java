package API;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import io.restassured.RestAssured;
import pojo.MasterResponse;
import pojo.Payload;

public class MasterAPI {

	String baseURI = "http://10.10.10.53:30123/";
	String masterAPIEndPoint = "masterservice/get/products";

	@Test
	public void getEntireProducts() {

		RestAssured.baseURI = baseURI;
		MasterResponse masterResponse = given().log().all().when().get(masterAPIEndPoint).then().log().all().extract().
				response().as(MasterResponse.class);
	System.out.println(	masterResponse.getStatus());
	System.out.println(	masterResponse.getMessage());
System.out.println(	masterResponse.getPayload().get(2).getProdName());
System.out.println(	masterResponse.getPayload().get(2).getProdCode());


List<Payload> av= masterResponse.getPayload();


for(Payload a :av) {
	
	if(a.getPackType().equals("Drums")) {

	
	System.out.println("prod_code-->" +a.getProdCode()+" prod_name-->"+ a.getProdName());
	
}

	}

}
	
}
