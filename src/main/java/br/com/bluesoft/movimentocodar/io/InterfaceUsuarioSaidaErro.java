package br.com.bluesoft.movimentocodar.io;

import java.io.PrintStream;

public class InterfaceUsuarioSaidaErro {

	private PrintStream saidaErro;
	
	public InterfaceUsuarioSaidaErro() {
		saidaErro = System.err;
	}
	
	public void exibeErro(String mensagem) {
		saidaErro.print(mensagem);
	}
}
