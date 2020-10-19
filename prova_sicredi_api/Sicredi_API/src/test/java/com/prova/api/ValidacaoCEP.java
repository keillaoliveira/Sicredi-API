package com.prova.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ValidacaoCEP {


	@Test
	public void ConsultaCEPValido() {

		RestAssured.baseURI = "https://viacep.com.br/ws";

		Response response = null;

		try {
			response = RestAssured.given().when().get("/91060900/json/ ");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("-------------");

		System.out.println("Response : " + response.asString());
		System.out.println("Status Code : " + response.getStatusCode());
		System.out.println("Contains 'CEP'? :" + response.asString().contains("91060-900"));

		assertEquals(200, response.getStatusCode());
		System.out.println("CEP Localizado!");
		System.out.println("-------------");
		System.out.println("|" + "\n" + "|" + "\n" + "|");

	}

	@Test
	public void ConsultaCEPInexistente() {

		RestAssured.baseURI = "https://viacep.com.br/ws";

		Response response = null;

		try {
			response = RestAssured.given().when().get("/91060910/json/ ");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("-------------");

		System.out.println("Response : " + response.asString());
		System.out.println("Status Code : " + response.getStatusCode());
		System.out.println("Contains 'erro'? :" + response.asString().contains("true"));
		assertEquals(200, response.getStatusCode());
		System.out.println("CEP n�o localizado!");

		System.out.println("-------------");

		System.out.println("|" + "\n" + "|" + "\n" + "|");

	}
	
	@Test
	public void ConsultaCEPFormatoInvalido() {

		RestAssured.baseURI = "https://viacep.com.br/ws";

		Response response = null;

		try {
			response = RestAssured.given().when().get("/910609100/json/ ");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("-------------");

		System.out.println("Status Code : " + response.getStatusCode());
		System.out.println("Contains 'Bad Request'? :" + response.asString().contains("Bad Request"));
		assertEquals(400, response.getStatusCode());
		System.out.println("CEP com formato inv�lido! --- Bad Request");

		System.out.println("-------------");


	}

}
