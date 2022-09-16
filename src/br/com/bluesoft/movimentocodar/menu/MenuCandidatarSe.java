package br.com.bluesoft.movimentocodar.menu;

public class MenuCandidatarSe implements Menu {

	@Override
	public String getTitulo() {
		return "Candidatar-se";
	}

	@Override
	public void abreMenu() {
		System.out.println("### " + this.getTitulo() + " ###");
	}

}
