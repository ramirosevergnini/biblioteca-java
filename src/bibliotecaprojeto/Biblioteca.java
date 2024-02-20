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
    public void mostrarLivros(){
        System.out.println("---------------------");
        System.out.println("LIVROS DA BIBLIOTECA:");
        for (Livro livro : livros){
            System.out.println(livro.getTitulo());
        }
        System.out.println("---------------------");
    }     
    public Livro buscarLivroPorTitulo2(String tituloDesejado){       
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
        System.out.println("USUARIOS CADASTRADOS:");
        for(Usuario usuario : usuarios){
            System.out.println(usuario.getNome());           
        }
        System.out.println("---------------------");
    }
    public void realizarEmprestimo(Usuario usuario, Livro livro){
        Usuario usuarioEncontrado = buscarUsuario(usuario);
        Livro livroEncontrado = buscarLivroPorTitulo2(livro.getTitulo());
        if(livroEncontrado != null && usuarioEncontrado != null){
            Emprestimo e1 = new Emprestimo(usuario, livro);
            emprestimos.add(e1);
            System.out.println("Livro emprestado: " + livro.getTitulo() +" para o usuario: " + usuario.getNome());
        }
        else if(livroEncontrado != null && usuarioEncontrado == null){
            System.out.println("O nome não está cadastrado!");
        }
        else if(livroEncontrado == null && usuarioEncontrado != null){
            System.out.println("O livro nao esta na biblioteca!");
        }
        
    }
    public void removerLivro(Livro livro) {
    if (livros.contains(livro)) {
        livros.remove(livro);
        System.out.println("Livro removido da biblioteca: " + livro.getTitulo());
    }
    }
}
