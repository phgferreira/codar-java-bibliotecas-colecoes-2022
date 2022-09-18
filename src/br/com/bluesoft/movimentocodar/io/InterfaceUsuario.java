package br.com.bluesoft.movimentocodar.io;

import java.util.Scanner;

import br.com.bluesoft.movimentocodar.excecao.SemRespostaException;

public class InterfaceUsuario {
	
	private static Scanner SCANNER;

	private static void pegaDoUsuario() {
		SCANNER = new Scanner(System.in);
		if (!SCANNER.hasNext())
			throw new SemRespostaException("Sem resposta");
	}

	public static String pegaStringDoUsuario() {
		pegaDoUsuario();
		return SCANNER.next();
	}
	
	public static Integer pegaInteiroDoUsuario() {
		pegaDoUsuario();
		return SCANNER.nextInt();
	}
	
	private static void perguntaAoUsuario(String texto) {
		System.out.println(texto);
		SCANNER = new Scanner(System.in);
		if (!SCANNER.hasNext())
			throw new SemRespostaException("Sem resposta");
	}

	public static String perguntaAoUsuarioPegaString(String texto) {
		perguntaAoUsuario(texto);
		return SCANNER.next();
	}

	public static Integer perguntaAoUsuarioPegaInteiro(String texto) {
		perguntaAoUsuario(texto);
		return SCANNER.nextInt();
	}

	public static void close() {
		SCANNER.close();
	}
}
