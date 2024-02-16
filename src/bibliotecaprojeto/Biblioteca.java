package bibliotecaprojeto;

import java.util.ArrayList;
public class Biblioteca {
    
    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Emprestimo> emprestimos;
    private boolean encontradoLivro = false;
    private boolean encontradoNome = false;
    
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
    public void buscarLivroPorTitulo(String tituloDesejado){       
        System.out.println("Buscando se o livro esta disponivel para emprestimo...");
        for(var livro : livros){
            if(livro.getTitulo().equals(tituloDesejado)){
                System.out.println("Livro esta disponivel para emprestimo: "+ tituloDesejado);
                encontradoLivro = true;
            }
        }       
        if(!encontradoLivro){
            System.out.println("Titulo não foi encontrado ou ja esta emprestado"); 
            encontradoLivro = false;
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
    
    public void buscarUsuario(Usuario nomeDesejado){
        for (var usuario : usuarios){
            if(usuario.getNome().equals(nomeDesejado)){
                System.out.println("O usuario "+nomeDesejado+" esta cadastrado!");
                encontradoNome = true;
            }
        }
        if(!encontradoNome){
            System.out.println("O usuario não esta cadastrado!");   
            encontradoNome=false;
        }
    }
    public void mostrarUsuarios(){
        System.out.println("USUARIOS CADASTRADOS:");
        for(Usuario usuario : usuarios){
            System.out.println(usuario.getNome());           
        }
        System.out.println("---------------------");
    }
    public void realizarEmprestimo(Usuario usuario, Livro livro){
        if(encontradoLivro == true && encontradoNome == true){
            Emprestimo e1 = new Emprestimo(usuario, livro);
            emprestimos.add(e1);
            System.out.println("Livro emprestado: " + livro.getTitulo() +" para o usuario: " + usuario.getNome());
        }
        else if(encontradoLivro == true && encontradoNome == false){
            System.out.println("O nome não está cadastrado!");
        }
        else if(encontradoLivro == false && encontradoNome == true){
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
