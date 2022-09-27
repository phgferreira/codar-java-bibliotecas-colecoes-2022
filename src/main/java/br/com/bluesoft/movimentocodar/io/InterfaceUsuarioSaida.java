package br.com.bluesoft.movimentocodar.io;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.IntStream;

import br.com.bluesoft.movimentocodar.menu.Menu;

public class InterfaceUsuarioSaida {

	private PrintStream saida;
	
	public InterfaceUsuarioSaida() {
		saida = System.out;
	}
	
	public void exibeMensagem(String mensagem) {
		saida.println(mensagem);
	}
	
	public void exibeOpcoesDeMenu(List<Menu> opcoes) {
		IntStream.range(0, opcoes.size())
			.forEach( indice -> System.out.println(indice + " - " + opcoes.get(indice).getTitulo()) );
	}
	
}
