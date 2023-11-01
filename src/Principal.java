import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class Principal {
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\tech\\Desktop\\SGBIBLIOTECA\\CADASTRO-100-LIVROS.csv" ;
        String line;
        String csvSplitBy = ",";
        
        // Criando uma lista para armazenar os livros
        List<Livro> livros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {

            	String[] livro = line.split(csvSplitBy);

                // Criando uma nova instância da classe Livro
                Livro meuLivro = new Livro(livro[0], livro[1], livro[2], livro[3], livro[4]);

                // Adicionando o livro à lista
                livros.add(meuLivro);
                
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
            
            // Imprimindo a lista de livros após a ordenação
           /* for(Livro livro : livros){
                System.out.println("Livro [titulo= " + livro.titulo + " , autor=" + livro.autor + ", ISBN=" + livro.ISBN +", disponibilidade=" +livro.disponibilidade+ ", criterioDeOrdenacao= "+ livro.criterioDeOrdenacao+ "] \n");
            } */

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
