package bibliotecaprojeto;
import java.util.Scanner;
public class Livro {
    private String titulo;
    private boolean disponivel = true;
    //private String autor;

    public Livro(String titulo){//, //String autor) {
        this.titulo = titulo;
        //this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }
    
    /*public String getAutor() {
        return autor;
    }

    
    */
    
}
