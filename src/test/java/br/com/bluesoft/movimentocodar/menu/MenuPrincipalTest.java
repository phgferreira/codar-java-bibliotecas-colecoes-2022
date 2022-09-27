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
	
	private static ByteArrayOutputStream telaNormal;
	private static ByteArrayOutputStream telaErro;
	
	@BeforeAll
	static void beforeAll() {
		telaNormal = new ByteArrayOutputStream();
		System.setOut( new PrintStream(telaNormal) );
		
		telaErro = new ByteArrayOutputStream();
		System.setErr( new PrintStream(telaErro) );
	}
	
	@AfterAll
	static void afterAll() {
		try {
			telaNormal.close();
			telaErro.close();
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
			// Para saber se o índice escolhido foi válido deve imprimir no final 'Abriu menu de teste'
			Mockito.when(interfaceUsuario.getRespostaEmInteiro()).thenReturn(2);
		} catch (NumberFormatException | IOException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
		// Elemento teste
		menuPrincipal.abreMenu();
		
		assertEquals( exibidoEmTelaQuandoEscolhidoCorretamente(), telaNormal.toString() );
		
	}
	
	void deveExibirErroQuandoUsuarioEscolherOpcaoErrada() {
		try {
			// Para saber se o índice escolhido foi válido deve imprimir no final 'Abriu menu de teste'
			Mockito.when(interfaceUsuario.getRespostaEmInteiro()).thenReturn(2);
		} catch (NumberFormatException | IOException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
		// Elemento teste
		menuPrincipal.abreMenu();
		
		assertEquals( exibeEmTelaQuandoEscolhidoOpcaoInvalida(), telaErro.toString() );
	}
	
	private String exibidoEmTelaQuandoEscolhidoCorretamente() {
		return	"### Menu Principal ###" + System.lineSeparator()
				+ "0 - Menu de Teste" + System.lineSeparator()
				+ "1 - Menu de Teste" + System.lineSeparator()
				+ "2 - Menu de Teste" + System.lineSeparator()
				+ "3 - Menu de Teste" + System.lineSeparator()
				+ "4 - Menu de Teste" + System.lineSeparator()
				+ "Abriu menu de teste" + System.lineSeparator();
	}
	
	private String exibeEmTelaQuandoEscolhidoOpcaoInvalida() {
		return  "Escolha apenas as opções numéricas existentes no menu" + System.lineSeparator()
				+ "Por favor tente novamente" + System.lineSeparator();
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
