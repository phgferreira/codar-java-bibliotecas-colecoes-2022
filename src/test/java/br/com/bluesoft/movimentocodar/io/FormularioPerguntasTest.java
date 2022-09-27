package br.com.bluesoft.movimentocodar.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import br.com.bluesoft.movimentocodar.modelo.Pergunta;

class FormularioPerguntasTest {

	/**
	 * Este teste depende que o arquivo formulario.txt esteja na raiz do projeto
	 * e que suas primeiras perguntas estejam exatamente assim:
	 * P1|Qual o seu nome completo?
	 * P2|Qual seu e-mail?
	 * P3|Qual sua idade?
	 * P4|Qual seu whatsapp ou celular?
	 */
	@Test
	void devePegarAsPerguntasDoFormularioEmLista() {
		try {
			FormularioPerguntas formularioPerguntas = new FormularioPerguntas();
			
			List<Pergunta> perguntas = formularioPerguntas.getPerguntasEmLista();
			
			if (perguntas.isEmpty())
				throw new IllegalStateException("Lista de perguntas está vazia");
			
			assertEquals("P1", perguntas.get(0).getId());
			assertEquals("Qual o seu nome completo?", perguntas.get(0).getPergunta());

			assertEquals("P2", perguntas.get(1).getId());
			assertEquals("Qual seu e-mail?", perguntas.get(1).getPergunta());
			
			assertEquals("P3", perguntas.get(2).getId());
			assertEquals("Qual sua idade?", perguntas.get(2).getPergunta());
			
			assertEquals("P4", perguntas.get(3).getId());
			assertEquals("Qual seu whatsapp ou celular?", perguntas.get(3).getPergunta());
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}

	void devePegarAsPerguntasDoFormularioEmMapa() {
		try {
			FormularioPerguntas formularioPerguntas = new FormularioPerguntas();
			
			Map<String, Pergunta> perguntas = formularioPerguntas.getPerguntasEmMapa();
			
			if (perguntas.isEmpty())
				throw new IllegalStateException("Lista de perguntas está vazia");
			
			assertEquals("Qual o seu nome completo?", perguntas.get("P1").getPergunta());
			assertEquals("Qual seu e-mail?", perguntas.get("P2").getPergunta());
			assertEquals("Qual sua idade?", perguntas.get("P3").getPergunta());
			assertEquals("Qual seu whatsapp ou celular?", perguntas.get("P4").getPergunta());
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}	
}
