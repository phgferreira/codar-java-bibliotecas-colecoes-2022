package br.com.bluesoft.movimentocodar.io;

import java.util.Scanner;

import br.com.bluesoft.movimentocodar.excecao.SemRespostaException;

public class InterfaceUsuario {
	
	private static Scanner SCANNER = new Scanner(System.in);

	private static void checaResposta() {
		if (!SCANNER.hasNext())
			throw new SemRespostaException("Sem resposta");
	}

	public static String pegaStringDoUsuario() {
		checaResposta();
		return SCANNER.next();
	}
	
	public static Integer pegaInteiroDoUsuario() {
		checaResposta();
		return SCANNER.nextInt();
	}
	
	public static String perguntaAoUsuarioPegaString(String texto) {
		System.out.println(texto);
		checaResposta();
		return SCANNER.next();
	}

	public static Integer perguntaAoUsuarioPegaInteiro(String texto) {
		System.out.println(texto);
		checaResposta();
		return SCANNER.nextInt();
	}

	public static void close() {
		SCANNER.close();
	}
}
