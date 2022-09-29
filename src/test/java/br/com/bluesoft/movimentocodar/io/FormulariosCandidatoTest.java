package br.com.bluesoft.movimentocodar.io;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import br.com.bluesoft.movimentocodar.excecao.IdadeNaoPermitidaException;
import br.com.bluesoft.movimentocodar.modelo.Pergunta;
import br.com.bluesoft.movimentocodar.modelo.PerguntaComResposta;

class FormulariosCandidatoTest {

	private FormulariosCandidato formulario;
	
	@Test
	void test() {
		
		try {
			formulario.guardaNovoCandidato( montaPerguntasComRespostas() );
		} catch (IOException | NumberFormatException | IdadeNaoPermitidaException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	private Map<String, PerguntaComResposta> montaPerguntasComRespostas() throws NumberFormatException, IdadeNaoPermitidaException {
		Map<String, PerguntaComResposta> perguntasComRespostas = new HashMap<>();
		perguntasComRespostas.put("P1", new PerguntaComResposta( new Pergunta("Qual o seu nome?") , "Pedro de Oliveira"));
		perguntasComRespostas.put("P2", new PerguntaComResposta( new Pergunta("Qual sua profissão?") , "Auxiliar Administrativo"));
		perguntasComRespostas.put("P3", new PerguntaComResposta( new Pergunta("Qual a sua idade?") , "16"));
		perguntasComRespostas.put("P4", new PerguntaComResposta( new Pergunta("Qual o seu e-mail?") , "pedro.oliveira@gmail.com"));
		return perguntasComRespostas;
	}

}
