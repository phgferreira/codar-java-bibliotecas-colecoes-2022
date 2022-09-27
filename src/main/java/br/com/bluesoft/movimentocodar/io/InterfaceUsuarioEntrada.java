package br.com.bluesoft.movimentocodar.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterfaceUsuarioEntrada {
	
	private BufferedReader reader;
	
	public InterfaceUsuarioEntrada() {
		reader = new BufferedReader( new InputStreamReader( System.in ));
	}
	
	public String getResposta() throws IOException {
		return reader.readLine();
	}
	
	public Integer getRespostaEmInteiro() throws NumberFormatException, IOException {
		return Integer.parseInt( reader.readLine() );
	}
	
	public String perguntaAoUsuario(String texto) throws IOException {
		System.out.println(texto);
		return reader.readLine();
	}

	public void close() throws IOException {
		reader.close();
	}
}
