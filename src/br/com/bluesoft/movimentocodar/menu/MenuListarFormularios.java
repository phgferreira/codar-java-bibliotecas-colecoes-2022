package br.com.bluesoft.movimentocodar.menu;

import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;

public class MenuListarFormularios extends Menu {

	public MenuListarFormularios(InterfaceUsuario interfaceUsuario) {
		super(interfaceUsuario);
	}

	@Override
	public String getTitulo() {
		return "Listar formulários cadastrados";
	}

	@Override
	public void abreMenu() {
		System.out.println(">>> " + this.getTitulo() + " <<<");		
	}

}
