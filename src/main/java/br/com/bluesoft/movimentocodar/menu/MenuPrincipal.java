package br.com.bluesoft.movimentocodar.menu;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.IntStream;

import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;

public class MenuPrincipal extends Menu {
	
	private List<Menu> opcoesSubmenu;
	
	public MenuPrincipal(InterfaceUsuario entrada, List<Menu> opcoesSubmenu) {
		super(entrada);
		this.opcoesSubmenu = opcoesSubmenu;
	}

	@Override
	public String getTitulo() {
		return "Menu Principal";
	}

	@Override
	public void abreMenu() {
		System.out.println("### " + this.getTitulo() + " ###");
		
		IntStream.range(0, opcoesSubmenu.size())
		.forEach( indice -> System.out.println(indice + " - " + opcoesSubmenu.get(indice).getTitulo()) );

		try {
			int escolha = interfaceUsuario.getRespostaEmInteiro();
			opcoesSubmenu.get(escolha).abreMenu();
		} catch (IndexOutOfBoundsException | InputMismatchException | NumberFormatException | IOException e) {
			System.err.println("Escolha apenas as opções numéricas existentes no menu"
					+ System.lineSeparator()
					+ "Por favor tente novamente");
		}
		
	}
	
}
