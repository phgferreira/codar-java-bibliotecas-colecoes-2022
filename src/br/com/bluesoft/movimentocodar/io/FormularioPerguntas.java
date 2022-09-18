package br.com.bluesoft.movimentocodar.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.bluesoft.movimentocodar.modelo.PerguntaResposta;

public class FormularioPerguntas {

	public List<PerguntaResposta> getSomentePerguntasEmLista() throws FileNotFoundException {
		Scanner scanner = new Scanner( new File("formulario.txt") );
		// Usa o '|' e a quebra de linha como delimitador
		scanner.useDelimiter( "\\||" + System.lineSeparator() );

		List<PerguntaResposta> perguntas = new ArrayList<>();
		while (scanner.hasNext())
			perguntas.add( new PerguntaResposta(scanner.next(), scanner.next()) );
		
		//scanner.close();

		return perguntas;
	}
	
	public Map<String, PerguntaResposta> getSomentePerguntasEmMapa() throws FileNotFoundException {
		Scanner scanner = new Scanner( new File("formulario.txt") );
		// Usa o '|' e a quebra de linha como delimitador
		scanner.useDelimiter( "\\||" + System.lineSeparator() );

		Map<String, PerguntaResposta> perguntas = new HashMap<>();
		while (scanner.hasNext()) {
			String idPergunta = scanner.next();
			String resposta = scanner.next();
			/*
			 *  O idPergunta é inserido no mapa para facilitar trabalharmos com localização
			 *  de perguntas específicas dentro da coleção e também é inserido na classe PerguntaResposta
			 *  porque poderemos tratar respostas de perguntas específicas, como a idade, por exemplo.
			 */
			perguntas.put(idPergunta, new PerguntaResposta(idPergunta, resposta));
		}
		
		//scanner.close();

		return perguntas;
	}
	

}
