package br.com.bluesoft.movimentocodar.menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import br.com.bluesoft.movimentocodar.io.FormularioPerguntas;
import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;
import br.com.bluesoft.movimentocodar.modelo.Pergunta;

public class MenuRemoverFormulario extends Menu {

	private FormularioPerguntas formularioPerguntas;
	
	public MenuRemoverFormulario(InterfaceUsuario interfaceUsuario, FormularioPerguntas formularioPerguntas) {
		super(interfaceUsuario);
		this.formularioPerguntas = formularioPerguntas;
	}

	@Override
	public String getTitulo() {
		return "Remover pergunta do formulário";
	}

	@Override
	public void abreMenu() {
		System.out.println(">>> " + this.getTitulo() + " <<<");
		
		try {
			Map<String, Pergunta> perguntas = formularioPerguntas.getPerguntasEmMapa();
			perguntas.forEach( (idPergunta, pergunta) -> System.out.println("ID: " + idPergunta + " => " + pergunta.getPergunta()) );
			
			String idPerguntaParaRemover = interfaceUsuario.perguntaAoUsuario("Qual pergunta gostaria de remover? (use o ID)");
			perguntas.remove(idPerguntaParaRemover);
		
			formularioPerguntas.atualizaPerguntas( new ArrayList<Pergunta>(perguntas.values()) );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
