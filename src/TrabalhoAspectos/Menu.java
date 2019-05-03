package trabalhoaspectos;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	/**
	 * Menu que contem as definicoes de cada comando que o usuario pode utilizar.
	 * :f - Realiza a divisao em tags da string do arquivo informado atraves do metodo: divisaoEmTagsArq.
	 * :l - Carrega um arquivo com definicoes de tags atraves do metodo: definicoesTags.
	 * :o - Especifica o caminho do arquivo de saida para a divisao em tags atraves do metodo: saidaArquivo.
	 * :p - Realiza a divisao em tags da entrada informada atraves do metodo: divisaoEmTags
	 * :q - Sair do programa.
	 * :s - Salvar as tags.
	 */
	
	public void menu(){
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
	/**
	 * Metodo que salva a tag que o usuario definiu em um arquivo .txt. (:s)
	 * @param tag - Tag que foi definida e sera salva.
	 * @param caminhoTags - Caminho do arquivo que sera salva a tag.
	 */
	private void salvarTags(String expressao, String caminhoTags) {
		ManipulaArq salvaTag = new ManipulaArq();
                if(expressao != ""){
                    salvaTag.setExpressao(expressao, caminhoTags);
                }
	}
        /**
	 * Metodo que carrega definicoes de tags de um arquivo de escolha do usuario. (:l)
	 * @param caminhoTags - Caminho do arquivo com as definicoes de tags.
	 * @return - Retorna as definicoes de tags.
	 */
	
	private ArrayList<String> definicoesDeTag(String caminhoTags) {
		ArrayList <String> expressoes;
                ManipulaArq defTags = new ManipulaArq();
		expressoes = defTags.getExpressao(caminhoTags);
                System.out.println(expressoes.toString());
                for(int i = 0 ; i < expressoes.size() ; i++){
                    System.out.println(expressoes.get(i));
                }
                return expressoes;
	}
        /**
	 * Metodo que define a saida do arquivo (:o)
	 * @return - Retorna o caminho que o usuario informou.
	 */
	private String saidaArquivo(String caminhoArq) {
		Scanner leitura = new Scanner(System.in);
		String caminho = leitura.next();
		leitura.close();
		return caminho;
	}
	/**
	 * Metodo que realiza a divisao em tags da expressao contida no arquivo que o caminho foi
	 * passado por parametro. (:f)
	 * @param caminhoString - Caminho do arquivo que contem a expressao que sera dividida e avaliada.
	 */
	private static void divisaoEmTagsArq(String caminhoArq) {
		
	}
	/**
	 * Metodo que realiza a divisao em tags da expressao que foi passada pelo usuario como parametro. (:p)
	 * @param expressao - Expressao que sera divida e avaliada.
	 */
	private void divisaoEmTags(String expressao) {
		
	}
}
