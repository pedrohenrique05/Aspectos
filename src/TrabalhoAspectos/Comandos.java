package trabalhoaspectos;

import java.util.ArrayList;
import java.util.Scanner;

public class Comandos {
	
	public void escolheComando(){
		Scanner leitura = new Scanner(System.in);
                Scanner leituraER = new Scanner(System.in);
                System.out.println("Escolha o comando a ser usado: ");
		String comando = leitura.nextLine();
                String expressaoR = "";
                while(!":q".equals(comando)){
                    switch(comando) {
			case ":f":
				System.out.println("Informe o caminho do arquivo: ");
				String caminhoArq = leitura.nextLine();
				divisaoEmTagsArq(caminhoArq);
				break;
			case ":l":
				System.out.println("Informe o caminho do arquivo com as definicoes de tags: ");
				String caminhoTags = leitura.nextLine();
				definicoesDeTag(caminhoTags);
				break;
			case ":o":
				System.out.println("Caminho do arquivo de saida para divisao de tags: ");
				String caminhoSaida = leitura.nextLine();
				saidaArquivo(caminhoSaida);
				break;
			case ":p":
				System.out.println("Expressao: ");
				String expressao = leitura.nextLine();
				divisaoEmTags(expressao);
				break;
			
			case ":s":
				System.out.println("Informe o caminho do arquivo em que as tags serao salvas: ");
				String caminhoTags2 = leitura.nextLine();
				salvarTags(expressaoR,caminhoTags2);
				break;
			default:
                                expressaoR = comando;
				break;
                    }
                    comando = leitura.nextLine();
                }
		
		leitura.close();
	}
	
	private void salvarTags(String expressao, String caminhoTags) {
		ManipulaArq salvaTag = new ManipulaArq();
                if(expressao != ""){
                    salvaTag.setExpressao(expressao, caminhoTags);
                }
	}

	private void definicoesDeTag(String caminhoTags) {
		ArrayList <String> expressoes;
                ManipulaArq defTags = new ManipulaArq();
		expressoes = defTags.getExpressao(caminhoTags);
                for(int i = 0 ; i < expressoes.size() ; i++){
                    System.out.println(expressoes.get(i));
                }
	}

	public void saidaArquivo(String caminhoArq) {
		Arquivo defTags = new Arquivo();
		defTags.setExpressao("" ,caminhoArq, true);
	}
	
	public static void divisaoEmTagsArq(String caminhoArq) {
		
	}
	
	public void divisaoEmTags(String expressao) {
		
	}
}
