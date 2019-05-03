package trabalhoaspectos;

import java.util.Stack;

public class ExpressoesRegulares {
	
	private String expressao;
	private char [] valores;
	
	public ExpressoesRegulares(String expressao){	
		this.expressao = expressao;
	}
	
	
	public void separaString() {
		this.valores = expressao.toCharArray();
	}
	
	
	public void validaExpressao() {
		 Stack<String> pilha = new Stack<String>();
		 Stack<String> pilhaAux = new Stack<String>();
		 String comparacao;
		 String fechoKleene;
		 String expressaoFinal = "";	

		 
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
		


		while(!pilha.empty()) {
			expressaoFinal += ""+pilha.pop();
		}
		
		pilha.push(expressaoFinal);
		System.out.println("Expressao final: " + pilha.toString());
	}


	
	
}
