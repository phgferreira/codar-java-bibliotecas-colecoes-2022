package br.com.bluesoft.movimentocodar.menu;

import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;

public class MenuPesquisarFormularios extends Menu {

	public MenuPesquisarFormularios(InterfaceUsuario interfaceUsuario) {
		super(interfaceUsuario);
	}

	@Override
	public String getTitulo() {
		return "Pesquisar formulários cadastrados";
	}

	@Override
	public void abreMenu() {
		System.out.println(">>> " + this.getTitulo() + " <<<");		
	}

}
