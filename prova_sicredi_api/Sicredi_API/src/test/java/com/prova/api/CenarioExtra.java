package com.prova.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CenarioExtra {
	
	String CEP;
	
	
	@Test
	public void VerificarRetorno() {

		RestAssured.baseURI = "https://viacep.com.br/ws/RS/Gravatai/Barroso/json/";

		Response response = null;

		try {
			response = RestAssured.given().when().get();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("-------------");

		System.out.println("Response : " + response.asString());
		
		System.out.println("\n" + "-------------");
		System.out.println("Status Code : " + response.getStatusCode());
		assertEquals(200, response.getStatusCode());
		System.out.println("API executada com sucesso");
			
		CEP = response.getBody().asString();

		JsonPath jsonPath = new JsonPath(CEP);
		String cep = jsonPath.getString("cep");
		
		System.out.println("CEP : " + cep);
		
		System.out.println("-------------");


	}

}
