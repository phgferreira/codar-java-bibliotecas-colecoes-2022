package br.com.bluesoft.movimentocodar.menu;

import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;

public class MenuSair implements Menu {

	@Override
	public String getTitulo() {
		return "Sair";
	}

	@Override
	public void abreMenu() {
		
		// Fecha o InputStream de contato com o usuário
		InterfaceUsuario.close();
		
		System.out.println("Volte Sempre! :)");
		
		// Termina a aplicação com sucesso
		System.exit(0);
	}

}
