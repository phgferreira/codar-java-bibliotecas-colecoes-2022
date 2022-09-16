package br.com.bluesoft.movimentocodar.menu;

public class MenuValidarFormularios implements Menu {

	@Override
	public String getTitulo() {
		return "Validar formulários";
	}

	@Override
	public void abreMenu() {
		System.out.println(">>> " + this.getTitulo() + " <<<");
	}

}
