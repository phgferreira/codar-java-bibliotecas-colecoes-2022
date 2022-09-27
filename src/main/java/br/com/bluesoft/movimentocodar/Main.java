package br.com.bluesoft.movimentocodar;

import br.com.bluesoft.movimentocodar.io.InterfaceUsuarioEntrada;
import br.com.bluesoft.movimentocodar.io.InterfaceUsuarioSaida;
import br.com.bluesoft.movimentocodar.menu.MenuPrincipal;
import br.com.bluesoft.movimentocodar.util.OpcoesMenuPrincipal;

public class Main {

	/**
	 * O método main será responsável apenas por garantir a continuidade do sistema
	 * por meio de um loop infinito.
	 * O loop é interrompido no MenuSair.
	 */
	public static void main(String[] args) {
		// O interfaceUsuario estou instanciando logo no início porque ele só pode ser fechado no final do aplicativo
		InterfaceUsuarioEntrada entrada = new InterfaceUsuarioEntrada();

		while(true) {
			MenuPrincipal menu = new MenuPrincipal(entrada, new InterfaceUsuarioSaida(), new OpcoesMenuPrincipal(entrada, new InterfaceUsuarioSaida()));
			menu.abreMenu();
		}
	}

}
