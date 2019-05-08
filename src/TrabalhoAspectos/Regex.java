/*
 * Trabalho de Aspectos Te�ricos da Computa��o
  
 * Grupo:
 * Juarez de Paula Campos Junior - 201676022
 * Leonardo Silva da Cunha - 201676019
 * Pedro Henrique Delgado Moura - 201776032
 */
package TrabalhoAspectos;

import java.util.Stack;

public class Regex {
	
	private String expressao;
	private char [] valores;
	
	/**
	 * Construtor da classe.
	 * @param expressao - Expressao regular que sera utilizada nos metodos.
	 */
	public Regex(String expressao){	
		this.expressao = expressao;
	}
	
	/**
	 * Metodo que transforma uma string em um array de char.
	 */
	public void separaString() {
		this.valores = expressao.toCharArray();
	}
	public boolean validaExpressaoP(){
            separaString();
            Stack<String> pilha = new Stack<String>();
            Stack<String> pilhaAux = new Stack<String>();
            String comparacao;
            String fechoKleene;
            String concatena;
            String nomeTag = "";
            boolean validador = false;
            int i = 0;
            while(i < this.valores.length){
                if(this.valores[i] == ':'){
                    validador = true;
                    nomeTag = nomeTag+ String.valueOf(this.valores[i]);
                    break;
                }
                nomeTag = nomeTag+ String.valueOf(this.valores[i]);
                i++;
            }
            i++;
            if(validador){
                do{
                
                    switch (this.valores[i]) {
                    case '+':
                        if(pilha.size()>=2){
                            pilhaAux.push(pilha.pop());
                            pilhaAux.push(pilha.pop());
                            comparacao = "("+pilhaAux.pop()+"+"+pilhaAux.pop()+")";
                            pilha.push(comparacao);
                            i++;
                        }else{
                            pilha.push("+");
                            i = this.valores.length+1;
                        }   
                        break;
                    case '.':
                        if(pilha.size()>=2){
                            pilhaAux.push(pilha.pop());
                            pilhaAux.push(pilha.pop());
                            concatena = pilhaAux.pop()+"."+pilhaAux.pop();
                            pilha.push(concatena);
                            i++;
                        }else{
                            pilha.push(".");
                            i = this.valores.length+1;
                        }
                        break;
                    case '*':
                        if(!pilha.empty()){
                            pilhaAux.push(pilha.pop());
                            fechoKleene = "("+pilhaAux.pop()+"*)";
                            pilha.push(fechoKleene);
                            i++;
                        }else{
                            pilha.push("*");
                            i = this.valores.length+1;
                        }   break;
                    default:
                        pilha.push(String.valueOf(this.valores[i]));
                        i++;
                        break;
                    }
                }while(i < this.valores.length);
            }
            
            
            System.out.println(nomeTag+" "+pilha.toString());
            int tamPilha = -1;
            String strPilhaTopo = "" ;
            if(!pilha.empty()){
                tamPilha = pilha.size();
                strPilhaTopo = pilha.pop();
            }
            
            if(tamPilha == 1 && !"*".equals(strPilhaTopo) && !"+".equals(strPilhaTopo) && !".".equals(strPilhaTopo)){
                System.out.println("Válido");
                return true;
            }else{
                System.out.println("Não válido");
                return false;
            }
            
            //C:\\Users\\pedro\\Desktop\\Aspectos\\TrabalhoAspectos\\src\\TrabalhoAspectos\\teste.txt
        }
	/**
	 * Metodo para verificar se a expressao regular eh valida ou nao.
	 * Utiliza uma pilha para valores que serao concatenados e uma pilha auxiliar para que seja possivel
	 * fazer a concatenacao de valores que estao sendo comparados por (+) ou que tem fecho de Kleene (*)
	 * com esses simbolos.
	 * Por fim, pega os valores da pilha que ainda nao foram concatenados e faz a concatenacao para que
	 * a pilha possua tamanho = 1.
	 * @return true se a expressao foi valida ou false se a expressao eh invalida.
	 */
	public boolean validaExpressao() {
		 separaString();
		 Stack<String> pilha = new Stack<String>();
		 Stack<String> pilhaAux = new Stack<String>();
		 String comparacao;
		 String fechoKleene;
		 String concatena = "";

		 
		int i = 0;

		do {
			if(this.valores[i] == '+') {
				pilhaAux.push(pilha.pop());
				pilhaAux.push(pilha.pop());
				comparacao = "(" + pilhaAux.pop() + this.valores[i] + pilhaAux.pop() + ")";
				pilha.push(comparacao);
				i++;
			}
			if(this.valores[i] == '*') {	
				pilhaAux.push(pilha.pop());
				fechoKleene = "" + pilhaAux.pop() + this.valores[i];
				pilha.push(fechoKleene);
				i++;
			}
			if(this.valores[i] != '+' && this.valores[i] != '*') {
				pilha.push(String.valueOf(this.valores[i]));
				i++;
			}
		}
		while(i < this.valores.length);

		while(!pilha.isEmpty()) 
			concatena += pilha.pop();
		
		pilha.push(concatena);
		
		System.out.println("Expressao final: " + pilha.toString());
		
		if(pilha.size() == 1)
			return true;
		else 
			return false;
	}


	
	
}
