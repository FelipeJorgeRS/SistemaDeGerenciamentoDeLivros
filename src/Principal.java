import java.util.Scanner;


public class Principal {
	
   

    public static void main(String[] args) throws Exception {
    	String csvFile = "C:\\Users\\Felipe Jorge\\eclipse-workspace\\SistemaDeGerenciamentoDeLivros\\CADASTRO-100-LIVROS.csv";
    	Lista livros = new Lista();
    	livros.insereLivroCSV(csvFile);

        Scanner leitor = new Scanner(System.in);

        boolean continuar = true;
        while (continuar) {
            System.out.println("Escolha uma op��o:");
            System.out.println("1. Consultar um livro por t�tulo");
            System.out.println("2. Consultar um livro por autor");
            System.out.println("3. Inserir um novo livro");
            System.out.println("4. Remover um livro");
            System.out.println("5. Ordenar livros por t�tulo");
            System.out.println("6. Ordenar livros por autor");
            System.out.println("7. Sair");
            int opcao = leitor.nextInt();
            leitor.nextLine();  // consome a linha restante

            switch (opcao) {
                case 1:
                    // Consulta um livro por t�tulo
                    System.out.println("Digite o t�tulo do livro que deseja consultar:");
                    String tituloConsulta = leitor.nextLine();
                    String livroTitulo = livros.consultaPorTitulo(tituloConsulta);
                    if (livroTitulo != null) {
                        System.out.println(livroTitulo);
                    } else {
                        System.out.println("Livro n�o encontrado.");
                    }
                    break;
                case 2:
                    // Consulta um livro por autor
                    System.out.println("Digite o autor do livro que deseja consultar:");
                    String autorConsulta = leitor.nextLine();
                    String resultado = livros.consultaPorAutor(autorConsulta);
                    System.out.println(resultado);
                    break;
                case 3:
                    // Insere um novo livro
                    Livro novoLivro = livros.insere();
                    break;
                case 4:
                    // Remove um livro
                    System.out.println("Digite o t�tulo do livro que deseja remover:");
                    String titulo = leitor.nextLine();
                    String mensagem = livros.retiraPorTitulo(titulo);
                    System.out.println(mensagem);
                    break;
                case 5:
                    // Ordena livros por t�tulo
                    livros.ordenaPorTitulo();
                    break;
                case 6:
                    // Ordena livros por autor
                    livros.ordenaPorAutor();
                    break;
                case 7:
                    continuar = false;
                    break;
                default:
                    System.out.println("Op��o inv�lida. Tente novamente.");
            }
        }
// PAREI FAZENDO A CONFIGURA��O DO M�TOD BUBLESORT PARA PERMITIR A ORDENA��O POR TITULO OU AUTOR
        // O PROXIOMO PASSO � IMPRIMIR A LISTA COMPLETA ORDENADA
        
        // Imprime todos os livros na lista ap�s a ordena��o
        livros.imprime();
    }
}
