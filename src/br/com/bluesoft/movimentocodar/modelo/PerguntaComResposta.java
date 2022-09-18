package br.com.bluesoft.movimentocodar.modelo;

import br.com.bluesoft.movimentocodar.excecao.IdadeNaoPermitidaException;
import br.com.bluesoft.movimentocodar.util.VerificadorDeIdade;

public class PerguntaComResposta {

	private Pergunta pergunta;
	private String resposta;

	public PerguntaComResposta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}
	
	public Pergunta getPergunta() {
		return pergunta;
	}
	
	public String getResposta() {
		return resposta;
	}
	
	public void setResposta(String resposta) throws NumberFormatException, IdadeNaoPermitidaException {
		// Se idPergunta for igual a P3 então estão respondendo a idade
		if (pergunta.getId().equals("P3"))
			new VerificadorDeIdade().verificaIdade( Integer.parseInt(resposta) );
		this.resposta = resposta;
	}

}
