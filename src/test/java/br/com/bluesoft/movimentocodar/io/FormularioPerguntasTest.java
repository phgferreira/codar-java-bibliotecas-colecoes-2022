 package br.com.bluesoft.movimentocodar.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.bluesoft.movimentocodar.modelo.Pergunta;

class FormularioPerguntasTest {
	
	private FormularioPerguntas formulario;
	
	@Mock
	private LeitorFormulario leitor;
	
	private Iterator<String> dadosArquivo;
	
	@BeforeEach
	void beforeEach() {
		MockitoAnnotations.openMocks(this);
		
		formulario = new FormularioPerguntas(leitor);

		dadosArquivo = Arrays.asList(
				"P1|Qual é o seu nome?",
				"P2|Qual é a sua idade?",
				"P3|Qual é o ano do seu nascimento?",
				"P4|Qual é a sua cidade?")
				.iterator();
	}
	
	@Test
	void deveRetornarUmaListaDePerguntas() {
		try {
			Mockito.when(leitor.temProximo())
				.thenReturn( true, true, true, true, false);
			Mockito.when(leitor.proximaLinha())
				.thenReturn( dadosArquivo.next(), dadosArquivo.next(),
							 dadosArquivo.next(), dadosArquivo.next() );

			List<Pergunta> perguntas = formulario.getListaDePerguntas();

			assertEquals(4, perguntas.size());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

	@Test
	void deveRetornarUmaMapaDePerguntas() {
		try {
			Mockito.when(leitor.temProximo())
				.thenReturn( true, true, true, true, false);
			Mockito.when(leitor.proximaLinha())
				.thenReturn( dadosArquivo.next(), dadosArquivo.next(),
							 dadosArquivo.next(), dadosArquivo.next() );

			Map<String, Pergunta> perguntas = formulario.getPerguntasEmMapa();

			assertEquals(4, perguntas.size());
			// Verifica se cada chave do mapa corresponde ao ID da pergunta (P1, P2, P3, ...)
			perguntas.keySet().forEach( chave -> assertEquals(chave, perguntas.get(chave).getId()) );
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}
