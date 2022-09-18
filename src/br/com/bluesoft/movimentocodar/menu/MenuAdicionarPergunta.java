package br.com.bluesoft.movimentocodar.menu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;

public class MenuAdicionarPergunta implements Menu {

	@Override
	public String getTitulo() {
		return "Adicionar pergunta ao formulário";
	}

	@Override
	public void abreMenu() {
		System.out.println(">>> " + this.getTitulo() + " <<<");
		
		String pergunta = InterfaceUsuario.perguntaAoUsuarioPegaString("Qual pergunta gostaria de adicionar no formulário?");
		
		Scanner scannerFormulario = new Scanner( new File("formulario") );
		

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("formulario.txt"));
			writer.;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
