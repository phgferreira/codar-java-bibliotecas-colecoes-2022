package br.com.bluesoft.movimentocodar.menu;

import java.io.IOException;
import java.util.Set;

import br.com.bluesoft.movimentocodar.io.FormulariosCandidato;
import br.com.bluesoft.movimentocodar.io.InterfaceUsuario;

public class MenuValidarFormularios extends Menu {

	public MenuValidarFormularios(InterfaceUsuario interfaceUsuario) {
		super(interfaceUsuario);
	}

	@Override
	public String getTitulo() {
		return "Validar formulários";
	}

	@Override
	public void abreMenu() {
		System.out.println(">>> " + this.getTitulo() + " <<<");
		
		try {
			Set<String> duplicados = new FormulariosCandidato().getFormulariosDuplicados();
			duplicados.forEach( nomeEmail -> {
				String valores[] = nomeEmail.split("\\|");
				System.out.println(valores[0] + " (" + valores[1] + ")");
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
