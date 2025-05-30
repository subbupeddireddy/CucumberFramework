package pojo;

import java.util.List;

public class MasterResponse {
	
	private int status ;
	private String message ;
	private String timeStamp ;
	private List<Payload> payload ;
	
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public List<Payload> getPayload() {
		return payload;
	}
	

}
