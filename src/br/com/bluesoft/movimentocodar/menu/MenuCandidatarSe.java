package br.com.bluesoft.movimentocodar.menu;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import br.com.bluesoft.movimentocodar.excecao.IdadeNaoPermitidaException;
import br.com.bluesoft.movimentocodar.modelo.PerguntaResposta;

public class MenuCandidatarSe implements Menu {
	
	//private List<PerguntaResposta> perguntaRespostas;
	private Map<String, PerguntaResposta> perguntasERespostas;
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
			perguntasERespostas = new FormularioPerguntas().asMap();
			iniciaQuestionario();
//			guardaCandidato();
		} catch (IOException | IdadeNaoPermitidaException e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	private void iniciaQuestionario() throws IOException, IdadeNaoPermitidaException {
		Scanner scanner = new Scanner(System.in);
		
		for (String idPergunta : perguntasERespostas.keySet()) {
			System.out.println(perguntasERespostas.get(idPergunta).getPergunta());
			perguntasERespostas.get(idPergunta).setResposta(scanner.next());
		}
//		for (PerguntaResposta perguntaResposta : perguntaRespostas) {
//			System.out.println(perguntaResposta.getPergunta());
//			perguntaResposta.setResposta(reader.readLine());
//		}
		
//		verificaIdadeDoCandidato();
	}
	
//	private void verificaIdadeDoCandidato() throws IdadeNaoPermitidaException {
//		if (Integer.parseInt(perguntaRespostas.get(2).getResposta()) < 16)
//			throw new IdadeNaoPermitidaException("Desculpa, você é muito jovem e a idade permita é de no mínimo 16 anos");
//	}
	
//	private void guardaCandidato() throws IOException {
//		verificaUltimoNumeroDeFormularios();
//
//		String URL = CAMINHO_PASTA_CANDIDATOS
//				+ CONTADOR + "-" + formataNomeParaArquivo(perguntaRespostas.get(0).getResposta())
//				+ "." + EXTENSAO_PADRAO;
//
//		BufferedWriter writer = new BufferedWriter(new FileWriter(URL));
//		for (PerguntaResposta perguntaResposta : perguntaRespostas) {
//			writer.write(perguntaResposta.getId() + "|" 
//					+ perguntaResposta.getPergunta() + "|"
//					+ perguntaResposta.getResposta());
//			writer.newLine();
//		}
//		writer.close();
//		
//		System.out.println("--- Candidato " + perguntaRespostas.get(0).getResposta() + " salvo com Sucesso ---");
//
//		CONTADOR++;
//	}

//	private void verificaUltimoNumeroDeFormularios() throws IOException {
//		
//		// Que código lixo kkkk tenho que melhorar isso aqui
//		File arquivos[] = new File(CAMINHO_PASTA_CANDIDATOS).listFiles();
//		for (File arquivo : arquivos) {
//			String nomeArquivo = arquivo.getName();
//			Integer maiorEncontrado = Integer.parseInt(nomeArquivo.substring(0, nomeArquivo.indexOf("-")));
//			if (maiorEncontrado >= CONTADOR)
//				CONTADOR = maiorEncontrado+1;
//		}
//		
//	}

//	private String formataNomeParaArquivo(String nome) {
//        String nfdNormalizedString = Normalizer.normalize(nome, Normalizer.Form.NFD);
//        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
//        return pattern.matcher(nfdNormalizedString).replaceAll("").toUpperCase();
//	}

}
