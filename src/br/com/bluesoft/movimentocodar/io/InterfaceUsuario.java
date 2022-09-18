package br.com.bluesoft.movimentocodar.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterfaceUsuario {
	
	private BufferedReader reader;
	
	public InterfaceUsuario() {
		reader = new BufferedReader( new InputStreamReader(System.in) );
	}
	
	public String pegaResposta() throws IOException {
		return reader.readLine();
	}
	
	public Integer pegaRespostaEmInteiro() throws NumberFormatException, IOException {
		return Integer.parseInt(reader.readLine());
	}
	
	public String perguntaAoUsuario(String texto) throws IOException {
		System.out.println(texto);
		return reader.readLine();
	}

	public void close() throws IOException {
		reader.close();
	}
}
