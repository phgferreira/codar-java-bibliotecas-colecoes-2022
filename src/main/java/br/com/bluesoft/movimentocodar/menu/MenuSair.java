package br.com.bluesoft.movimentocodar.menu;

import java.io.IOException;

import br.com.bluesoft.movimentocodar.io.InterfaceUsuarioEntrada;
import br.com.bluesoft.movimentocodar.io.InterfaceUsuarioSaida;

public class MenuSair extends Menu {
	
	public MenuSair(InterfaceUsuarioEntrada entrada, InterfaceUsuarioSaida saida) {
		super(entrada, saida);
	}

	@Override
	public String getTitulo() {
		return "Sair";
	}

	@Override
	public void abreMenu() {
		try {
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		saida.exibeMensagem("Volte Sempre! :)");
		
		// Termina a aplicação com sucesso
		System.exit(0);
	}

}
