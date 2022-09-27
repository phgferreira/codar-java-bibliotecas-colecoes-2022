package br.com.bluesoft.movimentocodar.menu;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import br.com.bluesoft.movimentocodar.io.FormulariosCandidato;
import br.com.bluesoft.movimentocodar.io.InterfaceUsuarioEntrada;

public class MenuListarFormularios extends Menu {

	public MenuListarFormularios(InterfaceUsuarioEntrada interfaceUsuarioEntrada) {
		super(interfaceUsuarioEntrada);
	}

	@Override
	public String getTitulo() {
		return "Listar formulários cadastrados";
	}

	@Override
	public void abreMenu() {
		System.out.println(">>> " + this.getTitulo() + " <<<");
		
//		try {
//			int opcao = Integer.parseInt(interfaceUsuario.perguntaAoUsuario(
//					"1. Nomes agrupados por idade" + System.lineSeparator() 
//					+ "2. Quantidade por idade" + System.lineSeparator() 
//					+ "Qual das formas acima deseja visualizar a lista?"));
//			Map<Integer, Set<String>> nomesPorIdade = new FormulariosCandidato().listarNomesPorIdade();
//			if (opcao == 1) {
//				nomesPorIdade.forEach( (idade, nomes) -> {
//					System.out.println("### Idade " + idade + " ###");
//					nomes.forEach( (nome) -> System.out.println(nome) );
//				});
//			}
//			if (opcao == 2) {
//				nomesPorIdade.forEach( (idade, nomes) -> {
//					System.out.println("Idade " + idade + ": " + nomes.size());
//				});
//			}
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}

}
