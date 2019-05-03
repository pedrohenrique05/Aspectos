package trabalhoaspectos;

import java.util.Scanner;

public class Main {
    
	public static void main(String[] args) {
		//Arquivo arq = new Arquivo();
		//Comandos c1 = new Comandos();
		//Scanner leitura = new Scanner(System.in);
		
		//System.out.println("Expressao a ser escrita no arquivo: ");
		//String expressao = leitura.nextLine();
		
		//arq.setExpressao(expressao , "teste.txt", false);
		
		//c1.escolheComando();

		//System.out.println(arq.getExpressao("teste.txt"));
		/*
		
		ExpressoesRegulares regex = new ExpressoesRegulares("aba++*aa*bb+ab");
		regex.separaString();
		regex.validaExpressao();
                
                */
                
                Comandos cmd = new Comandos();
		cmd.escolheComando();
		//leitura.close();
	}

}
