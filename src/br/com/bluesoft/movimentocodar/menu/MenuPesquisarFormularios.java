package br.com.bluesoft.movimentocodar.menu;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import br.com.bluesoft.movimentocodar.io.FormulariosCandidato;
import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;

public class MenuPesquisarFormularios extends Menu {

	public MenuPesquisarFormularios(InterfaceUsuario interfaceUsuario) {
		super(interfaceUsuario);
	}

	@Override
	public String getTitulo() {
		return "Pesquisar formulários cadastrados";
	}

	@Override
	public void abreMenu() {
		System.out.println(">>> " + this.getTitulo() + " <<<");	
		
		try {
			String nome = interfaceUsuario.perguntaAoUsuario("Qual é o nome do candidato?");
			String email = interfaceUsuario.perguntaAoUsuario("Qual é o e-mail do candidato?");
			boolean encontrado = new FormulariosCandidato().procuraCandidato(nome, email);
			if (encontrado)
				System.out.println(nome + " (" + email + ") está cadastrado!");
			else
				System.err.println(nome + " (" + email + ") não está cadastrado!");
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
