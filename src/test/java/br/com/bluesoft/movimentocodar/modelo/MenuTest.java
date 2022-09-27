package br.com.bluesoft.movimentocodar.modelo;

import br.com.bluesoft.movimentocodar.menu.Menu;

public class MenuTest extends Menu {

	@Override
	public String getTitulo() {
		return "Menu de Teste";
	}

	@Override
	public void abreMenu() {
		System.out.println("Abriu menu de teste");
	}

}
