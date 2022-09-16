package br.com.bluesoft.movimentocodar.modelo;

public class PerguntaResposta {

	private String id;
	private String pergunta;
	private String resposta;

	public PerguntaResposta(String id, String descricao) {
		this.id = id;
		this.pergunta = descricao;
	}
	
	public String getId() {
		return id;
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

	@Override
	public String toString() {
		return "Pergunta [id=" + id + ", pergunta=" + pergunta + ", resposta=" + resposta + "]";
	}
}
