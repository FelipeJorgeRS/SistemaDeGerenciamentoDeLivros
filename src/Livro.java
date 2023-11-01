
public class Livro {
	String titulo;
	String autor;
	String ISBN;
	String disponibilidade;
	String criterioDeOrdenacao;
	
	public Livro(String titulo, String autor,String ISBN,String disponibilidade, String criterioDeOrdenacao) {
		this.titulo= titulo;
		this.autor=autor;
		this.ISBN=ISBN;
		this.disponibilidade= disponibilidade;
		this.criterioDeOrdenacao= criterioDeOrdenacao;
	}

	public String getTitulo() {
		return this.titulo;
			
	}

	public String getAutor() {
		return this.autor;
	}

	public String getISBN() {
		return this.ISBN;
	}

	public String getDisponibilidade() {
		return this.disponibilidade;
	}

	public String getCriterioDeOrdenacao() {
		return this.criterioDeOrdenacao;
	}

	
}
