package br.com.bluesoft.movimentocodar.io;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.bluesoft.movimentocodar.modelo.Pergunta;

class FormularioPerguntasTest {

	@Test
	void devePegarAsPerguntasDoFormularioEmLista() {
		try {
			FormularioPerguntas formularioPerguntas = new FormularioPerguntas();
			List<Pergunta> perguntas = formularioPerguntas.getPerguntasEmLista();
			assertFalse(perguntas.isEmpty());
		} catch (IOException e) {
			fail();
		}
		
	}

}
