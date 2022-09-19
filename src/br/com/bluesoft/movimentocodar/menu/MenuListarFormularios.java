package br.com.bluesoft.movimentocodar.menu;

import java.io.IOException;

import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;

public class MenuListarFormularios extends Menu {

	public MenuListarFormularios(InterfaceUsuario interfaceUsuario) {
		super(interfaceUsuario);
	}

	@Override
	public String getTitulo() {
		return "Listar formulários cadastrados";
	}

	@Override
	public void abreMenu() {
		System.out.println(">>> " + this.getTitulo() + " <<<");
		
		try {
			int opcao = Integer.parseInt(interfaceUsuario.perguntaAoUsuario(
					"1. Nomes agrupados por idade" + System.lineSeparator() 
					+ "2. Quantidade por idade" + System.lineSeparator() 
					+ "Qual das formas acima deseja visualizar a lista?"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
