/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabalhoAspectos;

import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class Tag {
    private ArrayList <String> expressoes = new ArrayList();
    private ArrayList <String> tag = new ArrayList();
    
    
    public void setExpressoes(String expressoes){
        if(setTag(expressoes)){
            this.expressoes.add(expressoes);
        }else{
            System.out.println("Expressao regular não válida(falta a TAG)");
        }
    }
    private boolean setTag(String expressoes){
        String tag = "";
        char [] elementos = expressoes.toCharArray();
        int i = 0;
        while(i < elementos.length && elementos[i] != ':'){
            tag = tag+elementos[i];
            i++;
        }
        if(i == elementos.length || elementos[i]!=':'){
            System.out.println("Não há o nome da TAG");
            return false;
        }else{
            this.tag.add(tag);
            return true;
        }
    }
    
    public void nomeTag(String expressao){
        String  nomesTag = "";
        char [] elementosER;
        char [] elementosEX = expressao.toCharArray();
        for(int i = 0 ; i < elementosEX.length ; i++){
            for(int j = 0 ; j < this.expressoes.size(); j ++){
                elementosER = this.expressoes.get(j).toCharArray();
                for(int k = 0 ; k < elementosER.length ; k++){
                    if(elementosER[k] == elementosEX[i]){
                        nomesTag = nomesTag+this.tag.get(j)+" ";
                    }
                }
            }
        }
        System.out.println(nomesTag);
    }
}
