package br.com.bluesoft.movimentocodar.modelo;

public class Pergunta {

	private String id;
	private String pergunta;

	public Pergunta(String id, String pergunta) {
		super();
		this.id = id;
		this.pergunta = pergunta;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPergunta() {
		return pergunta;
	}

}
