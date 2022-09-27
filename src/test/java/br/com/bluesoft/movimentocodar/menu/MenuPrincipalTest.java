package br.com.bluesoft.movimentocodar.menu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;
import br.com.bluesoft.movimentocodar.modelo.MenuTest;

class MenuPrincipalTest {

	private MenuPrincipal menuPrincipal;

	@Mock
	private InterfaceUsuario interfaceUsuario;
	
	@Mock
	private MenuTest menuTest;
	
	private static ByteArrayOutputStream tela;
	
	@BeforeAll
	static void beforeAll() {
		tela = new ByteArrayOutputStream();
		System.setOut( new PrintStream(tela) );
	}
	
	@AfterAll
	static void afterAll() {
		try {
			tela.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeEach
	void beforeEach() {
		MockitoAnnotations.openMocks(this);
		menuPrincipal = new MenuPrincipal(interfaceUsuario, montaListaMenu());
	}
	
	@Test
	void deveExibirMenuEPegarEscolhaDoUsuarioComOpcaoValida() {
		try {
			Mockito.when(interfaceUsuario.getRespostaEmInteiro()).thenReturn(2);
		} catch (NumberFormatException | IOException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
		// Elemento teste
		menuPrincipal.abreMenu();
		
		assertEquals( exibidoEmTela(), tela.toString() );
		
	}
	
	private String exibidoEmTela() {
		return	"### Menu Principal ###" + System.lineSeparator()
				+ "0 - Menu de Teste" + System.lineSeparator()
				+ "1 - Menu de Teste" + System.lineSeparator()
				+ "2 - Menu de Teste" + System.lineSeparator()
				+ "3 - Menu de Teste" + System.lineSeparator()
				+ "4 - Menu de Teste" + System.lineSeparator()
				+ "Abriu menu de teste" + System.lineSeparator();
	}
	
	private List<Menu> montaListaMenu() {
		return Arrays.asList(
				new MenuTest(),
				new MenuTest(),
				new MenuTest(),
				new MenuTest(),
				new MenuTest()
			);
	}
		
}
