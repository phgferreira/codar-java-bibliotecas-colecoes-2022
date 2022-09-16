package br.com.bluesoft.movimentocodar;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		while(true) {
			try {
				new MenuPrincipal();
				Scanner reader = new Scanner(new InputStreamReader(System.in));
				int opcao = reader.nextInt();
//				System.out.println(opcao);
			} catch (RuntimeException e) {
				System.err.println("Escolha apenas as opções numéricas existentes no menu"
						+ System.lineSeparator() 
						+ "Tente novamente");
			}
		}
	}

}
