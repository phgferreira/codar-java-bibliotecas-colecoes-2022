package br.com.bluesoft.movimentocodar.menu;

public class MenuSair implements Menu {

	@Override
	public String getTitulo() {
		return "Sair";
	}

	@Override
	public void abreMenu() {
		System.out.println("Volte Sempre! :)");
		
		// Termina a aplicação com sucesso
		System.exit(0);
	}

}
