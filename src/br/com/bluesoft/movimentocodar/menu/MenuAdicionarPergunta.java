package br.com.bluesoft.movimentocodar.menu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MenuAdicionarPergunta implements Menu {

	@Override
	public String getTitulo() {
		return "Adicionar pergunta ao formulário";
	}

	@Override
	public void abreMenu() {
		System.out.println(">>> " + this.getTitulo() + " <<<");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Qual pergunta gostaria de adicionar no formulário?");
		String pergunta = scanner.next();
		//scanner.close();

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("formulario.txt"));
			writer.append(pergunta);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
