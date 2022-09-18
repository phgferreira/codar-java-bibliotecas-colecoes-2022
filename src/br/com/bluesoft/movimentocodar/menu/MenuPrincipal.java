package br.com.bluesoft.movimentocodar.menu;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import br.com.bluesoft.movimentocodar.io.FormularioPerguntas;
import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;

public class MenuPrincipal extends Menu {
	
	private FormularioPerguntas formularioPerguntas;

	public MenuPrincipal(InterfaceUsuario interfaceUsuario, FormularioPerguntas formularioPerguntas) {
		super(interfaceUsuario);
		this.formularioPerguntas = formularioPerguntas;
	}

	@Override
	public String getTitulo() {
		return "Menu Principal";
	}

	@Override
	public void abreMenu() {
		System.out.println("### " + this.getTitulo() + " ###");
		List<Menu> opcoes = Arrays.asList(
				new MenuCandidatarSe(interfaceUsuario, formularioPerguntas),
				new MenuAdicionarPergunta(interfaceUsuario, formularioPerguntas),
				new MenuRemoverFormulario(interfaceUsuario, formularioPerguntas),
//				new MenuListarFormularios(interfaceUsuario),
//				new MenuPesquisarFormularios(interfaceUsuario),
//				new MenuValidarFormularios(interfaceUsuario),
				new MenuSair(interfaceUsuario)
			);
		IntStream.range(0, opcoes.size())
			.forEach( indice -> System.out.println(indice + " - " + opcoes.get(indice).getTitulo()) );
		
		try {
			int escolha = interfaceUsuario.pegaRespostaEmInteiro();
			opcoes.get(escolha).abreMenu();
		} catch (RuntimeException e) {
			System.err.println("Escolha apenas as opções numéricas existentes no menu"
					+ System.lineSeparator() 
					+ "Por favor tente novamente");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
