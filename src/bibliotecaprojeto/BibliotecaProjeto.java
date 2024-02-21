package bibliotecaprojeto;
import java.util.Scanner;
public class BibliotecaProjeto {
    public static void main(String[] args) {
        Biblioteca b1 = new Biblioteca();
      
        Livro l1 = new Livro("Manuscrito Original");
        Livro l2 = new Livro("Do Mil ao Milhao");
        b1.inserirLivro(l1);
        b1.inserirLivro(l2);
        
        Usuario u1 = new Usuario("Ramiro");
        b1.inserirUsuario(u1);
        
                //        ler condição while
        Scanner whileCond = new Scanner(System.in);
        String c;
        System.out.println("Você deseja entrar em nossa biblioteca? (sim) ou (não)");
        c = whileCond.nextLine();
        while (c != "sim"){
            Scanner lerAlternativa = new Scanner(System.in);
            String cli;
            System.out.println("""
                               O que pretende fazer?
                               (1) Mostrar livros.
                               (2) Mostar usuarios
                               (3) Escreva seu nome e selecione seu livro.
                               (4) Buscar livro por titulo
                               (5) Realizar emprestimo
                               (6) Sair""");
            cli = lerAlternativa.nextLine();
            
            switch(cli){
                
                case "1":
                    
                    System.out.println("Opcao Mostrar livros selecionada!");
                    System.out.println("---------------------");
                    System.out.println("LIVROS DA BIBLIOTECA:");
                    b1.mostrarLivros();
                    System.out.println("---------------------");
                    break;
                    
                case "2":
                    
                    System.out.println("Opcao Mostrar usuarios selecionada!");
                    // Mostra os usuários cadastrados 
                    System.out.println("USUARIOS CADASTRADOS:");
                    b1.mostrarUsuarios();
                    System.out.println("---------------------");
                    break;
                    
                case "3":
                    
                    System.out.println("Opcao Escreva seu nome e selecione seu livro");
                    Scanner teclado = new Scanner(System.in);
                    System.out.println("Escreva o nome do livro para ver se ele esta disponivel: ");
                    String titulo = teclado.nextLine();
                    System.out.println("Escreva o nome do usuario para ver se ele esta cadastrado: ");
                    String nomeUsuario = teclado.nextLine();
                    teclado.close();
                    
                case "4":
                    
                    System.out.println("Opcao Buscar livro por titulo selecionada!");
                    break;
                    
                case "5":
                    
                    System.out.println("Opcao realizar emprestimo selecionada!");
                    Emprestimo e1 = b1.realizarEmprestimo(b1, u1, l2);
                    if(e1 == null) {
                        System.out.println("Não foi possível realizar o emprestimo!");
                    }else{
                        System.out.println("Emprestimo realizado com sucesso");
                    }
                    break;
                    
                case "6":
                    
                    break;
                default:
                    System.out.println("Você selecionou um número errado.");
                    
            }
             
        }
      
     
        
        // Pergunta ao usuário seu nome e qual livro deseja pegar emprestado
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escreva o nome do livro para ver se ele esta disponivel: ");
        String titulo = teclado.nextLine();
        
        System.out.println("Escreva o nome do usuario para ver se ele esta cadastrado: ");
        String nomeUsuario = teclado.nextLine();
        
        teclado.close();

        // Busca as informações na biblioteca
        
        Livro livroProcurado1 = b1.buscarLivroPorTitulo(titulo);
        
        if (livroProcurado1 == null) {
            System.out.println("Nao temos esse livro!");
//            return;
        } else {
            System.out.println("Livro encontrado: " + livroProcurado1.getTitulo());
        }
        
       
        
            
//        Remove livros do sistema
//        b1.removerLivro(l1);
//        System.out.println("Livro removido da biblioteca: " + livro.getTitulo());
//        b1.mostrarLivros();
        
    }
    
}