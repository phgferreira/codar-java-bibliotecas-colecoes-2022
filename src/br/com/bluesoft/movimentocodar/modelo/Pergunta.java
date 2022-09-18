package br.com.bluesoft.movimentocodar.modelo;

import java.util.Objects;

public class Pergunta {

	private String id;
	private String pergunta;
	
	public Pergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public Pergunta(String id, String pergunta) {
		this.id = id;
		this.pergunta = pergunta;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPergunta() {
		return pergunta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pergunta);
	}

	@Override
	public boolean equals(Object object) {
		Pergunta pergunta = (Pergunta) object;
		return this.getPergunta().equals(pergunta.getPergunta());
		//System.out.println("comparando: " + this.pergunta + " com " + pergunta + " = " + this.pergunta.equals(pergunta));
		//return this.pergunta.equals(pergunta);
	}

}
