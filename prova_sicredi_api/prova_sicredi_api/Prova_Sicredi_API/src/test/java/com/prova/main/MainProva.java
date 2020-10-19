package com.prova.main;

import org.junit.Test;

import com.prova.api.CenarioExtra;
import com.prova.api.ValidacaoCEP;

public class MainProva {
	
	static ValidacaoCEP validacaoCEP = new ValidacaoCEP();
	static CenarioExtra cenarioExtra = new CenarioExtra();
	
	@Test
	public void executeProva(){
		
		System.out.println("------ Cenario 01 -------");
		
		validacaoCEP.ConsultaCEPValido();
		validacaoCEP.ConsultaCEPInexistente();
		validacaoCEP.ConsultaCEPFormatoInvalido();
		
		System.out.println("------ Fim Cenario 01 -------");
		
		System.out.println("\n"+"------ Cenario 02 Extra -------");
		
		cenarioExtra.VerificarRetorno();
		
		System.out.println("\n"+"------ Fim Cenario 02 Extra -------");
	}

}
