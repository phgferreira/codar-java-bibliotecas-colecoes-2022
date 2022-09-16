package br.com.bluesoft.movimentocodar;

import java.io.IOException;

import br.com.bluesoft.movimentocodar.menu.MenuCandidatarSe;

public class Main {

	public static void main(String[] args) throws IOException {
		new MenuCandidatarSe().abreMenu();
//		while(true) {
//			new MenuPrincipal().abreMenu();
//			System.out.println("--- Volta ao MenuPrincipal ---");
//		}
	}

}
