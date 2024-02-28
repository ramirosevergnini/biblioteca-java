package bibliotecaprojeto;
import java.util.ArrayList;
public class Biblioteca {
    
    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Emprestimo> emprestimos;
    private ArrayList<Administrador> administradores;
    
    
    public Biblioteca() {
        this.livros = new ArrayList<Livro>();
        this.usuarios = new ArrayList<Usuario>();
        this.emprestimos = new ArrayList<Emprestimo>();
    }
    public void inserirLivro(String nomeDoLivro){
        Livro novoLivro = new Livro(nomeDoLivro);
        this.livros.add(novoLivro);
    }   
    public void registrarUsuario(String nomeDoUsuario, String senha){
        Usuario novoUsuario = new Usuario(nomeDoUsuario, senha);
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
    public Emprestimo realizarEmprestimo(Biblioteca b1, Usuario usuario, Livro livro){
        if(livro != null && usuario != null){
            Emprestimo e1 = new Emprestimo(usuario, livro);
            b1.emprestimos.add(e1);
            return e1;
        }
        return null;
    }
    public Emprestimo buscarEmprestimo(Usuario usuario, Livro livro) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuario().equals(usuario) && emprestimo.getLivro().equals(livro)) {
                return emprestimo;
            }
        }
        return null;
    }

    public boolean devolverLivro(Usuario usuario, Livro livro) {
        Emprestimo emprestimo = buscarEmprestimo(usuario, livro);
        if (emprestimo != null) {
            emprestimos.remove(emprestimo);
            System.out.println("Livro devolvido: " + livro.getTitulo() + " pelo usuário: " + usuario.getNome());
            return true;
        } else {
            System.out.println("Este livro não está emprestado para este usuário.");
            return false;
        }
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
    public Usuario login(String nomeUsuario, String senha){
        for (var usuario : usuarios){
            if(usuario.getNome().equals(nomeUsuario) && usuario.getSenhaUsuario().equals(senha)){
                return usuario;
            } 
        }
        return null;
    }
    public void inserirUsuario1(Usuario usuario){
        this.usuarios.add(usuario);
    }
    public void inserirLivro1(Livro livro){
        this.livros.add(livro);
    }
    public void mostrarLivrosEmprestados() {
        if (emprestimos.isEmpty()) {
            System.out.println("Não há livros emprestados no momento.");
        } else {
            System.out.println("Livros emprestados:");
            for (Emprestimo emprestimo : emprestimos) {
                Livro livroEmprestado = emprestimo.getLivro();
                Usuario usuarioEmprestimo = emprestimo.getUsuario();
                System.out.println("Livro: " + livroEmprestado.getTitulo() + " | Empréstimo para: " + usuarioEmprestimo.getNome());
            }
        }
}
}
