package br.com.bluesoft.movimentocodar.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.bluesoft.movimentocodar.modelo.Pergunta;

public class FormularioPerguntas {
	
	private static final String URL_FORMULARIO = "formulario.txt";
	private File arquivo;
	private Scanner scanner;
	
	public FormularioPerguntas() throws FileNotFoundException {
		arquivo = new File(URL_FORMULARIO);
		scanner = new Scanner( arquivo );
		// Usa o '|' e a quebra de linha como delimitador
		scanner.useDelimiter( "\\||" + System.lineSeparator() );
	}

	public List<Pergunta> getPerguntasEmLista() {
		List<Pergunta> perguntas = new ArrayList<>();
		while (scanner.hasNext())
			perguntas.add( new Pergunta(scanner.next(), scanner.next()) );
		
		return perguntas;
	}
	
	public Map<String, Pergunta> getPerguntasEmMapa() throws FileNotFoundException {
		Map<String, Pergunta> perguntas = new HashMap<>();
		while (scanner.hasNext()) {
			String idPergunta = scanner.next();
			String resposta = scanner.next();
			/*
			 *  O idPergunta é inserido no mapa para facilitar trabalharmos com localização
			 *  de perguntas específicas dentro da coleção e também é inserido na classe PerguntaResposta
			 *  porque poderemos tratar respostas de perguntas específicas, como a idade, por exemplo.
			 */
			perguntas.put(idPergunta, new Pergunta(idPergunta, resposta));
		}
		
		return perguntas;
	}

	public void atualizaPerguntas(List<Pergunta> perguntas) throws IOException {
		BufferedWriter writer = new BufferedWriter( new FileWriter(arquivo) );
		for (Pergunta pergunta : perguntas) {
			writer.write(pergunta.getId() + "|" + pergunta.getPergunta() + System.lineSeparator());
		}
		writer.close();
	}
	
	public void close() throws IOException {
		scanner.close();
	}
}
