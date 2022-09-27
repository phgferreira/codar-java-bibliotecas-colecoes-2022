package br.com.bluesoft.movimentocodar.util;

import java.util.stream.IntStream;

public class DivisorDeLinha {
	
	public static String DELIMITADOR_PADRAO = "|";
	
	public static String[] getValoresDividios(String texto) {
		return texto.split("\\" + DELIMITADOR_PADRAO);
	}
	
	public static String getValoresUnidos(String...values) {
		StringBuffer texto = new StringBuffer(values[0]);
		IntStream.range(1, values.length).forEach( valor -> texto.append(DELIMITADOR_PADRAO + valor) );
		return texto.toString();
	}
}
