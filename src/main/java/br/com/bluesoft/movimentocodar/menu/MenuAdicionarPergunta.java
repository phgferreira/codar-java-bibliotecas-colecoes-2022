package br.com.bluesoft.movimentocodar.menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import br.com.bluesoft.movimentocodar.io.FormularioPerguntas;
import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;
import br.com.bluesoft.movimentocodar.modelo.Pergunta;

public class MenuAdicionarPergunta extends Menu {
	
	private FormularioPerguntas formularioPerguntas;

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
			formularioPerguntas = new FormularioPerguntas();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
//			String novaPergunta = interfaceUsuario.perguntaAoUsuario("Qual pergunta gostaria de adicionar ao formulário?");
//			
//			List<Pergunta> perguntas = formularioPerguntas.getPerguntasEmLista();
//			
//			if (perguntas.contains(new Pergunta(novaPergunta)))
//				throw new PerguntaRepetidaException("A pergunta '" + novaPergunta + "' já foi cadastrada");
//			else
//				guardaNovaPergunta(novaPergunta, perguntas);
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (PerguntaRepetidaException e) {
//			System.err.println(e.getMessage());
//		}
	}

	private void guardaNovaPergunta(String novaPergunta, List<Pergunta> perguntas) throws IOException {
		String novoId = verificaProximoIdPergunta(perguntas);
		perguntas.add(new Pergunta(novoId, novaPergunta));
		formularioPerguntas.atualizaPerguntas(perguntas);
	}
	
	private String verificaProximoIdPergunta(List<Pergunta> perguntas) {
		int maiorId = 0;
		for (Pergunta pergunta : perguntas) {
			int atualId = Integer.parseInt(pergunta.getId().substring(1));
			if (atualId >= maiorId)
				maiorId = atualId;
		}
		
		return "P"+(maiorId+1);
	}

}
