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
    public void inserirLivro(String nomeDoLivro){
        Livro novoLivro = new Livro(nomeDoLivro);
        this.livros.add(novoLivro);
    }   
     public void inserirUsuario(String nomeDoUsuario){
         Usuario novoUsuario = new Usuario(nomeDoUsuario);
         this.usuarios.add(novoUsuario);
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
    public Emprestimo realizarEmprestimo(Biblioteca b1, Usuario nomeDoUsuario, Livro livro){
        if(livro != null && nomeDoUsuario != null){
            Emprestimo e1 = new Emprestimo(nomeDoUsuario, livro);
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
    public void removerLivro(String livroTitulo) {
    Livro livroRemover = null;
    for (Livro livro : livros) {
        if (livroTitulo.equals(livro.getTitulo())) {
            livroRemover = livro;
            break;
        }
    }

    if (livroRemover != null) {
        livros.remove(livroRemover);
        System.out.println("Livro removido: " + livroRemover.getTitulo());
    } else {
        System.out.println("Livro não encontrado na biblioteca.");
    }
}
    public Livro buscarLivros(String livroTitulo){
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
    public void inserirUsuario1(Usuario usuario){
         this.usuarios.add(usuario);
    }
   /* public Usuario quantosUsuarios(Usuario usuario){
        return usuarios.size();
   
}
