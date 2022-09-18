package br.com.bluesoft.movimentocodar.util;

import br.com.bluesoft.movimentocodar.excecao.IdadeNaoPermitidaException;

public class VerificadorDeIdade {

	public void verificaIdade(Integer idade) throws IdadeNaoPermitidaException {
		if (idade < 16)
			throw new IdadeNaoPermitidaException("Desculpa, você é muito jovem e a idade permita é de no mínimo 16 anos");
	}
}
