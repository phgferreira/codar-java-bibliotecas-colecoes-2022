package br.com.bluesoft.movimentocodar.menu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import br.com.bluesoft.movimentocodar.excecao.IdadeNaoPermitidaException;
import br.com.bluesoft.movimentocodar.io.FormularioPerguntas;
import br.com.bluesoft.movimentocodar.io.VerificadorDoUltimoNumeroDeFormulario;
import br.com.bluesoft.movimentocodar.modelo.PerguntaResposta;
import br.com.bluesoft.movimentocodar.util.FormatadorDeNomeParaArquivo;

public class MenuCandidatarSe implements Menu {
	
	//private List<PerguntaResposta> perguntaRespostas;
	private Map<String, PerguntaResposta> perguntasERespostas;
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
			perguntasERespostas = new FormularioPerguntas().getSomentePerguntasEmMapa();
			iniciaQuestionario();
			guardaCandidato();
		} catch (IOException | NumberFormatException | IdadeNaoPermitidaException e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	private void iniciaQuestionario() throws IOException, NumberFormatException, IdadeNaoPermitidaException {
		for (String idPergunta : perguntasERespostas.keySet()) {
			String pergunta = perguntasERespostas.get(idPergunta).getPergunta();
			String resposta = InterfaceUsuario.perguntaAoUsuarioPegaString(pergunta);
			perguntasERespostas.get(idPergunta).setResposta(resposta);
		}
	}
	
	private void guardaCandidato() throws IOException {

		String URL = CAMINHO_PASTA_CANDIDATOS
				+ new VerificadorDoUltimoNumeroDeFormulario().verifica(CAMINHO_PASTA_CANDIDATOS)
				+ "-" + new FormatadorDeNomeParaArquivo().formata(perguntasERespostas.get("P1").getResposta())
				+ "." + EXTENSAO_PADRAO;

		BufferedWriter writer = new BufferedWriter(new FileWriter(URL));
		for (String idPergunta : perguntasERespostas.keySet()) {
			writer.write(idPergunta + "|" 
					+ perguntasERespostas.get(idPergunta).getPergunta() + "|"
					+ perguntasERespostas.get(idPergunta).getResposta());
			writer.newLine();
		}
		
		writer.close();
		
		System.out.println("--- Candidato " + perguntasERespostas.get("P1").getResposta() + " salvo com Sucesso ---");
	}

}
