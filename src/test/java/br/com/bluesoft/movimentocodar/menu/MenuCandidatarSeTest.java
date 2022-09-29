package br.com.bluesoft.movimentocodar.menu;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;

class MenuCandidatarSeTest {
	
	private MenuCandidatarSe menu;

	@Mock
	private InterfaceUsuario interfaceUsuario;

	private static ByteArrayOutputStream console;

	@BeforeEach
	void beforeEach() {
		MockitoAnnotations.openMocks(this);
		menu = new MenuCandidatarSe(interfaceUsuario);
		System.setOut( new PrintStream( console ) );
	}
	
	@Test
	void deveAbrirMenu() {
		
		menu.abreMenu();
		
		console.toString();
		
	}

}
