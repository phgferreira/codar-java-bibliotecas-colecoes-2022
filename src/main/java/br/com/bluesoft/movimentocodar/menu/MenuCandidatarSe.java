package br.com.bluesoft.movimentocodar.menu;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import br.com.bluesoft.movimentocodar.excecao.IdadeNaoPermitidaException;
import br.com.bluesoft.movimentocodar.io.FormularioPerguntas;
import br.com.bluesoft.movimentocodar.io.FormulariosCandidato;
import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;
import br.com.bluesoft.movimentocodar.io.LeitorFormularioPerguntas;
import br.com.bluesoft.movimentocodar.modelo.Pergunta;
import br.com.bluesoft.movimentocodar.modelo.PerguntaComResposta;
import br.com.bluesoft.movimentocodar.util.Questionario;

public class MenuCandidatarSe extends Menu {
	
	
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
			List<Pergunta> perguntas = new FormularioPerguntas( new LeitorFormularioPerguntas() ).getListaDePerguntas();
			Map<String, PerguntaComResposta> perguntaComResposta = new Questionario().getRespostas(perguntas, interfaceUsuario);
			
			FormulariosCandidato formulario = new FormulariosCandidato();
			formulario.guardaNovoCandidato(perguntaComResposta);
		} catch ( RuntimeException | IOException | IdadeNaoPermitidaException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}
	

}
