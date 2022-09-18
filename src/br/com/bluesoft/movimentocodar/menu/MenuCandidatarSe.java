package br.com.bluesoft.movimentocodar.menu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.bluesoft.movimentocodar.excecao.IdadeNaoPermitidaException;
import br.com.bluesoft.movimentocodar.io.FormularioPerguntas;
import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;
import br.com.bluesoft.movimentocodar.io.VerificadorDoUltimoNumeroDeFormulario;
import br.com.bluesoft.movimentocodar.modelo.Pergunta;
import br.com.bluesoft.movimentocodar.modelo.PerguntaComResposta;
import br.com.bluesoft.movimentocodar.util.FormatadorDeNomeParaArquivo;

public class MenuCandidatarSe extends Menu {
	
	private FormularioPerguntas formularioPerguntas;
	
	public MenuCandidatarSe(InterfaceUsuario interfaceUsuario, FormularioPerguntas formularioPerguntas) {
		super(interfaceUsuario);
		this.formularioPerguntas = formularioPerguntas;
	}

	//private List<PerguntaResposta> perguntaRespostas;
	private Map<String, PerguntaComResposta> perguntaComResposta = new HashMap<>();
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
			List<Pergunta> perguntas = formularioPerguntas.getPerguntasEmLista();
			iniciaQuestionario(perguntas);
			guardaCandidato();
		} catch (IOException | NumberFormatException | IdadeNaoPermitidaException e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	private void iniciaQuestionario(List<Pergunta> perguntas) throws IOException, NumberFormatException, IdadeNaoPermitidaException {
		for (Pergunta pergunta : perguntas) {
			String resposta = interfaceUsuario.perguntaAoUsuario(pergunta.getPergunta());
			perguntaComResposta.put(pergunta.getId(), new PerguntaComResposta(pergunta, resposta));
		}
	}
	
	private void guardaCandidato() throws IOException {

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
