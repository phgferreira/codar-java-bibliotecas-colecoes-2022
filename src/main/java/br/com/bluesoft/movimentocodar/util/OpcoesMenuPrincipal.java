package br.com.bluesoft.movimentocodar.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.com.bluesoft.movimentocodar.io.InterfaceUsuarioEntrada;
import br.com.bluesoft.movimentocodar.io.InterfaceUsuarioSaida;
import br.com.bluesoft.movimentocodar.menu.Menu;
import br.com.bluesoft.movimentocodar.menu.MenuSair;

public class OpcoesMenuPrincipal {
	
	private InterfaceUsuarioEntrada entrada;
	private InterfaceUsuarioSaida saida;
	private List<Menu> opcoes;
	
	public OpcoesMenuPrincipal(InterfaceUsuarioEntrada entrada, InterfaceUsuarioSaida saida) {
		this.entrada = entrada;
		this.saida = saida;

		opcoes = Arrays.asList(
//				new MenuCandidatarSe(entrada),
//				new MenuAdicionarPergunta(entrada, formularioPerguntas),
//				new MenuRemoverFormulario(entrada, formularioPerguntas),
//				new MenuListarFormularios(entrada),
//				new MenuValidarFormularios(entrada),
//				new MenuPesquisarFormularios(entrada),
				new MenuSair(entrada, saida)
			);
	}

	public List<Menu> getOpcoes() {
		return Collections.unmodifiableList(opcoes);
	}
	
	public Menu getOpcao(int index) {
		return opcoes.get(index);
	}
}
