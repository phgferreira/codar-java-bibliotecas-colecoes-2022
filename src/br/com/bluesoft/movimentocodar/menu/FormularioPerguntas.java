package br.com.bluesoft.movimentocodar.menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import br.com.bluesoft.movimentocodar.modelo.PerguntaResposta;

public class FormularioPerguntas {

	public Map<String, PerguntaResposta> asMap() throws FileNotFoundException {
		Scanner scanner = new Scanner( new File("formulario.txt") );
		// Usa o '|' e a quebr de linha como delimitador
		scanner.useDelimiter( "\\||" + System.lineSeparator() );

		//List<PerguntaResposta> perguntaRespostas = new ArrayList<>();
		Map<String, PerguntaResposta> perguntas = new LinkedHashMap<>();
		while (scanner.hasNext())
			perguntas.put(scanner.next(), new PerguntaResposta(scanner.next()));
			//perguntaRespostas.add( new PerguntaResposta(scanner.next(), scanner.next()) );
		
		scanner.close();

		return perguntas;
	}

}
