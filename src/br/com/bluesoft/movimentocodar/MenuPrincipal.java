package br.com.bluesoft.movimentocodar;

import java.util.Arrays;
import java.util.List;

public class MenuPrincipal {

	List<String> opcoes;
	
	public MenuPrincipal() {
		opcoes = Arrays.asList(
				"Candidatar-se",
				"Adicionar pergunta ao formulário",
				"Remover pergunta do formulário",
				"Listar formulários cadastrados",
				"Pesquisar formulários cadastrados",
				"Validar formulários",
				"Sair");
		opcoes.forEach(opcao -> System.out.println(opcao));
		
	}
}
