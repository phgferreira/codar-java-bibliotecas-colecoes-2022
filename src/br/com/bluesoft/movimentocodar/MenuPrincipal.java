package br.com.bluesoft.movimentocodar;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
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
		
		try {
			Scanner reader = new Scanner(new InputStreamReader(System.in));
			int opcaoEscolhida = reader.nextInt();
			System.out.println(opcoes.get(opcaoEscolhida));
		} catch (RuntimeException e) {
			System.err.println("Escolha apenas as opções numéricas existentes no menu"
					+ System.lineSeparator() 
					+ "Por favor tente novamente");
		}

	}
}
