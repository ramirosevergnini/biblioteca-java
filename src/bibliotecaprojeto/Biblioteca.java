package bibliotecaprojeto;

import java.util.ArrayList;
public class Biblioteca {
    
    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Emprestimo> emprestimos;
    
    
    public Biblioteca() {
        this.livros = new ArrayList<Livro>();
        this.usuarios = new ArrayList<Usuario>();
        this.emprestimos = new ArrayList<Emprestimo>();
    }
    public void inserirLivro(Livro livro){
        this.livros.add(livro);
    }   
     public void inserirUsuario(Usuario usuario){
         this.usuarios.add(usuario);
    }
    public void inserirEmprestimo(Emprestimo emprestimo){
        this.emprestimos.add(emprestimo);
    }
    public void mostrarLivros(){
        for (Livro livro : livros){
            System.out.println(livro.getTitulo());
        }
    }     
    public Livro buscarLivroPorTitulo(String tituloDesejado){       
        for(var livro : livros){
            if(livro.getTitulo().equals(tituloDesejado)){
                return livro;
            }
        }
        return null;
    }   
    public Usuario buscarUsuario(Usuario nomeUsuario){
        for (var usuario : usuarios){
            if(usuario.getNome().equals(nomeUsuario)){
                return usuario;
            }
        }
        return null;
    }
    public void mostrarUsuarios(){
        for(Usuario usuario : usuarios){
            System.out.println(usuario.getNome());           
        }
    }
    public Emprestimo realizarEmprestimo(Biblioteca b1, Usuario usuario, Livro livro){
        if(livro != null && usuario != null){
            Emprestimo e1 = new Emprestimo(usuario, livro);
            b1.emprestimos.add(e1);
            return e1;
        }
        return null;
    }
    public Emprestimo verificarLivroEmprestado(String titulo){
        for(Emprestimo emprestimo:emprestimos){
            if(emprestimo.getLivro().getTitulo().equals(titulo)){
                return emprestimo;
            }
        }
        return null;
    }
    public String removerLivro(String livro) {
        if (livros.contains(livro)) {
            livros.remove(livro);
            return livro;
        }
        return null;
    }
    public Livro confirmarLivro(String livroTitulo){
        for (Livro livro:livros){
            if(livro.getTitulo().equals(livroTitulo)){
                return livro;
            }
        }
        return null;
    }
    public Usuario confirmarCadastro(String tecladoUsuario){
        for (var usuario : usuarios){
            if(usuario.getNome().equals(tecladoUsuario)){
                return usuario;
            } 
        }
        return null;
    }
    public String colocarSenha(String admSenha){
        String senha = "723109";
        return senha;
        
    }
}
