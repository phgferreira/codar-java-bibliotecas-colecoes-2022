package br.com.bluesoft.movimentocodar.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;
import br.com.bluesoft.movimentocodar.menu.Menu;
import br.com.bluesoft.movimentocodar.menu.MenuSair;

public class OpcoesSubmenu {
	
	private InterfaceUsuario interfaceUsuario;
	
	public OpcoesSubmenu(InterfaceUsuario interfaceUsuario) {
		this.interfaceUsuario = interfaceUsuario;

	}

	public List<Menu> getOpcoes() {
		List<MenuSair> opcoes = Arrays.asList(
//				new MenuCandidatarSe(entrada),
//				new MenuAdicionarPergunta(entrada, formularioPerguntas),
//				new MenuRemoverFormulario(entrada, formularioPerguntas),
//				new MenuListarFormularios(entrada),
//				new MenuValidarFormularios(entrada),
//				new MenuPesquisarFormularios(entrada),
				new MenuSair(interfaceUsuario)
			);
		return Collections.unmodifiableList(opcoes);
	}

}
