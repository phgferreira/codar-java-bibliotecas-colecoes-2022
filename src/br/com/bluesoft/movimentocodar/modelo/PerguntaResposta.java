package br.com.bluesoft.movimentocodar.modelo;

import br.com.bluesoft.movimentocodar.excecao.IdadeNaoPermitidaException;
import br.com.bluesoft.movimentocodar.util.VerificadorDeIdade;

public class PerguntaResposta {

	private String idPergunta;
	private String pergunta;
	private String resposta;

	public PerguntaResposta(String idPergunta, String pergunta) {
		this.idPergunta = idPergunta;
		this.pergunta = pergunta;
	}
	
	public String getIdPergunta() {
		return idPergunta;
	}
	
	public String getPergunta() {
		return pergunta;
	}
	
	public String getResposta() {
		return resposta;
	}
	
	public void setResposta(String resposta) throws NumberFormatException, IdadeNaoPermitidaException {
		// Se idPergunta for igual a P3 então estão respondendo a idade
		if (idPergunta.equals("P3"))
			new VerificadorDeIdade().verificaIdade( Integer.parseInt(resposta) );
		this.resposta = resposta;
	}

}
