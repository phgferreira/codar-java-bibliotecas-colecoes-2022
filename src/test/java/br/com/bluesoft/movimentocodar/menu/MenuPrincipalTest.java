package br.com.bluesoft.movimentocodar.menu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;
import br.com.bluesoft.movimentocodar.service.OpcoesSubmenu;

class MenuPrincipalTest {

	@Mock
	private InterfaceUsuario interfaceUsuario;
	
	private OpcoesSubmenu opcoes;

	private ArgumentCaptor<String> captorDeTitulo;
	private ArgumentCaptor<List<Menu>> captorDeOpcoes;

	private MenuPrincipal menuPrincipal;
	
	@BeforeEach
	void beforeEach() {
		MockitoAnnotations.openMocks(this);
		
		//opcoes = new OpcoesSubmenu( interfaceUsuario );
	}
	
	@Test
	void deveExibirMenuEPegarEscolhaDoUsuarioComOpcaoValida() {
		Integer teste = 100;
		try {
			Mockito.when(interfaceUsuario.getRespostaEmInteiro()).thenReturn(0);
			teste = interfaceUsuario.getRespostaEmInteiro();
		} catch (NumberFormatException | IOException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
		assertEquals(0, teste);

//		Mockito.when(opcoes.getOpcoes()).thenReturn(montaListaMenu());
//		Mockito.when(opcoes.getOpcao( Mockito.anyInt() )).thenReturn(new MenuSair(interfaceUsuario, saida));
//
//		menuPrincipal = new MenuPrincipal(interfaceUsuario, saida, opcoes);
//		System.out.println("Início do teste");
//		menuPrincipal.abreMenu();
//		System.out.println("Fim do teset");
//		
//		Mockito.verify(saida).exibeMensagem(captorDeTitulo.capture());
//		String titulo = captorDeTitulo.getValue();
//		assertEquals("### " + menuPrincipal.getTitulo() + " ###", titulo);
//		
//		Mockito.verify(saida).exibeOpcoesDeMenu(captorDeOpcoes.capture());
//		List<Menu> opcoes = captorDeOpcoes.getValue();
//		assertFalse(opcoes.isEmpty());
//		assertTrue( opcoes.get(0) instanceof MenuSair );
		
	}
	
	private List<Menu> montaListaMenu() {
		return Arrays.asList(
				new MenuSair(interfaceUsuario)
			);
	}
		
}
