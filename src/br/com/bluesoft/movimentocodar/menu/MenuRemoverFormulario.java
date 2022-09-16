package br.com.bluesoft.movimentocodar.menu;

public class MenuRemoverFormulario implements Menu {

	@Override
	public String getTitulo() {
		return "Remover pergunta do formulário";
	}

	@Override
	public void abreMenu() {
		System.out.println(">>> " + this.getTitulo() + " <<<");
	}

}
