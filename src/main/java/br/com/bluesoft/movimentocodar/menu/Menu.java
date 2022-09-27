package br.com.bluesoft.movimentocodar.menu;

import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;

public abstract class Menu {
	
	protected InterfaceUsuario interfaceUsuario;
	
	public Menu() {
		
	}
	
	public Menu(InterfaceUsuario interfaceUsuario) {
		this.interfaceUsuario = interfaceUsuario;
	}
	
	public abstract String getTitulo();
	public abstract void abreMenu();
	
}
