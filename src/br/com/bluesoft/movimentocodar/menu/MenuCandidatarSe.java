package br.com.bluesoft.movimentocodar.menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MenuCandidatarSe implements Menu {

	@Override
	public String getTitulo() {
		return "Candidatar-se";
	}

	@Override
	public void abreMenu() {
		System.out.println(">>> " + this.getTitulo() + " <<<");
		
		try {
			Scanner scanner = new Scanner( new File("formulario.txt") );
			scanner.useDelimiter("\\|");
			while (scanner.hasNext())
				System.out.println(scanner.next());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
