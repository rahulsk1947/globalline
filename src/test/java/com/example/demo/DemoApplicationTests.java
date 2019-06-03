package com.example.demo;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.boot.test.web.client.TestRestTemplate;
import demo.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DemoApplicationTests {

	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	@Test
	public void contextLoads() throws JSONException {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Content-Type", "application/json");

		JSONObject json = new JSONObject();
		json.put("email", "eve.holt@reqres.in");

		String url = "https://reqres.in/api/login";
		HttpEntity<String> httpEntity = new HttpEntity<String>(json.toString(), httpHeaders);

		TestRestTemplate restTemplate = new TestRestTemplate();
		String response = restTemplate.postForObject(url, httpEntity, String.class);

		System.out.println("response:" + response);

		String expected = "{\"token\":\"QpwL5tke4Pnpja7X4\"}";
		//JSONAssert.assertEquals(expected, response, false);
	}

}
