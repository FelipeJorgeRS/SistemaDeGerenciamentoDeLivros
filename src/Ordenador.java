public class Ordenador {
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
