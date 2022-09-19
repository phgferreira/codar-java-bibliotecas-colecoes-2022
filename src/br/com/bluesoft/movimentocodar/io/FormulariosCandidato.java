package br.com.bluesoft.movimentocodar.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import br.com.bluesoft.movimentocodar.modelo.PerguntaComResposta;
import br.com.bluesoft.movimentocodar.util.FormatadorDeNomeParaArquivo;

public class FormulariosCandidato {

	private static final String CAMINHO_PASTA_CANDIDATOS = "C:\\candidatos\\";
	private static final String EXTENSAO_PADRAO = "txt";

	public void guardaNovoCandidato(Map<String, PerguntaComResposta> perguntaComResposta) throws IOException {

		String URL = CAMINHO_PASTA_CANDIDATOS
				+ new VerificadorDoUltimoNumeroDeFormulario().verifica(CAMINHO_PASTA_CANDIDATOS)
				+ "-" + new FormatadorDeNomeParaArquivo().formata(perguntaComResposta.get("P1").getResposta())
				+ "." + EXTENSAO_PADRAO;

		BufferedWriter writer = new BufferedWriter(new FileWriter(URL));
		for (String idPergunta : perguntaComResposta.keySet()) {
			writer.write(idPergunta + "|" 
					+ perguntaComResposta.get(idPergunta).getPergunta().getPergunta() + "|"
					+ perguntaComResposta.get(idPergunta).getResposta());
			writer.newLine();
		}
		
		writer.close();
		
		System.out.println("--- Candidato " + perguntaComResposta.get("P1").getResposta() + " salvo com Sucesso ---");
	}	
}
