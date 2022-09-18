package br.com.bluesoft.movimentocodar.menu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.com.bluesoft.movimentocodar.io.FormularioPerguntas;
import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;
import br.com.bluesoft.movimentocodar.modelo.PerguntaResposta;

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
			String pergunta = new InterfaceUsuario().perguntaAoUsuario("Qual pergunta gostaria de adicionar no formulário?");

			List<PerguntaResposta> teste = new FormularioPerguntas().getSomentePerguntasEmLista();
			BufferedWriter writer = new BufferedWriter(new FileWriter("formulario.txt"));
			//
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
