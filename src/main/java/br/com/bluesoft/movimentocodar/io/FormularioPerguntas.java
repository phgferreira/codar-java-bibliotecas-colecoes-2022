package br.com.bluesoft.movimentocodar.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.bluesoft.movimentocodar.modelo.Pergunta;
import br.com.bluesoft.movimentocodar.util.DivisorDeLinha;

public class FormularioPerguntas {
	
	private static final String URL_FORMULARIO = "formulario.txt";
	private File arquivo;
	
	public FormularioPerguntas() throws FileNotFoundException {
		arquivo = new File(URL_FORMULARIO);
	}

	public List<Pergunta> getPerguntasEmLista() throws IOException {
		List<Pergunta> perguntas = new ArrayList<>();
		BufferedReader reader = new BufferedReader( new FileReader(arquivo) );

		for (String linha = reader.readLine(); linha != null; linha = reader.readLine()) {
			String valores[] = new DivisorDeLinha().getValoresDividios(linha);
			// valores[0] = idPergunta; valores[1] = descriçãoPergunta
			perguntas.add( new Pergunta(valores[0], valores[1]) );
		}
		
		reader.close();
		return perguntas;
	}
	
	public Map<String, Pergunta> getPerguntasEmMapa() throws IOException {
		Map<String, Pergunta> perguntas = new HashMap<>();
		BufferedReader reader = new BufferedReader( new FileReader(arquivo) );

		for (String linha = reader.readLine(); linha != null; linha = reader.readLine()) {
			String valores[] = new DivisorDeLinha().getValoresDividios(linha);
			// valores[0] = idPergunta; valores[1] = descriçãoPergunta
			perguntas.put(valores[0], new Pergunta(valores[0], valores[1]) );
		}
		
		reader.close();
		return perguntas;
	}

	public void atualizaPerguntas(List<Pergunta> perguntas) throws IOException {
		BufferedWriter writer = new BufferedWriter( new FileWriter(arquivo) );
		for (Pergunta pergunta : perguntas) {
			writer.write( new DivisorDeLinha().getValoresUnidos(pergunta.getId(), pergunta.getPergunta()) + System.lineSeparator() );
		}
		writer.close();
	}
	
}
