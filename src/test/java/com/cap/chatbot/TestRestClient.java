package com.cap.chatbot;

import java.util.ArrayList;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

import com.cap.service.BasicAuthRestTemplate;

public class TestRestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UUID idOne = UUID.randomUUID();
		System.out.println("idOne ::"+idOne);
		
		BasicAuthRestTemplate restTemplate = new BasicAuthRestTemplate("summituser", "abcd");
		ResponseEntity<String> jsonresult = restTemplate.getForEntity("http://54.195.246.137/bin/trainingServlet?query=cards", String.class);
		
		//System.out.println("RESULT::"+jsonresult.toString());
		
		JSONObject jsonObject = new JSONObject(jsonresult);
		
		System.out.println("JSONOBJECT IN STRING::"+jsonObject.toString());
		
		String bodyObj = (String)jsonObject.get("body");
		
		JSONObject bObject = new JSONObject(bodyObj);
		
		JSONArray jArray = (JSONArray)bObject.get("creditcards");
				
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<jArray.length();i++) {
			String s = (String)jArray.getJSONObject(i).get("product_name");
			sb.append(s).append(",");
		}
		
		System.out.println(""+sb);
		
		/*
		String jsonString  = "{" + 
	            "   \"MyResponse\": {" + 
	            "       \"count\": 3," + 
	            "       \"listTsm\": [{" + 
	            "           \"id\": \"b90c6218-73c8-30bd-b532-5ccf435da766\"," + 
	            "           \"simpleid\": 1," + 
	            "           \"name\": \"vignesh1\"" + 
	            "       }," + 
	            "       {" + 
	            "           \"id\": \"b90c6218-73c8-30bd-b532-5ccf435da766\"," + 
	            "           \"simpleid\": 2," + 
	            "           \"name\": \"vignesh2\"" + 
	            "       }," + 
	            "       {" + 
	            "           \"id\": \"b90c6218-73c8-30bd-b532-5ccf435da766\"," + 
	            "           \"simpleid\": 3," + 
	            "           \"name\": \"vignesh3\"" + 
	            "       }]" + 
	            "   }" + 
	            "}";


	    JSONObject jsonObject = new JSONObject(jsonString);
	    System.out.println(""+jsonObject.toString());
	    JSONObject myResponse = jsonObject.getJSONObject("MyResponse");
	    JSONArray tsmresponse = (JSONArray) myResponse.get("listTsm");

	    ArrayList<String> list = new ArrayList<String>();

	    for(int i=0; i<tsmresponse.length(); i++){
	        list.add(tsmresponse.getJSONObject(i).getString("name"));
	    }

	    System.out.println(list);
*/	}   
		
	

}
