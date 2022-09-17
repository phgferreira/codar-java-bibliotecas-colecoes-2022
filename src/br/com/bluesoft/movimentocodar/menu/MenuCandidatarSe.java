package br.com.bluesoft.movimentocodar.menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.bluesoft.movimentocodar.modelo.PerguntaResposta;

public class MenuCandidatarSe implements Menu {

	private List<PerguntaResposta> perguntasERespostas;
	
	@Override
	public String getTitulo() {
		return "Candidatar-se";
	}

	@Override
	public void abreMenu() {
		System.out.println(">>> " + this.getTitulo() + " <<<");
		exibePerguntas();
	}
	
	private void exibePerguntas() {
		try {

			Scanner scanner = new Scanner( new File("formulario.txt") );
			// Usa o '|' e a quebr de linha como delimitador
			scanner.useDelimiter( "\\||" + System.lineSeparator() );

			perguntasERespostas = new ArrayList<>();
			while (scanner.hasNext()) {
				perguntasERespostas.add( new PerguntaResposta(scanner.next(), scanner.next()) );
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		perguntasERespostas.forEach(System.out::println);
	}

}
