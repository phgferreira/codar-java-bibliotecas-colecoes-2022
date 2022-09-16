package br.com.bluesoft.movimentocodar.menu;

public class MenuAdicionarPergunta implements Menu {

	@Override
	public String getTitulo() {
		return "Adicionar pergunta ao formulário";
	}

	@Override
	public void abreMenu() {
		System.out.println(">>> " + this.getTitulo() + " <<<");
	}

}
