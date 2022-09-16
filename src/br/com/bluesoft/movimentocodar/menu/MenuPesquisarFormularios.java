package br.com.bluesoft.movimentocodar.menu;

public class MenuPesquisarFormularios implements Menu {

	@Override
	public String getTitulo() {
		return "Pesquisar formulários cadastrados";
	}

	@Override
	public void abreMenu() {
		System.out.println(">>> " + this.getTitulo() + " <<<");		
	}

}
