package br.com.bluesoft.movimentocodar.menu;

import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;

public class MenuAdicionarPergunta extends Menu {

	public MenuAdicionarPergunta(InterfaceUsuario interfaceUsuario) {
		super(interfaceUsuario);
	}

	@Override
	public String getTitulo() {
		return "Adicionar pergunta ao formulário";
	}

	@Override
	public void abreMenu() {
		System.out.println(">>> " + this.getTitulo() + " <<<");
		
//		try {
//			String pergunta = new InterfaceUsuario().perguntaAoUsuario("Qual pergunta gostaria de adicionar no formulário?");
//
//			List<PerguntaComResposta> teste = new FormularioPerguntas().getSomentePerguntasEmLista();
//			BufferedWriter writer = new BufferedWriter(new FileWriter("formulario.txt"));
//			//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}
