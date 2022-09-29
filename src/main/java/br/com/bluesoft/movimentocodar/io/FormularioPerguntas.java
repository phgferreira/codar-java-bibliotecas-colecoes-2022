package br.com.bluesoft.movimentocodar.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.bluesoft.movimentocodar.modelo.Pergunta;
import br.com.bluesoft.movimentocodar.util.DivisorDeLinha;

public class FormularioPerguntas {
	
	private LeitorFormularioPerguntas leitor;
	
	public FormularioPerguntas(LeitorFormularioPerguntas arquivo) {
		this.leitor = arquivo;
	}

	public List<Pergunta> getListaDePerguntas() throws IOException {
		List<Pergunta> perguntas = new ArrayList<>();

		while (leitor.temProximo()) {
			String valores[] = new DivisorDeLinha().getValoresDividios(leitor.proximaLinha());
			perguntas.add( new Pergunta(valores[0], valores[1]) );
		}
		
		leitor.close();
		return Collections.unmodifiableList(perguntas);
	}
	
	public Map<String, Pergunta> getPerguntasEmMapa() throws IOException {
		Map<String, Pergunta> perguntas = new HashMap<>();

		while (leitor.temProximo()) {
			String valores[] = new DivisorDeLinha().getValoresDividios(leitor.proximaLinha());
			perguntas.put(valores[0], new Pergunta(valores[0], valores[1]) );
		}
		
		leitor.close();
		return Collections.unmodifiableMap(perguntas);
	}

//	public void atualizaPerguntas(List<Pergunta> perguntas) throws IOException {
//		BufferedWriter writer = new BufferedWriter( new FileWriter( new File(urlFormulario) ) );
//		for (Pergunta pergunta : perguntas) {
//			writer.write( new DivisorDeLinha().getValoresUnidos(pergunta.getId(), pergunta.getPergunta()) + System.lineSeparator() );
//		}
//		writer.close();
//	}
	
}
