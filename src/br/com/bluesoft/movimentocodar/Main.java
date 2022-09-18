package br.com.bluesoft.movimentocodar;

import java.io.IOException;

import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;
import br.com.bluesoft.movimentocodar.menu.MenuPrincipal;

public class Main {

	public static void main(String[] args) throws IOException {
		InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
		while(true) {
			new MenuPrincipal(interfaceUsuario).abreMenu();
			System.out.println("--- Volta ao MenuPrincipal ---");
		}
	}

}
