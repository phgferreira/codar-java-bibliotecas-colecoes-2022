package br.com.bluesoft.movimentocodar.menu;

import java.io.IOException;

import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;

public class MenuSair extends Menu {
	
	public MenuSair(InterfaceUsuario interfaceUsuario) {
		super(interfaceUsuario);
	}

	@Override
	public String getTitulo() {
		return "Sair";
	}

	@Override
	public void abreMenu() {
		try {
			interfaceUsuario.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Volte Sempre! :)");
		
		// Termina a aplicação com sucesso
		System.exit(0);
	}

}
