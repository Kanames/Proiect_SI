package Teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.log4j.BasicConfigurator;
import org.junit.jupiter.api.AfterEach;

import generalHelper.CommonHelper;

class Test {

	@AfterEach
	void tearDown() throws Exception {
	}

	@org.junit.jupiter.api.Test
	void test() {
		BasicConfigurator.configure();
		String initial = "am mers la curs";
		String criptat = CommonHelper.criptareParola(initial);
		String decrpitat = CommonHelper.decriptareParola(criptat);
		org.junit.jupiter.api.Assertions.assertEquals(initial,decrpitat);
	}

}
