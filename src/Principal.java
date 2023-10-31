import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Principal {
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\tech\\Desktop\\SGBIBLIOTECA\\CADASTRO-100-LIVROS.csv" ;
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] livro = line.split(csvSplitBy);

                // Criando uma nova instância da classe Livro
                Livro meuLivro = new Livro(livro[0], livro[1], livro[2], livro[3], livro[4]);

                // Imprimindo os detalhes do livro
                System.out.println("Livro [titulo= " + meuLivro.titulo + " , autor=" + meuLivro.autor + " , ISBN=" + meuLivro.ISBN +", disponibilidade=" +meuLivro.disponibilidade+ ", criterioDeOrdenacao= "+ meuLivro.criterioDeOrdenacao+ "]");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}