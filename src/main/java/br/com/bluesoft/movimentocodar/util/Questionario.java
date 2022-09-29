package br.com.bluesoft.movimentocodar.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.bluesoft.movimentocodar.excecao.IdadeNaoPermitidaException;
import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;
import br.com.bluesoft.movimentocodar.modelo.Pergunta;
import br.com.bluesoft.movimentocodar.modelo.PerguntaComResposta;

public class Questionario {

	public Map<String, PerguntaComResposta> getRespostas(List<Pergunta> perguntas, InterfaceUsuario interfaceUsuario) throws IOException, NumberFormatException, IdadeNaoPermitidaException {
		Map<String, PerguntaComResposta> perguntaComResposta = new HashMap<>();
		for (Pergunta pergunta : perguntas) {
			String resposta = interfaceUsuario.perguntaAoUsuario(pergunta.getPergunta());
			perguntaComResposta.put(pergunta.getId(), new PerguntaComResposta(pergunta, resposta));
		}
		return perguntaComResposta;
	}

}
