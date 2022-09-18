package br.com.bluesoft.movimentocodar.menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import br.com.bluesoft.movimentocodar.excecao.SemRespostaException;

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
				new MenuAdicionarPergunta()
//				new MenuRemoverFormulario(),
//				new MenuListarFormularios(),
//				new MenuPesquisarFormularios(),
//				new MenuValidarFormularios(),
//				new MenuSair()
			);
		IntStream.range(0, opcoes.size())
			.forEach( indice -> System.out.println(indice + " - " + opcoes.get(indice).getTitulo()) );
		
		try {
			int escolha = InterfaceUsuario.perguntaAoUsuarioPegaInteiro(null);
			opcoes.get(escolha).abreMenu();
			// Estranho, eu não posso fechar o scanner e abrir outro novo
			//scanner.close();
		} catch (RuntimeException | SemRespostaException e) {
			e.printStackTrace();
			System.err.println("Escolha apenas as opções numéricas existentes no menu"
					+ System.lineSeparator() 
					+ "Por favor tente novamente");
		}
		
	}
}
