package br.com.bluesoft.movimentocodar.menu;

import java.util.Optional;
import java.util.Scanner;

import br.com.bluesoft.movimentocodar.excecao.SemRespostaException;

public class InterfaceUsuario {
	
	private static Scanner SCANNER;

	private static void perguntaAoUsuario(Optional<String> texto) throws SemRespostaException {
		if (!texto.isEmpty())
			System.out.println(texto);
		SCANNER = new Scanner(System.in);
		if (!SCANNER.hasNext())
			throw new SemRespostaException("Sem resposta");
	}
	
	public static String perguntaAoUsuarioPegaString(Optional<String> texto) throws SemRespostaException {
		perguntaAoUsuario(texto);
		return SCANNER.next();
	}

	public static Integer perguntaAoUsuarioPegaInteiro(Optional<String> texto) throws SemRespostaException {
		perguntaAoUsuario(texto);
		return SCANNER.nextInt();
	}

	public void close() {
		SCANNER.close();
	}
}
