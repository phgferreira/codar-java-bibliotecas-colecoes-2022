package br.com.bluesoft.movimentocodar.menu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import br.com.bluesoft.movimentocodar.excecao.IdadeNaoPermitidaException;
import br.com.bluesoft.movimentocodar.io.FormularioPerguntas;
import br.com.bluesoft.movimentocodar.io.VerificadorDoUltimoNumeroDeFormulario;
import br.com.bluesoft.movimentocodar.modelo.PerguntaResposta;
import br.com.bluesoft.movimentocodar.util.FormatadorDeNomeParaArquivo;

public class MenuCandidatarSe implements Menu {
	
	//private List<PerguntaResposta> perguntaRespostas;
	private List<PerguntaResposta> perguntasERespostas;
	private static final String CAMINHO_PASTA_CANDIDATOS = "C:\\candidatos\\";
	private static final String EXTENSAO_PADRAO = "txt";

	@Override
	public String getTitulo() {
		return "Candidatar-se";
	}

	@Override
	public void abreMenu() {
		System.out.println(">>> " + this.getTitulo() + " <<<");
		try {
			perguntasERespostas = FormularioPerguntas.getSomentePerguntasEmLista();
			iniciaQuestionario();
//			guardaCandidato();
		} catch (IOException | NumberFormatException | IdadeNaoPermitidaException e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	private void iniciaQuestionario() throws IOException, NumberFormatException, IdadeNaoPermitidaException {
		Scanner scanner = new Scanner(System.in);
		
		/* Até pensei em usar o lambda mas o IOException do scanner.next precisa ser tratado
		 * dentro no lambda e eu quero que seja tratado fora
		 */
		for (PerguntaResposta perguntaEResposta : perguntasERespostas) {
			System.out.println(perguntaEResposta.getPergunta());
			perguntaEResposta.setResposta(scanner.next());
		}
	}
	
	private void guardaCandidato() throws IOException {

		String URL = CAMINHO_PASTA_CANDIDATOS
				+ VerificadorDoUltimoNumeroDeFormulario.verifica(CAMINHO_PASTA_CANDIDATOS) + "-" + FormatadorDeNomeParaArquivo.formata(perguntasERespostas.get(0).getResposta())
				+ "." + EXTENSAO_PADRAO;

		BufferedWriter writer = new BufferedWriter(new FileWriter(URL));
		for (PerguntaResposta perguntaEResposta : perguntasERespostas) {
			writer.write(perguntaEResposta.getIdPergunta() + "|" 
					+ perguntaEResposta.getPergunta() + "|"
					+ perguntaEResposta.getResposta());
			writer.newLine();
		}
		writer.close();
		
		System.out.println("--- Candidato " + perguntaRespostas.get(0).getResposta() + " salvo com Sucesso ---");
	}

}
