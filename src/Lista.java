
public class Lista {
	
	
	private static class Celula { Object item; Celula prox; }
	private Celula primeiro, ultimo, pos;
	// Operações
	public Lista () { // Cria uma Lista vazia
	this.primeiro = new Celula (); 
	this.pos = this.primeiro; 
	this.ultimo = this.primeiro; 
	this.primeiro.prox = null;
	}
	
	public Object pesquisa (Object chave) {
	if (this.vazia () || chave == null) {
		return null; }
		Celula aux = this.primeiro;
		while (aux.prox != null) {
			if (aux.prox.item.equals(chave)) {
				return aux.prox.item;
			}
		aux= aux.prox;
		} return null;
	}

	public void insere (Object x) {
		this.ultimo.prox = new Celula ();
		this.ultimo = this.ultimo.prox;
		this.ultimo.item = x; this.ultimo.prox = null;
		}

	public Object retira (Object chave) 
		throws Exception {
		if (this.vazia () || (chave == null)) {
			throw new Exception 
			("Erro: Lista vazia ou chave invalida");
			}
			
		Celula aux =this.primeiro;
		while (aux.prox!= null && !aux.prox.item.equals (chave)) 
			aux=aux.prox;
		if (aux.prox == null)
			return null; 
		Celula q = aux.prox;
		Object item =q.item; 
		aux.prox = q.prox;
		if (aux.prox == null) 
			this.ultimo = aux; 
		return item;
		}
	
	public Object retiraPrimeiro () throws Exception {
		if (this.vazia ()) throw new Exception
		("Erro: Lista vazia");
		Celula aux = this.primeiro; 
		Celula q = aux.prox;
		Object item= q.item; aux.prox = q.prox;
		if (aux.prox == null) this. ultimo = aux; 
		return item;
		}
	
	public Object retiraPorTitulo(String titulo) throws Exception {
	    if (this.vazia() || (titulo == null || titulo.isEmpty())) {
	        throw new Exception("Erro: Lista vazia ou título inválido");
	    }

	    Celula aux = this.primeiro;
	    while (aux.prox != null) {
	        Livro livro = (Livro) aux.prox.item;
	        if (livro.getTitulo().equals(titulo)) {
	            Celula q = aux.prox;
	            Object item = q.item;
	            aux.prox = q.prox;
	            if (aux.prox == null) {
	                this.ultimo = aux;
	            }
	            return item;
	        }
	        aux = aux.prox;
	    }
	    return null;
	}

	public Object retiraPorAutor(String autor) throws Exception {
	    if (this.vazia() || (autor == null || autor.isEmpty())) {
	        throw new Exception("Erro: Lista vazia ou autor inválido");
	    }

	    Celula aux = this.primeiro;
	    while (aux.prox != null) {
	        Livro livro = (Livro) aux.prox.item;
	        if (livro.getAutor().equals(autor)) {
	            Celula q = aux.prox;
	            Object item = q.item;
	            aux.prox = q.prox;
	            if (aux.prox == null) {
	                this.ultimo = aux;
	            }
	            return item;
	        }
	        aux = aux.prox;
	    }
	    return null;
	}
	
	
	public Object primeiro () {
		this.pos = primeiro; return proximo (); 
		}


	public Object proximo () {
		this.pos = this.pos.prox;
		if (this.pos == null) return null;
		else return this.pos.item;
		}


	public boolean vazia () {
		return (this.primeiro == this.ultimo);
		}
	
	public void imprime (Livro novoLivro) {
		Celula aux = this.primeiro.prox;
		while (aux != null) {
		System.out.println (aux.item.toString()); 
		aux = aux.prox; 
			} 
		}

	public void ordenaBubbleSort(String criterio) {
	    if (vazia()) {
	        return;
	    }

	    Celula i = primeiro;
	    while (i != null) {
	        Celula j = primeiro.prox;
	        while (j.prox != null) {
	            Livro livro1 = (Livro) j.item;
	            Livro livro2 = (Livro) j.prox.item;

	            // criterio de ordenaçã
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
