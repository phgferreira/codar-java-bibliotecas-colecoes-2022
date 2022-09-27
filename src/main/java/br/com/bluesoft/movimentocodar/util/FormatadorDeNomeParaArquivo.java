package br.com.bluesoft.movimentocodar.util;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class FormatadorDeNomeParaArquivo {

	public String formata(String nome) {
        String nfdNormalizedString = Normalizer.normalize(nome, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("").toUpperCase();
	}

	
}
