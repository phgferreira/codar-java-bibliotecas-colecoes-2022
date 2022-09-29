package br.com.bluesoft.movimentocodar.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GravadorFormularioCandidato {

	private BufferedWriter escritor;
	
	public GravadorFormularioCandidato(String urlNovoCandidato) throws IOException {
		escritor = new BufferedWriter(new FileWriter(urlNovoCandidato));
	}
	
	public void gravaLinha(String linha) throws IOException {
		escritor.write(linha);
		escritor.newLine();
	}
	
	public void close() throws IOException {
		escritor.close();
	}
}
