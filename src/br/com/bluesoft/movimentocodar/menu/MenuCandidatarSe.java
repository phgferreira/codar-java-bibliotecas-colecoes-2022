package br.com.bluesoft.movimentocodar.menu;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.bluesoft.movimentocodar.excecao.IdadeNaoPermitidaException;
import br.com.bluesoft.movimentocodar.io.FormularioPerguntas;
import br.com.bluesoft.movimentocodar.io.FormulariosCandidato;
import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;
import br.com.bluesoft.movimentocodar.modelo.Pergunta;
import br.com.bluesoft.movimentocodar.modelo.PerguntaComResposta;

public class MenuCandidatarSe extends Menu {
	
	private Map<String, PerguntaComResposta> perguntaComResposta = new HashMap<>();
	
	public MenuCandidatarSe(InterfaceUsuario interfaceUsuario) {
		super(interfaceUsuario);
	}

	@Override
	public String getTitulo() {
		return "Candidatar-se";
	}

	@Override
	public void abreMenu() {
		System.out.println(">>> " + this.getTitulo() + " <<<");
		try {
			List<Pergunta> perguntas = new FormularioPerguntas().getPerguntasEmLista();
			iniciaQuestionario(perguntas);
			new FormulariosCandidato().guardaNovoCandidato(perguntaComResposta);
		} catch ( RuntimeException | IOException | IdadeNaoPermitidaException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}
	
	
	private void iniciaQuestionario(List<Pergunta> perguntas) throws IOException, NumberFormatException, IdadeNaoPermitidaException {
		for (Pergunta pergunta : perguntas) {
			String resposta = interfaceUsuario.perguntaAoUsuario(pergunta.getPergunta());
			perguntaComResposta.put(pergunta.getId(), new PerguntaComResposta(pergunta, resposta));
		}
	}

}
