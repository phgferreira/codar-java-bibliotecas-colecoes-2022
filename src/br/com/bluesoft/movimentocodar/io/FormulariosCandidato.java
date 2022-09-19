package br.com.bluesoft.movimentocodar.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
	
	public void listarNomesPorIdade() throws IOException {
		File arquivos[] = new File(CAMINHO_PASTA_CANDIDATOS).listFiles();
		Map<Integer, Set<String>> nomesPorIdade = new HashMap<>();

		for (File arquivo : arquivos) {
			BufferedReader reader = new BufferedReader( new FileReader(arquivo));

			// Pegar os valores de nome e idade
			int idade = 0;
			String nome = "";
			// Talvez não tenha sido uma boa ideia fazer um for com String kkkk mas quiser experimentar
			for (String linha = reader.readLine(); linha!=null; linha = reader.readLine()) {
				String valores[] = linha.split("\\|");
				if (valores[0].equals("P3"))
					idade = Integer.parseInt(valores[2]);
				if (valores[0].equals("P1"))
					nome = valores[2];
			}
			
			// Verifica se já não foi inserido a mesma idade, senão então instancia uma coleção
			if (nomesPorIdade.get(idade) == null)
				nomesPorIdade.put(idade, new HashSet<>());
			
			// Adiciona o nome na coleção da idade específica
			nomesPorIdade.get(idade).add(nome);
			
			reader.close();
		}

		nomesPorIdade.forEach( (idade2, nomes) -> {
			System.out.println("### Idade " + idade2 + " ###");
			nomes.forEach( (nome2) -> System.out.println(nome2) );
		});
		
		
	}
}
