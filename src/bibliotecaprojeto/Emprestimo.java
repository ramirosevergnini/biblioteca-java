package bibliotecaprojeto;

import java.util.ArrayList;

public class Emprestimo {
    private Usuario usuario;
    private Livro livro;
    private boolean devolvido = false;

    public Emprestimo(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }
    
    public void devolver(){
        this.devolvido = true;
    }
}
