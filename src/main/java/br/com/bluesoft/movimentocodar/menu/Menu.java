package br.com.bluesoft.movimentocodar.menu;

import br.com.bluesoft.movimentocodar.io.InterfaceUsuarioEntrada;
import br.com.bluesoft.movimentocodar.io.InterfaceUsuarioSaida;

public abstract class Menu {
	
	protected InterfaceUsuarioEntrada entrada;
	protected InterfaceUsuarioSaida saida;
	
	public Menu() {
		
	}
	
	/**
	 * Todo menu deve interagir com o usuário tendo bem definido a entrada e a saída
	 * @param entrada
	 * @param saida
	 */
	public Menu(InterfaceUsuarioEntrada entrada, InterfaceUsuarioSaida saida) {
		this.entrada = entrada;
		this.saida = saida;
	}
	
	public abstract String getTitulo();
	public abstract void abreMenu();
	
}
