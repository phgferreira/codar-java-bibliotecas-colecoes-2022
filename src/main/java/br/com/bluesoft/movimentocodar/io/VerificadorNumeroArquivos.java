package br.com.bluesoft.movimentocodar.io;

import java.io.File;
import java.util.Arrays;

public class VerificadorNumeroArquivos {
	
	private static Integer ULTIMO_NUMERO = 0;

	public static Integer getUltimoNumero(String caminhoFormularios) {
		verificaUltimoNumero(caminhoFormularios);
		return ULTIMO_NUMERO++;
	}
	
	private static void verificaUltimoNumero(String caminhoFormularios) {
		File arquivos[] = new File(caminhoFormularios).listFiles();
		Arrays.asList(arquivos).stream()
				/*
				 * Na 1ª execução ele varre toda a pasta mas nas próximas ele só verifica
				 * se tiver algum arquivo com número maior, o objetivo é otimizar o trabalho de consulta
				 */
				.filter( arquivo -> getNumeroArquivo(arquivo) > ULTIMO_NUMERO )
				.max( (arquivo1, arquivo2) -> getNumeroArquivo(arquivo1).compareTo( getNumeroArquivo(arquivo2) ))
				.ifPresent( arquivo -> ULTIMO_NUMERO = getNumeroArquivo(arquivo) );
	}
	
	private static Integer getNumeroArquivo(File arquivo) {
		return Integer.valueOf(arquivo.getName().split("-")[0]);
	}

}
