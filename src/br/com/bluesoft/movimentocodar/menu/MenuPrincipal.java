package br.com.bluesoft.movimentocodar.menu;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MenuPrincipal implements Menu {

	@Override
	public String getTitulo() {
		return "Menu Principal";
	}

	@Override
	public void abreMenu() {
		System.out.println("### " + this.getTitulo() + " ###");
		List<Menu> opcoes = Arrays.asList(
				new MenuCandidatarSe(),
//				new MenuAdicionarPergunta(), //"Adicionar pergunta ao formulário"
//				new MenuRemoverFormulario(), //"Remover pergunta do formulário"
//				new MenuListarFormularios(), //"Listar formulários cadastrados"
//				new MenuPesquisarFormularios(), //"Pesquisar formulários cadastrados"
//				new MenuValidarFormularios(), //"Validar formulários"
				new MenuSair() //"Sair"
			);
		IntStream.range(0, opcoes.size())
			.forEach( indice -> System.out.println(indice + " - " + opcoes.get(indice).getTitulo()) );
		
		try {
			Scanner reader = new Scanner(new InputStreamReader(System.in));
			Integer escolha = reader.nextInt();
			opcoes.get(escolha).abreMenu();
		} catch (RuntimeException e) {
			System.err.println("Escolha apenas as opções numéricas existentes no menu"
					+ System.lineSeparator() 
					+ "Por favor tente novamente");
		}
		
	}
}
