package br.com.bluesoft.movimentocodar.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.bluesoft.movimentocodar.modelo.PerguntaResposta;

public class FormularioPerguntas {

	public static List<PerguntaResposta> getSomentePerguntasEmLista() throws FileNotFoundException {
		Scanner scanner = new Scanner( new File("formulario.txt") );
		// Usa o '|' e a quebra de linha como delimitador
		scanner.useDelimiter( "\\||" + System.lineSeparator() );

		List<PerguntaResposta> perguntas = new ArrayList<>();
		while (scanner.hasNext())
			perguntas.add( new PerguntaResposta(scanner.next(), scanner.next()) );
		
		scanner.close();

		return perguntas;
	}

}
