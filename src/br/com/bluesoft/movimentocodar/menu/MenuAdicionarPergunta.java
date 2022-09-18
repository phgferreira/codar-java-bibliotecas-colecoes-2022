package br.com.bluesoft.movimentocodar.menu;

import java.io.IOException;
import java.util.List;

import br.com.bluesoft.movimentocodar.excecao.PerguntaRepetidaException;
import br.com.bluesoft.movimentocodar.io.FormularioPerguntas;
import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;
import br.com.bluesoft.movimentocodar.modelo.Pergunta;

public class MenuAdicionarPergunta extends Menu {

	public MenuAdicionarPergunta(InterfaceUsuario interfaceUsuario) {
		super(interfaceUsuario);
	}

	@Override
	public String getTitulo() {
		return "Adicionar pergunta ao formulário";
	}

	@Override
	public void abreMenu() {
		System.out.println(">>> " + this.getTitulo() + " <<<");
		
		
		try {
			String novaPergunta = interfaceUsuario.perguntaAoUsuario("Qual pergunta gostaria de adicionar ao formulário?");
			
			List<Pergunta> perguntas = new FormularioPerguntas().getPerguntasEmLista();
			
			if (perguntas.contains(new Pergunta(novaPergunta)))
				throw new PerguntaRepetidaException("A pergunta " + novaPergunta + " já foi cadastrada");
			
			System.out.println("Vamos cadastrar a pergunta: " + novaPergunta);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PerguntaRepetidaException e) {
			System.err.println(e.getMessage());
		}
	}

}
