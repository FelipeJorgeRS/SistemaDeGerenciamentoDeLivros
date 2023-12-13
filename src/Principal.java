import java.util.Scanner;


public class Principal {
	
   

    public static void main(String[] args) throws Exception {
    	String csvFile = "C:\\Users\\Felipe Jorge\\eclipse-workspace\\SistemaDeGerenciamentoDeLivros\\CADASTRO-100-LIVROS.csv";
    	Lista livro = new Lista();
    	livro.insereLivroCSV(csvFile);

        Scanner leitor = new Scanner(System.in);

        boolean continuar = true;
        while (continuar) {
        	System.out.println("Escolha uma opção:");
            System.out.println("1. Consultar um livro por título");
            System.out.println("2. Consultar um livro por autor");
            System.out.println("3. Inserir um novo livro");
            System.out.println("4. Remover um livro");
            System.out.println("5. Ordenar livros por título");
            System.out.println("6. Ordenar livros por autor");
            System.out.println("7. Consultar o estado de um livro");
            System.out.println("8. Devolver um livro");
            System.out.println("9. Pegar um livro emprestado");
            System.out.println("10. Reservar um livro");
            System.out.println("11. Sair");
            int opcao = leitor.nextInt();
            leitor.nextLine();  // consome a linha restante

            switch (opcao) {
                case 1:
                    System.out.println("Digite o título do livro que deseja consultar:");
                    String tituloConsulta = leitor.nextLine();
                    String livroTitulo = livro.consultaPorTitulo(tituloConsulta);
                    if (livroTitulo != null) {
                        System.out.println(livroTitulo);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;
                case 2:
                    System.out.println("Digite o autor do livro que deseja consultar:");
                    String autorConsulta = leitor.nextLine();
                    String resultado = livro.consultaPorAutor(autorConsulta);
                    System.out.println(resultado);
                    break;
                case 3:
                    Livro novoLivro = livro.insere();
                    break;
                case 4:
                    System.out.println("Digite o título do livro que deseja remover:");
                    String titulo = leitor.nextLine();
                    String mensagem = livro.retiraPorTitulo(titulo);
                    System.out.println(mensagem);
                    break;
                case 5:
                	livro.ordenaBubbleSort("titulo"); 
                	livro.imprimirTitulos();
                	break;
                case 6:
                	livro.ordenaBubbleSort("autor"); 
                	livro.imprimirAutores();
                    break;
                case 7:
                    System.out.println("Digite o ISBN do livro que deseja consultar o estado:");
                    String isbnConsulta = leitor.nextLine();
                    livro.consultaEstado(isbnConsulta);
                    break;
                case 8:
                    System.out.println("Digite o ISBN do livro que deseja devolver:");
                    String isbnDevolve = leitor.nextLine();
                    livro.devolveLivro(isbnDevolve);
                    break;
                case 9:
                    System.out.println("Digite o ISBN do livro que deseja pegar emprestado:");
                    String isbnEmpresta = leitor.nextLine();
                    livro.pegaLivroEmprestado(isbnEmpresta);
                    break;
                case 10:
                    System.out.println("Digite o ISBN do livro que deseja reservar:");
                    String isbnReserva = leitor.nextLine();
                    livro.reservaLivro(isbnReserva);
                    break;
                case 11:
                    continuar = false;
                    break;          
                    
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
      
    }
}
