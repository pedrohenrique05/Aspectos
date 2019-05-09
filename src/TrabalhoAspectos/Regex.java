/*
 * Trabalho de Aspectos Te�ricos da Computa��o
  
 * Grupo:
 * Juarez de Paula Campos Junior - 201676022
 * Leonardo Silva da Cunha - 201676019
 * Pedro Henrique Delgado Moura - 201776032
 */
package TrabalhoAspectos;

import java.util.EmptyStackException;
import java.util.Stack;

public class Regex {
	
	private String expressao;
	private char [] valores;
	private int indiceExpressao;
	
	/**
	 * Construtor da classe que recebe a expressao como parametro.
	 * @param expressao - Expressao que sera utilizada nos metodos.
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
	
	/**
	 * Metodo que verifica se a tag inserida antes da expressao regular eh valida ou nao.
	 * O metodo percorre o array de caracteres ate encontrar o caracter ":".
	 * Caso o array comece com espaco ou direto com ":", a tag eh invalida.
	 * Caso o array nao contenha ":", a tag eh invalida.
	 * Caso o array nao possua um espaco apos ":", a tag eh invalida.
	 * Se todos os casos acima nao aconteceram a tag eh valida. 
	 * @return true se a tag eh valida, false se nao.
	 */
	public boolean validaTag() {
		Stack<String> pilhaTag = new Stack<String>();
		int i = 0;  
		int j = i+1;
                //nome:
		//5
                //i = 0-n, 1-o, 2-m, 3-e, 4-:
                //j = 1-o, 2-m, 3-e, 4-:, 5
		if(this.valores[0] != ':' && this.valores[0] != ' ') {
			String nomeDaTag = "";
			while(i < this.valores.length) {
				if(this.valores[i] == ':') 
					 if(j != this.valores.length && this.valores[j] == ' ') {
						 nomeDaTag += String.valueOf(this.valores[i]);
						 break;
					 }
					 else {
						 System.out.println("[ERRO] Expressao sem espaco apos ':'");
						 return false;
					 }
				nomeDaTag += String.valueOf(this.valores[i]);
				i++;
				j++;
			}
			if(!nomeDaTag.contains(":")) {
				System.out.println("[ERRO] Tag nao informada.");
				return false;
			}
			pilhaTag.push(nomeDaTag);
		}
		else {
			System.out.println("[ERRO] Nome de tag invalido.");
			return false;
		}
		
		indiceExpressao = i;
		System.out.println("[INFO] Tag valida. ");
		return true;
		
	}

	/**
	 * Metodo que verifica se a expressao regular em notacao polonesa reversa passada no construtor da classe eh valida.
	 * O metodo separa a String em caracteres, percorre cada caracter ate achar um operador (. + ou *).
	 * Quando eh encontrado o operador utiliza uma pilha auxiliar para efetuar a concatenacao dos elementos com os operadores,
	 * apos a concatenacao os elementos concatenados sao empilhados novamente na pilha principal.
	 * @return true se a expressao foi valida ou false se a expressao eh invalida.
	 */
	public boolean validaExpressaoRegular() {
		Stack<String> pilha = new Stack<String>();
		Stack<String> pilhaAux = new Stack<String>();
		String comparacao;
		String fechoKleene;
		String concatenacao;
		
		int i = indiceExpressao+2;
		if(i >= this.valores.length){
                    System.out.println("[WARNING] Expressao regular invalida.");
                    return false;
                }else
		try { 
			do {
				if(this.valores[i] == '+') {
					pilhaAux.push(pilha.pop());
					pilhaAux.push(pilha.pop());
					comparacao = pilhaAux.pop() + this.valores[i] + pilhaAux.pop();
					pilha.push(comparacao);
					i++;
				}
				else
					if(this.valores[i] == '*') {	
						pilhaAux.push(pilha.pop());
						fechoKleene =  pilhaAux.pop() + this.valores[i];
						pilha.push(fechoKleene);
						i++;
					}
					else
						if(this.valores[i] == '.') {
							pilhaAux.push(pilha.pop());
							pilhaAux.push(pilha.pop());
							concatenacao = ""+pilhaAux.pop() +  pilhaAux.pop();
							pilha.push(concatenacao);
							i++;
						}
						else {
							pilha.push(String.valueOf(this.valores[i]));
							i++;
						}
			}
			while(i < this.valores.length);
			
			if(pilha.size() == 1 && !pilha.contains(" ")) {
				System.out.println("[INFO] Expressao regular valida.");
				return true;
			}
			else { 
				System.out.println("[WARNING] Expressao regular invalida.");
				return false;
			}
		
		}
		catch(EmptyStackException e){
			System.out.println("[ERRO] Existem mais operadores do que simbolos na expressao.");
			return false;
		}
                
                
	}
	
	
	/**
	 * Se a tag for valida assim como a expressao regular, entao a expressao completa eh valida.
	 * @return true se expressao eh valida, false se nao.
	 */
	public boolean validaExpressao() {
		separaString();
		if(this.valores.length < 4) {
			System.out.println("[ERRO] A expressao inserida nao contem valores suficientes.");
			return false;
		}
		
		if(validaTag() && validaExpressaoRegular())
			return true;
		else
			return false;
	}
}
