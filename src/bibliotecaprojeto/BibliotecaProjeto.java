package bibliotecaprojeto;
import java.util.Scanner;
public class BibliotecaProjeto {
    public static void main(String[] args) {
        Biblioteca b1 = new Biblioteca();

        Livro l1 = new Livro("Manuscrito Original");
        Livro l2 = new Livro("Do Mil ao Milhao");
        b1.inserirLivro(l1);
        b1.inserirLivro(l2);
        b1.mostrarLivros();
        
        Usuario u1 = new Usuario("Ramiro");
        b1.inserirUsuario(u1);
        b1.mostrarUsuarios();
        
        // Pergunta ao usuário seu nome e qual livro deseja pegar emprestado
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escreva o nome do livro para ver se ele esta disponivel: ");
        String titulo = teclado.nextLine();
        
        System.out.println("Escreva o nome do usuario para ver se ele esta cadastrado: ");
        String nomeUsuario = teclado.nextLine();
        
        teclado.close();

        // Busca as informações na biblioteca
        b1.buscarLivroPorTitulo(titulo);
        
        Livro livroProcurado1 = b1.buscarLivroPorTitulo2(titulo);
        
        if (livroProcurado1 == null) {
            System.out.println("Nao temos esse livro, vá embora!");
//            return;
        } else {
            System.out.println("LIvro encontrado:" + livroProcurado1.getTitulo());
        }
        
        
//        b1.buscarUsuario();;=
//        b1.realizarEmprestimo(u1, l1);
//        b1.removerLivro(l1);
//        b1.mostrarLivros();
        
        
    }
    
}
