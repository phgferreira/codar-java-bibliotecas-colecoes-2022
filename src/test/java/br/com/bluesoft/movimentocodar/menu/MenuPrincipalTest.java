package br.com.bluesoft.movimentocodar.menu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import br.com.bluesoft.movimentocodar.io.InterfaceUsuarioEntrada;
import br.com.bluesoft.movimentocodar.io.InterfaceUsuarioSaida;
import br.com.bluesoft.movimentocodar.util.OpcoesMenuPrincipal;

class MenuPrincipalTest {

	@Mock
	private static InterfaceUsuarioEntrada entrada;
	
	@Mock
	private InterfaceUsuarioSaida saida;
	
	@Mock
	private OpcoesMenuPrincipal opcoes;

	private MenuPrincipal menuPrincipal;
	
	private ArgumentCaptor<String> captorDeTitulo;
	private ArgumentCaptor<List<Menu>> captorDeOpcoes;
	
	@BeforeAll
	static void beforeAll() {
		entrada = new InterfaceUsuarioEntrada();
		Mockito.mock(entrada.getClass());
	}
	
	@AfterAll
	static void afterAll() {
		try {
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void deveExibirMenuEPegarEscolhaDoUsuarioComOpcaoValida() {
		try {
			Mockito.when(entrada.getRespostaEmInteiro()).thenReturn(0);
		} catch (NumberFormatException | IOException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}

		saida = new InterfaceUsuarioSaida();
		Mockito.mock(saida.getClass());
		
		opcoes = new OpcoesMenuPrincipal(entrada, saida);
		Mockito.mock(opcoes.getClass());
		// Falta retornar uma lista fictícia de opções

		menuPrincipal = new MenuPrincipal(entrada, saida, opcoes);
		menuPrincipal.abreMenu();
		
		Mockito.verify(saida).exibeMensagem(captorDeTitulo.capture());
		String titulo = captorDeTitulo.getValue();
		assertEquals("### " + menuPrincipal.getTitulo() + " ###", titulo);
		
		Mockito.verify(saida).exibeOpcoesDeMenu(captorDeOpcoes.capture());
		List<Menu> opcoes = captorDeOpcoes.getValue();
		assertFalse(opcoes.isEmpty());
		assertTrue( opcoes.get(0) instanceof MenuSair );
		
	}
	
	private List<Menu> montaListaMenu() {
		return Arrays.asList(
				new MenuSair(entrada, saida)
			);
	}
		
}
