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
import br.com.bluesoft.movimentocodar.modelo.PerguntaResposta;

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
			perguntasERespostas = new FormularioPerguntas().getSomentePerguntasEmLista();
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
				+ verificaUltimoNumeroDeFormularios() + "-" + formataNomeParaArquivo(perguntasERespostas.get(0).getResposta())
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

	/**
	 * O motivo de usar esse método toda vez que inicia um cadastro, o que é mais trabalhoso,
	 * é porque tive a visão dele poder ser utilizado em várias máquinas que podem trabalhar
	 * em um mesmo diretório de dados simultâneamente. Mas se for melhor posso mudar para um
	 * simples contador
	 * @return
	 * @throws IOException
	 */
	private Integer verificaUltimoNumeroDeFormularios() throws IOException {
		
		File arquivos[] = new File(CAMINHO_PASTA_CANDIDATOS).listFiles();

		Integer maiorNumeroEncontrado = 0;
		for (File arquivo : arquivos) {
			// Pega o nome do arquivo porque no próximo código ele será usado duas vezes
			String nomeArquivo = arquivo.getName();
			// Converte para inteiro
			Integer novoNumero = Integer.parseInt(nomeArquivo.substring(0, nomeArquivo.indexOf("-")));
			// Verifica se é o maior até o momento
			if (novoNumero >= maiorNumeroEncontrado)
				maiorNumeroEncontrado = novoNumero;
		}
		
		return maiorNumeroEncontrado;
	}

	private String formataNomeParaArquivoDeCandidato(String nome) {
        String nfdNormalizedString = Normalizer.normalize(nome, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("").toUpperCase();
	}

}
