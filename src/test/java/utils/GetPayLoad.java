package utils;

public class GetPayLoad {

	public static String getSTOAPI(String myOrder) {

		return "[ {\r\n" + "  \"delvOrdNo\" : \"" + myOrder + "\",\r\n" + "  \"supLocCode\" : \"5300\",\r\n"
				+ "  \"recLocCode\" : \"5415\",\r\n" + "  \"delvDate\" : \"2025-05-22\",\r\n"
				+ "  \"itemInfo\" : [ {\r\n" + "    \"itemNo\" : \"000001\",\r\n"
				+ "    \"prodCode\" : \"7624112\",\r\n" + "    \"planQty\" : 10\r\n" + "  } ]\r\n" + "} ]";
	}

}
