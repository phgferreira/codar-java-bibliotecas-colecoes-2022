package br.com.bluesoft.movimentocodar.menu;

import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;

public abstract class Menu {
	
	protected InterfaceUsuario interfaceUsuario;
	
	public Menu() {
		
	}
	
	/**
	 * Todo menu deve interagir com o usuário tendo bem definido a entrada e a saída
	 * @param entrada
	 * @param saida
	 */
	public Menu(InterfaceUsuario interfaceUsuario) {
		this.interfaceUsuario = interfaceUsuario;
	}
	
	public abstract String getTitulo();
	public abstract void abreMenu();
	
}
