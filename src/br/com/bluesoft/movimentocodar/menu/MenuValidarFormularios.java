package br.com.bluesoft.movimentocodar.menu;

import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;

public class MenuValidarFormularios extends Menu {

	public MenuValidarFormularios(InterfaceUsuario interfaceUsuario) {
		super(interfaceUsuario);
	}

	@Override
	public String getTitulo() {
		return "Validar formulários";
	}

	@Override
	public void abreMenu() {
		System.out.println(">>> " + this.getTitulo() + " <<<");
	}

}
