package trabalhoaspectos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Pedro
 */
public class Arquivo {
    
    public void setExpressao(String expressao, String caminhoArq, boolean validador){
	    try{
	        File arqCaminho = new File(caminhoArq);
	        if(!arqCaminho.exists()){
	             arqCaminho.createNewFile();
	        }
	        FileWriter arq = new FileWriter(arqCaminho.getAbsoluteFile(),validador);
	        BufferedWriter arqGravar = new BufferedWriter(arq);
	        
	        arqGravar.write(expressao);
	        arqGravar.close();
	    } catch(IOException e) {
	        e.printStackTrace();
	    }
	     
	}
	    
    public String getExpressao(String caminhoArq){
            String conteudo = "";
            try{
                FileReader arq = new FileReader(caminhoArq);
                BufferedReader lerArq = new BufferedReader(arq);
                String linha = "";
                try{
                    linha = lerArq.readLine();
                    while(linha != null){
                        conteudo += linha;
                        linha = lerArq.readLine();
                    }
                    arq.close();
                    return conteudo;
                } catch (IOException ex) {
                    System.out.println("IO Erro: \n" + ex.getMessage());
                    return "erro";
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Arquivo nao encontrado");
                return "erro";
            }
        }
}