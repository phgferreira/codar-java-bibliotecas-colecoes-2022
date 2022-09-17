package br.com.bluesoft.movimentocodar.menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.bluesoft.movimentocodar.modelo.PerguntaResposta;

public class FormularioPerguntas {

	public List<PerguntaResposta> carregaPerguntasEmLista() throws FileNotFoundException {
		Scanner scanner = new Scanner( new File("formulario.txt") );
		// Usa o '|' e a quebr de linha como delimitador
		scanner.useDelimiter( "\\||" + System.lineSeparator() );

		List<PerguntaResposta> perguntaRespostas = new ArrayList<>();
		while (scanner.hasNext()) {
			perguntaRespostas.add( new PerguntaResposta(scanner.next(), scanner.next()) );
		}
		
		scanner.close();

		return perguntaRespostas;
	}

}
