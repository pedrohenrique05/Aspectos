package TrabalhoAspectos;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
        ArrayList <String> expressoesCarregadas = new ArrayList();
        ArrayList <String> expressoesDigitadas = new ArrayList();
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
		System.out.println("[INFO] Escolha o comando a ser usado ");
		String comando = lerString();
                while(!":q".equals(comando)){
                    if(!":f".equals(comando) && !":l".equals(comando) && !":o".equals(comando) && !":p".equals(comando) && !":s".equals(comando))
				System.out.println("[WARNING] Comando invalido, tag definida");
                    switch(comando) {
			case ":f":
                                System.out.println("[ERRO] Operacao ainda nao inserida (PARTE 2 DO TRABALHO)");
				//divisaoEmTagsArq();
                                break;
			case ":l":
				definicoesDeTag();
				break;
			case ":o":
                                System.out.println("[ERRO] Operacao ainda nao inserida (PARTE 2 DO TRABALHO)");
                            	//saidaArquivo();
				break;
			case ":p":
                                System.out.println("[ERRO] Operacao ainda nao inserida (PARTE 2 DO TRABALHO)");
				//divisaoEmTags();
				break;
			
			case ":s":
				salvarTags();
				break;
			default:
                                this.expressoesDigitadas.add(comando);
				break;
                    }
                    System.out.println("[INFO] Escolha o comando a ser usado ");
                    comando = lerString();
                }
                System.out.println("[INFO] Encerrando execucao.");
        }
	/**
	 * Metodo que salva a tag que o usuario definiu em um arquivo .txt. (:s)
	 * @param tag - Tag que foi definida e sera salva.
	 * @param caminhoTags - Caminho do arquivo que sera salva a tag.
	 */
	private void salvarTags() {
                String caminhoTags = lerString();
		Arquivo salvaTag = new Arquivo();
                if(!this.expressoesDigitadas.isEmpty()){
                    for(int i = 0 ; i < this.expressoesDigitadas.size() ; i++){
                        if(!"".equals(this.expressoesDigitadas.get(i))){
                            salvaTag.setExpressao(this.expressoesDigitadas.get(i), caminhoTags);
                        }
                    }
                }
                this.expressoesDigitadas.clear();
	}
        /**
	 * Metodo que carrega definicoes de tags de um arquivo de escolha do usuario. (:l)
         * O metodo já vai informar automaticamente a validade de cada tag lida
	 * @return - Retorna as definicoes de tags.
	 */
	
	private ArrayList<String> definicoesDeTag() {
		String caminho = lerString();
                Arquivo defTags = new Arquivo();
		this.expressoesCarregadas = defTags.getExpressao(caminho);
                for(int i = 0 ; i < this.expressoesCarregadas.size() ; i++){
                    Regex er = new Regex(this.expressoesCarregadas.get(i));
                    er.validaExpressaoP();
                }
                return this.expressoesCarregadas;
	}
        /**
	 * Metodo que define a saida do arquivo (:o)
	 * @return - Retorna o caminho que o usuario informou.
	 */
	private String saidaArquivo() {
		String caminho = lerString();
		return caminho;
	}
	/**
	 * Metodo que realiza a divisao em tags da expressao contida no arquivo que o caminho foi
	 * passado por parametro. (:f)
	 * @param caminhoString - Caminho do arquivo que contem a expressao que sera dividida e avaliada.
	 */
	private static void divisaoEmTagsArq() {
                Scanner leitura = new Scanner(System.in);
                System.out.println("Informe o caminho do arquivo: ");
                String caminhoArq = leitura.nextLine();
                ArrayList <String> expressoes;
                Arquivo defTags = new Arquivo();
                expressoes = defTags.getExpressao(caminhoArq);
                for(int i = 0 ; i < expressoes.size() ; i++){
                    Regex er = new Regex(expressoes.get(i));
                    er.validaExpressaoP();
                }
                
                //ManipulaArq arq = new Arquivo();
		//String expressao = arq.getExpressao(caminhoString);
		//Regex er = new Regex(expressao);
	}
	/**
         * INCOMPLETO
	 * Metodo que realiza a divisao em tags da expressao que foi passada pelo usuario como parametro. (:p)
	 * @param expressao - Expressao que sera divida e avaliada.
	 */
	private void divisaoEmTags() {
            String expressao = lerString();
            Tag defineTag = new Tag();
            for (int i = 0 ; i < this.expressoesCarregadas.size() ; i++) {
                defineTag.setExpressoes(this.expressoesCarregadas.get(i));
            }
            defineTag.nomeTag(expressao);
                
	}
        /**
         * Metodo com objetivo apenas de ler string,
         * para qualquer metodo que precisar.
         * @return String com caminho informado pelo usuário.
         */
        private String lerString(){
            Scanner leitura = new Scanner(System.in);
            String caminho = leitura.next();
            return caminho;
        }
}
