package bibliotecaprojeto;

import java.util.ArrayList;
public class Biblioteca {
    
    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;
    ArrayList<Emprestimo> emprestimos;
    
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
        for (Livro livro : livros){
            System.out.println(livro.getTitulo());
        }
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
        for(Usuario usuario : usuarios){
            System.out.println(usuario.getNome());           
        }
    }
    public void realizarEmprestimo(Usuario usuario, Livro livro){
        
 
        
    }
    public void removerLivro(Livro livro) {
    if (livros.contains(livro)) {
        livros.remove(livro);
    }
    }
}
