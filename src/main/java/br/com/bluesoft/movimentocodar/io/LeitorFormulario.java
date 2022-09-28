package br.com.bluesoft.movimentocodar.io;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeitorFormulario {

	private String urlFormulario;
	
	private Scanner leitor;
	
	public LeitorFormulario() throws FileNotFoundException {
		urlFormulario = "formulario.txt";
		leitor = new Scanner(urlFormulario);
	}
	
	public String proximaLinha() {
		return leitor.nextLine();
	}
	
	public Boolean temProximo() {
		return leitor.hasNext();
	}
	
	public void close() {
		leitor.close();
	}
}
