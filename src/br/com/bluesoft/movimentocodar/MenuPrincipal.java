package br.com.bluesoft.movimentocodar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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
		IntStream.range(0, opcoes.size())
			.forEach( indice -> System.out.println(indice + " - " + opcoes.get(indice)) );
		
	}
}
