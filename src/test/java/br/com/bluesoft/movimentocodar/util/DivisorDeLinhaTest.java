package br.com.bluesoft.movimentocodar.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DivisorDeLinhaTest {
	
	private DivisorDeLinha dividorDeLinha;
	
	@BeforeEach
	void beforeEach() {
		dividorDeLinha = new DivisorDeLinha();
	}

	@Test
	void deveRetornarUmaStringDivididaPeloDelimitadorPadrao() {
		String texto = "teste01|\nteste|[]1264//";
		String valoresDivididos[] = dividorDeLinha.getValoresDividios(texto);
		
		if (valoresDivididos.length == 0)
			throw new IllegalStateException("A lisat de valores está vazia");
		
		assertEquals("teste01", valoresDivididos[0]);
		assertEquals("\nteste", valoresDivididos[1]);
		assertEquals("[]1264//", valoresDivididos[2]);
	}
	
	void deveUnirValoresDeArrayDeStringsUsandoODelimitadorPadao() {
		String texto[] = {"testando...", "çlnazçl:.;,", "()||_$%#¨&"};
		String valoresUnidos = dividorDeLinha.getValoresUnidos(texto);
		
		assertEquals("testando...|çlnazçl:.;,|()||_$%#¨&", valoresUnidos);
	}

}
