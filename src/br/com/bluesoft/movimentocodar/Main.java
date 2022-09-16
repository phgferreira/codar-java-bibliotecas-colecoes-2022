package br.com.bluesoft.movimentocodar;

import java.io.IOException;

import br.com.bluesoft.movimentocodar.menu.MenuPrincipal;

public class Main {

	public static void main(String[] args) throws IOException {
		while(true) {
			new MenuPrincipal().abreMenu();
			System.out.println("--- Volta ao MenuPrincipal ---");
		}
	}

}
