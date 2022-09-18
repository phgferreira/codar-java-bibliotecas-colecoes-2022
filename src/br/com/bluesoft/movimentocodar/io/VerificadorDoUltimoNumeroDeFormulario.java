package br.com.bluesoft.movimentocodar.io;

import java.io.File;
import java.io.IOException;

public class VerificadorDoUltimoNumeroDeFormulario {

	/**
	 * O motivo de usar esse método toda vez que inicia um cadastro, o que é mais trabalhoso,
	 * é porque tive a visão dele poder ser utilizado em várias máquinas que podem trabalhar
	 * em um mesmo diretório de dados simultâneamente. Mas se for melhor posso mudar para um
	 * simples contador
	 * @return
	 * @throws IOException
	 */
	public static String verifica(String caminhoFormularios) {
		File arquivos[] = new File(caminhoFormularios).listFiles();

		Integer maiorNumeroEncontrado = 0;
		for (File arquivo : arquivos) {
			// Pega o nome do arquivo porque no próximo código ele será usado duas vezes
			String nomeArquivo = arquivo.getName();
			// Converte para inteiro
			Integer novoNumero = Integer.parseInt(nomeArquivo.substring(0, nomeArquivo.indexOf("-")));
			// Verifica se é o maior até o momento
			if (novoNumero >= maiorNumeroEncontrado)
				maiorNumeroEncontrado = novoNumero;
		}
		
		return maiorNumeroEncontrado;
	}

}
