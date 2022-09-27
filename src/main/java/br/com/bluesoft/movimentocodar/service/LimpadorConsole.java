package br.com.bluesoft.movimentocodar.service;

public class LimpadorConsole {

	/**
	 * Código copiado
	 * Fonte: https://www.delftstack.com/howto/java/java-clear-console/#:~:text=To%20clear%20the%20console%20in,command%20to%20clean%20the%20console.
	 */
	public void limpar() {
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
              
            if(operatingSystem.contains("Windows")){        
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            } 
        }catch(Exception e){
            System.out.println(e);
        }		
	}
}
