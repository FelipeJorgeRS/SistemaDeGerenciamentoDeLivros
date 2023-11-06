import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Principal {
	
	// Método para criar um novo livro
	public static Livro criarLivro() {
	    Scanner leitor = new Scanner(System.in);
	    System.out.println("Digite o título do livro:");
	    String titulo = leitor.nextLine();
	    System.out.println("Digite o autor do livro:");
	    String autor = leitor.nextLine();
	    System.out.println("Digite o ISBN do livro:");
	    String ISBN = leitor.nextLine();
	    System.out.println("Digite a disponibilidade do livro:");
	    String disponibilidade = leitor.nextLine();
	    System.out.println("Digite o critério de ordenação do livro:");
	    String criterioDeOrdenacao = leitor.nextLine();
	    return new Livro(titulo, autor, ISBN, disponibilidade, criterioDeOrdenacao);
	}

    public static void main(String[] args) throws Exception {
        String csvFile = "C:\\Users\\Felipe Jorge\\eclipse-workspace\\SistemaDeGerenciamentoDeLivros\\CADASTRO-100-LIVROS.csv";
        String line;
        String csvSplitBy = ",";
        Scanner leitor = new Scanner(System.in);
        Lista livros = new Lista();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] livro = line.split(csvSplitBy);
                Livro meuLivro = new Livro(livro[0], livro[1], livro[2], livro[3], livro[4]);
               
                
                Livro novoLivro = criarLivro();
                livros.insere(novoLivro);

                livros.insere(meuLivro);
               
                System.out.println("Digite o título do livro que deseja remover:");
                String titulo=leitor.nextLine();
                livros.retiraPorTitulo(titulo);
               
                livros.imprime(novoLivro);
                System.out.println(meuLivro);
           
                System.out.println("Digite o critério de ordenação (titulo ou autor):");
                String criterio = leitor.nextLine();
                livros.ordenaBubbleSort(criterio);
               
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para imprimir todos os livros na lista
    public static void imprimirLivros(Lista livros) {
        for (int i = 0; i < livros.size(); i++) {
            Livro livro = livros.get(i);
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("ISBN: " + livro.getISBN());
            System.out.println("Disponibilidade: " + livro.getDisponibilidade());
            System.out.println("Critério de Ordenação: " + livro.getCriterioDeOrdenacao());
            System.out.println("------------------------");
        }
    }
}
