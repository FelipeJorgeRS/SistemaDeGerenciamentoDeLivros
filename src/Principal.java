import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;





public class Principal {
	
	
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

	public static void adicionarLivro(List<Livro> livros) {
	    Livro meuLivroUsuario = criarLivro();
	    livros.add(meuLivroUsuario);
	}

    public static void removerLivroPorTitulo(String titulo, List<Livro> livros) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getTitulo().equals(titulo)) {
                livros.remove(i);
                System.out.println("Livro removido com sucesso!");
                return;
            }
        }
        System.out.println("Livro não encontrado!");
    }

	
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\Felipe Jorge\\eclipse-workspace\\SistemaDeGerenciamentoDeLivros\\CADASTRO-100-LIVROS.csv" ;
        String line;
        String csvSplitBy = ",";
        
        
        Scanner leitor = new Scanner(System.in);
        
        // Criando uma lista para armazenar os livros
        List<Livro> livros = new ArrayList<>();

       
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {

        	String[] livro = line.split(csvSplitBy);

            // Criando uma nova instância da classe Livro
            Livro meuLivro = new Livro(livro[0], livro[1], livro[2], livro[3], livro[4]);

            // o método adicionarLivro faz a criação do livro e da adição à lista.
            //adicionarLivro(livros);

            
            // Removendo um livro pelo título
           /* System.out.println("Digite o título do livro que deseja remover:");
            String titulo=leitor.nextLine();
            removerLivroPorTitulo(titulo, livros); 
            */
            // Imprimindo os detalhes do livro
            System.out.println("Livro [titulo= " + meuLivro.titulo + " , autor=" + meuLivro.autor + ", ISBN=" + meuLivro.ISBN +", disponibilidade=" +meuLivro.disponibilidade+ ", criterioDeOrdenacao= "+ meuLivro.criterioDeOrdenacao+ "] \n");
        }

            // Criando uma nova instância da classe QuickSort
           
            QuickSort quickSort = new QuickSort();
            // Ordenando a lista de livros usando o QuickSort
            
            quickSort.sort(livros, 0, livros.size()-1);

           // Imprima a lista de livros
            for (int i = 0; i < livros.size(); i++) {
                Livro livro = livros.get(i);
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("ISBN: " + livro.getISBN());
                System.out.println("Disponibilidade: " + livro.getDisponibilidade());
                System.out.println("Critério de Ordenação: " + livro.getCriterioDeOrdenacao());
                System.out.println("------------------------");
            	}
            
         
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	
}
