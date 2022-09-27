package br.com.bluesoft.movimentocodar.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;
import br.com.bluesoft.movimentocodar.menu.Menu;
import br.com.bluesoft.movimentocodar.menu.MenuAdicionarPergunta;
import br.com.bluesoft.movimentocodar.menu.MenuCandidatarSe;
import br.com.bluesoft.movimentocodar.menu.MenuListarFormularios;
import br.com.bluesoft.movimentocodar.menu.MenuPesquisarFormularios;
import br.com.bluesoft.movimentocodar.menu.MenuRemoverFormulario;
import br.com.bluesoft.movimentocodar.menu.MenuSair;
import br.com.bluesoft.movimentocodar.menu.MenuValidarFormularios;

public class OpcoesSubmenu {
	
	private InterfaceUsuario interfaceUsuario;
	
	public OpcoesSubmenu(InterfaceUsuario interfaceUsuario) {
		this.interfaceUsuario = interfaceUsuario;

	}

	public List<Menu> getOpcoes() {
		List<Menu> opcoes = Arrays.asList(
				new MenuCandidatarSe(interfaceUsuario),
				new MenuAdicionarPergunta(interfaceUsuario),
				new MenuRemoverFormulario(interfaceUsuario),
				new MenuListarFormularios(interfaceUsuario),
				new MenuValidarFormularios(interfaceUsuario),
				new MenuPesquisarFormularios(interfaceUsuario),
				new MenuSair(interfaceUsuario)
			);
		return Collections.unmodifiableList(opcoes);
	}

}
