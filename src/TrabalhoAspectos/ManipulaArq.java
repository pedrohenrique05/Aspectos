/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoaspectos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class ManipulaArq {
    
    public void setExpressao(String expressao, String caminhoArq){
     try{
        boolean validador = true;
        File arqCaminho = new File(caminhoArq);
        if(!arqCaminho.exists()){
             arqCaminho.createNewFile();
             validador = false;
        }
        FileWriter arq = new FileWriter(arqCaminho.getAbsoluteFile(),validador);
        BufferedWriter arqGravar = new BufferedWriter(arq);
        
        arqGravar.write(expressao+"\r");
        arqGravar.close();
    } catch(IOException e) {
        e.printStackTrace();
    }
     
    }
    
    public ArrayList getExpressao(String caminhoArq){
        ArrayList <String> expressoes = new ArrayList();
        try{
            int i = 0;
            FileReader entrada = new FileReader(caminhoArq);
            BufferedReader lerEntrada = new BufferedReader(entrada);
            String linha = lerEntrada.readLine();
            while(linha != null){
                expressoes.add(linha);
                linha = lerEntrada.readLine();
                i++;
            
            }
            entrada.close();
        }catch(IOException e){
            System.out.println("Erro ao abrir arquivo de entrada");
        }
        
        return expressoes;  
    }
}
