package br.com.bluesoft.movimentocodar.menu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.bluesoft.movimentocodar.modelo.PerguntaResposta;

/*
 * pr = PerguntaResposta
 */
public class MenuCandidatarSe implements Menu {
	
	private List<PerguntaResposta> perguntaRespostas;

	@Override
	public String getTitulo() {
		return "Candidatar-se";
	}

	@Override
	public void abreMenu() {
		System.out.println(">>> " + this.getTitulo() + " <<<");
		try {
			carregaPerguntas();
			iniciaQuestionario();
			perguntaRespostas.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void carregaPerguntas() throws FileNotFoundException {
		Scanner scanner = new Scanner( new File("formulario.txt") );
		// Usa o '|' e a quebr de linha como delimitador
		scanner.useDelimiter( "\\||" + System.lineSeparator() );

		perguntaRespostas = new ArrayList<>();
		while (scanner.hasNext()) {
			perguntaRespostas.add( new PerguntaResposta(scanner.next(), scanner.next()) );
		}
	}
	
	private void iniciaQuestionario() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for (PerguntaResposta perguntaResposta : perguntaRespostas) {
			System.out.println(perguntaResposta.getPergunta());
			perguntaResposta.setResposta(reader.readLine());
		}
	}

}
