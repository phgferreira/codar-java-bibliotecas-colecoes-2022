package br.com.bluesoft.movimentocodar.menu;

public class MenuListarFormularios implements Menu {

	@Override
	public String getTitulo() {
		return "Listar formulários cadastrados";
	}

	@Override
	public void abreMenu() {
		System.out.println(">>> " + this.getTitulo() + " <<<");		
	}

}
