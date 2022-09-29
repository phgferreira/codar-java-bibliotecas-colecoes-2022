package br.com.bluesoft.movimentocodar.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import br.com.bluesoft.movimentocodar.modelo.PerguntaComResposta;
import br.com.bluesoft.movimentocodar.util.DivisorDeLinha;
import br.com.bluesoft.movimentocodar.util.FormatadorDeNomeParaArquivo;

public class FormulariosCandidato {

	private String caminho = "C:\\candidatos\\";
	private String extensao = "txt";

	public void guardaNovoCandidato(Map<String, PerguntaComResposta> perguntaComResposta) throws IOException {
		
		String urlNovoCandidato = caminho
				+ VerificadorNumeroArquivos.getUltimoNumero(caminho)
				+ "-" + new FormatadorDeNomeParaArquivo().formata(perguntaComResposta.get("P1").getResposta())
				+ "." + extensao;

		GravadorFormularioCandidato gravador = new GravadorFormularioCandidato(urlNovoCandidato);
		for (String idPergunta : perguntaComResposta.keySet()) {
			gravador.gravaLinha( new DivisorDeLinha().getValoresUnidos(
					idPergunta,
					perguntaComResposta.get(idPergunta).getPergunta().getPergunta(),
					perguntaComResposta.get(idPergunta).getResposta()));
		}
		
		gravador.close();
		
		System.out.println("--- Candidato " + perguntaComResposta.get("P1").getResposta() + " salvo com Sucesso ---");
	}
	
	public Map<Integer, Set<String>> listarNomesPorIdade() throws IOException {
		File arquivos[] = new File(caminho).listFiles();
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
		
		return nomesPorIdade;

	}
	
	public Set<String> getFormulariosDuplicados() throws IOException {
		File arquivos[] = new File(caminho).listFiles();
		Set<String> candidatos = new HashSet<>();
		Set<String> duplicados = new HashSet<>();

		for (File arquivo : arquivos) {
			BufferedReader reader = new BufferedReader( new FileReader(arquivo));
			
			String nome = "", email = "";
			for (String linha = reader.readLine(); linha!=null; linha = reader.readLine()) {
				String valores[] = linha.split("\\|");
				if (valores[0].equals("P1"))
					nome = valores[2];
				if (valores[0].equals("P2"))
					email = valores[2];
				
			}

			if (candidatos.contains(nome+"|"+email))
				duplicados.add(nome+"|"+email);
			else
				candidatos.add(nome+"|"+email);
			
			reader.close();
		}

		return duplicados;

	}

	public boolean procuraCandidato(String nome, String email) throws IOException {
		File arquivos[] = new File(caminho).listFiles();
		for (File arquivo : arquivos) {
			BufferedReader reader = new BufferedReader( new FileReader(arquivo));
			
			String outroNome = "";
			String outroEmail = "";
			for (String linha = reader.readLine(); linha!=null; linha = reader.readLine()) {
				String valores[] = linha.split("\\|");
				if (valores[0].equals("P1"))
					outroNome = valores[2];
				if (valores[0].equals("P2"))
					outroEmail = valores[2];
			}
			
			if ((nome+email).equals(outroNome+outroEmail)) {
				reader.close();
				return true;
			}
			reader.close();
		}
		
		return false;
	}
}
