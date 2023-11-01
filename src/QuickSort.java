import java.util.List;

public class QuickSort {
    int partition(List<Livro> livros, int low, int high) {
        Livro pivot = livros.get(high);  
        int i = (low-1); 
        for (int j=low; j<high; j++) {
        	if (livros.get(j).getTitulo().compareTo(pivot.getTitulo()) > 0) {
                i++;
                Livro temp = livros.get(j);
                livros.set(j, livros.get(i));
                livros.set(i, temp);
            }
        }
        Livro temp = livros.get(i+1);
        livros.set(i+1, livros.get(high));
        livros.set(high, temp);
        return i+1;
    }

    void sort(List<Livro> livros, int low, int high) {
        if (low < high) {
            int pi = partition(livros, low, high);
            sort(livros, low, pi);
            sort(livros, pi+1, high);
        }
    }
}
