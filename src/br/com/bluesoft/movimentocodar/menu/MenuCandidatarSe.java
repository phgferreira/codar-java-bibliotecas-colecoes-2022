package br.com.bluesoft.movimentocodar.menu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import br.com.bluesoft.movimentocodar.excecao.IdadeNaoPermitidaException;
import br.com.bluesoft.movimentocodar.modelo.PerguntaResposta;

public class MenuCandidatarSe implements Menu {
	
	private List<PerguntaResposta> perguntaRespostas;
	private static final String CAMINHO_PASTA_CANDIDATOS = "C:\\candidatos\\";
	private static final String EXTENSAO_PADRAO = "txt";
	private static int CONTADOR;

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
			guardaCandidato();
		} catch (IOException | IdadeNaoPermitidaException e) {
			System.err.println(e.getMessage());
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
		
		scanner.close();
	}
	
	private void iniciaQuestionario() throws IOException, IdadeNaoPermitidaException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for (PerguntaResposta perguntaResposta : perguntaRespostas) {
			System.out.println(perguntaResposta.getPergunta());
			perguntaResposta.setResposta(reader.readLine());
		}
		
		verificaIdadeDoCandidato();
	}
	
	private void verificaIdadeDoCandidato() throws IdadeNaoPermitidaException {
		if (Integer.parseInt(perguntaRespostas.get(2).getResposta()) < 16)
			throw new IdadeNaoPermitidaException("Desculpa, você é muito jovem e a idade permita é de no mínimo 16 anos");
	}
	
	private void guardaCandidato() throws IOException {
		String URL = CAMINHO_PASTA_CANDIDATOS
				+ CONTADOR + "-" + formataNomeParaArquivo(perguntaRespostas.get(0).getResposta())
				+ "." + EXTENSAO_PADRAO;

		BufferedWriter writer = new BufferedWriter(new FileWriter(URL));
		for (PerguntaResposta perguntaResposta : perguntaRespostas) {
			writer.write(perguntaResposta.getId() + "|" 
					+ perguntaResposta.getPergunta() + "|"
					+ perguntaResposta.getResposta());
			writer.newLine();
		}
		writer.close();
		
		System.out.println("--- Candidato " + perguntaRespostas.get(0).getResposta() + " salvo com Sucesso ---");

		CONTADOR++;
	}
	
	private String formataNomeParaArquivo(String nome) {
        String nfdNormalizedString = Normalizer.normalize(nome, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("").toUpperCase();
	}

}
