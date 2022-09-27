package br.com.bluesoft.movimentocodar.menu;

import java.io.FileNotFoundException;

import br.com.bluesoft.movimentocodar.io.FormularioPerguntas;
import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;

public class MenuRemoverFormulario extends Menu {

	private FormularioPerguntas formularioPerguntas;
	
	public MenuRemoverFormulario(InterfaceUsuario interfaceUsuario) {
		super(interfaceUsuario);
	}

	@Override
	public String getTitulo() {
		return "Remover pergunta do formulário";
	}

	@Override
	public void abreMenu() {
		System.out.println(">>> " + this.getTitulo() + " <<<");
		
		try {
			formularioPerguntas = new FormularioPerguntas();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
//			Map<String, Pergunta> perguntas = formularioPerguntas.getPerguntasEmMapa();
//			perguntas.forEach( (idPergunta, pergunta) -> System.out.println("ID: " + idPergunta + " => " + pergunta.getPergunta()) );
//			
//			String idPerguntaParaRemover = interfaceUsuario.perguntaAoUsuario("Qual pergunta gostaria de remover? (use o ID)");
//			if (Arrays.asList("P1","P2","P3","P4").contains(idPerguntaParaRemover))
//				throw new PerguntaImpedidaDeSerRemovidaException("Pergunta '" + perguntas.get(idPerguntaParaRemover).getPergunta() + "' não pode ser removida");
//
//			perguntas.remove(idPerguntaParaRemover);
//		
//			formularioPerguntas.atualizaPerguntas( new ArrayList<Pergunta>(perguntas.values()) );
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (PerguntaImpedidaDeSerRemovidaException e) {
//			System.err.println(e.getMessage());
//		}
	}

}
