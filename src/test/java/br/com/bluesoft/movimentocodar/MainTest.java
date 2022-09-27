package br.com.bluesoft.movimentocodar;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;

class MainTest {
	
	/**
	 * Esse teste pode ser desnecessário mas preferi pecar pelo excesso
	 * do que pela falta
	 */
	@Test
	void deveInstanciarUmaInterfaceComOUsuario() {
		try {
			new InterfaceUsuario();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
		// Se não deu qualquer erro no código acima, então o teste passou
		assertTrue(true);
	}

}
