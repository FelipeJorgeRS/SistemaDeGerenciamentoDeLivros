import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lista {
    private static class Celula {
        Object item;
        Celula prox;
    }

    private Celula primeiro, ultimo, pos;

    public Lista() { // Cria uma Lista vazia
        this.primeiro = new Celula();
        this.pos = this.primeiro;
        this.ultimo = this.primeiro;
        this.primeiro.prox = null;
    }

    public Object pesquisa(Object chave) {
        if (this.vazia() || chave == null) {
            return null;
        }
        Celula aux = this.primeiro;
        while (aux.prox != null) {
            if (aux.prox.item.equals(chave)) {
                return aux.prox.item;
            }
            aux = aux.prox;
        }
        return null;
    }
   
    
    public String insereLivroCSV(String csvFile) {
        String line;
        String csvSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] livro = line.split(csvSplitBy);
                Livro novoLivroCriado = new Livro(livro[0], livro[1], livro[2], livro[3], livro[4]);

                this.ultimo.prox = new Celula();
                this.ultimo = this.ultimo.prox;
                this.ultimo.item = novoLivroCriado; // Use novoLivroCriado aqui
                this.ultimo.prox = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Os livros foram inseridos com sucesso!";
    }

    
    public Livro insere() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o título do livro:");
        String titulo = leitor.nextLine();
        System.out.println("Digite o autor do livro:");
        String autor = leitor.nextLine();
        System.out.println("Digite o ano de publicação do livro:");
        String anoPublicacao = leitor.nextLine();
        System.out.println("Digite a editora do livro:");
        String editora = leitor.nextLine();
        System.out.println("Digite o ISBN do livro:");
        String isbn = leitor.nextLine();

        Livro novoLivro = new Livro(titulo, autor, anoPublicacao, editora, isbn);

        this.ultimo.prox = new Celula();
        this.ultimo = this.ultimo.prox;
        this.ultimo.item = novoLivro;
        this.ultimo.prox = null;

        System.out.println("O livro " + titulo + " foi inserido com sucesso!");

        return novoLivro;
    }


  
    public String retiraPorTitulo(String titulo) throws Exception {
        if (this.vazia() || (titulo == null || titulo.trim().isEmpty())) {
            throw new Exception("Erro: Lista vazia ou título inválido");
        }

        titulo = titulo.trim(); // Remove espaços no início e no final

        Celula aux = this.primeiro;
        while (aux.prox != null) {
            Livro livro = (Livro) aux.prox.item;
            if (livro.getTitulo().equalsIgnoreCase(titulo)) { // Ignora a distinção entre maiúsculas e minúsculas
                Celula q = aux.prox;
                Livro item = (Livro) q.item;
                aux.prox = q.prox;
                if (aux.prox == null) this.ultimo = aux;
                return "O livro " + titulo + " foi removido com sucesso!";
            }
            aux = aux.prox;
        }
        return "O livro " + titulo + " não foi encontrado na lista.";
    }
    
    
    

    public String consultaPorTitulo(String titulo) {
        if (this.vazia() || (titulo == null || titulo.trim().isEmpty())) {
            return "Título inválido ou acervo vazio.";
        }

        titulo = titulo.trim().toLowerCase();
        Celula aux = this.primeiro;
        while (aux.prox != null) {
            Livro livro = (Livro) aux.prox.item;
            if (livro.getTitulo().toLowerCase().contains(titulo)) {
                return "O livro " + livro.getTitulo() + " consultado está no acervo.";
            }
            aux = aux.prox;
        }
        return "Livro não encontrado no acervo.";
    }

    public String consultaPorAutor(String autor) {
        if (this.vazia() || (autor == null || autor.trim().isEmpty())) {
            return "Lista Vazia";
        }

        Celula aux = this.primeiro;
        String resultado = "";
        String autorBusca = autor.toLowerCase().trim();
        while (aux.prox != null) {
            Livro livro = (Livro) aux.prox.item;
            String autorLivro = livro.getAutor().toLowerCase().trim();
            if (autorLivro.contains(autorBusca)) {
                resultado += "O livro " + livro.getTitulo() +" do(a) autor(a)" +livro.getAutor() +" está cadastrado no sistema.\n";
            }
            aux = aux.prox;
        }
        return resultado.isEmpty() ? "Autor não encontrado." : resultado;
    }


    public Object primeiro() {
        this.pos = primeiro;
        return proximo();
    }

    public Object proximo() {
        this.pos = this.pos.prox;
        if (this.pos == null) return null;
        else return this.pos.item;
    }

    public boolean vazia() {
        return (this.primeiro == this.ultimo);
    }

    public void imprime() {
        Celula aux = this.primeiro.prox;
        while (aux != null) {
            System.out.println(aux.item.toString());
            aux = aux.prox;
        }
    }







 // Método para ordenar a lista de livros usando o algoritmo Bubble Sort
    public static void ordenaBubbleSort(Lista lista, String criterio) {
        if (lista.vazia()) {
            return;
        }

        Lista.Celula i = lista.primeiro;
        while (i != null) {
            Lista.Celula j = lista.primeiro.prox;
            while (j.prox != null) {
                Livro livro1 = (Livro) j.item;
                Livro livro2 = (Livro) j.prox.item;

                int comparacao;
                if (criterio.equals("titulo")) {
                    comparacao = livro1.getTitulo().compareTo(livro2.getTitulo());
                } else if (criterio.equals("autor")) {
                    comparacao = livro1.getAutor().compareTo(livro2.getAutor());
                } else {
                    throw new IllegalArgumentException("Critério de ordenação inválido: " + criterio);
                }

                if (comparacao > 0) {
                    Object temp = j.item;
                    j.item = j.prox.item;
                    j.prox.item = temp;
                }

                j = j.prox;
            }
            i = i.prox;
        }
    }

	

}
