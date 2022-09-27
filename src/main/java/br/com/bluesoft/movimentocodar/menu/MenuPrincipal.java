package br.com.bluesoft.movimentocodar.menu;

import java.io.IOException;
import java.util.InputMismatchException;

import br.com.bluesoft.movimentocodar.io.InterfaceUsuarioEntrada;
import br.com.bluesoft.movimentocodar.io.InterfaceUsuarioSaida;
import br.com.bluesoft.movimentocodar.util.OpcoesMenuPrincipal;

public class MenuPrincipal extends Menu {
	
	private OpcoesMenuPrincipal opcoes;

	public MenuPrincipal(InterfaceUsuarioEntrada entrada, InterfaceUsuarioSaida saida, OpcoesMenuPrincipal opcoes) {
		super(entrada, saida);
		this.opcoes = opcoes;
	}

	@Override
	public String getTitulo() {
		return "Menu Principal";
	}

	@Override
	public void abreMenu() {
		saida.exibeMensagem("### " + this.getTitulo() + " ###");
		saida.exibeOpcoesDeMenu(opcoes.getOpcoes());

		try {
			int escolha = entrada.getRespostaEmInteiro();
			opcoes.getOpcao(escolha).abreMenu();
		} catch (IndexOutOfBoundsException | InputMismatchException | NumberFormatException | IOException e) {
			System.err.println("Escolha apenas as opções numéricas existentes no menu"
					+ System.lineSeparator()
					+ "Por favor tente novamente");
		}
		
	}
	
}
