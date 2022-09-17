package br.com.bluesoft.movimentocodar.modelo;

public class PerguntaResposta {

	private String pergunta;
	private String resposta;

	public PerguntaResposta(String pergunta) {
		this.pergunta = pergunta;
	}
	
	public String getPergunta() {
		return pergunta;
	}
	
	public String getResposta() {
		return resposta;
	}
	
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

}
