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
        System.out.println("Você deseja entrar em nossa biblioteca? (sim) ou (nao)");
        c = whileCond.nextLine();
        System.out.println("Seja muito bem vindo a biblioteca Severgnini Cultura!");
        loopPrincipal:
        while (!"nao".equals(c)){
            Scanner lerAlternativa = new Scanner(System.in);
            String cli;
            System.out.println("""
                               O que pretende fazer?
                               (1) Mostrar livros.
                               (2) Mostar usuarios
                               (3) Confirmar cadastro.
                               (4) Selecione seu livro.
                               (5) Remover livro.
                               (6) Realizar emprestimo
                               (7) Sair""");
            cli = lerAlternativa.nextLine();
            String titulo = "";
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
                    
                    System.out.println("Opcao Confirmar cadastro selecionada!");
                    Scanner tecladoUsuario = new Scanner(System.in);
                    System.out.println("Escreva o nome do usuario para ver se ele esta cadastrado: ");
                    String nomeUsuario = tecladoUsuario.nextLine();
                    
                    Usuario usuarioConfirmado = b1.confirmarCadastro(nomeUsuario);
                    
                    
                    if (usuarioConfirmado != null){
                        System.out.println("Usuario esta cadastrado");
                    }else{
                        System.out.println("Usuario nao esta cadastrado");
                    }
                    //tecladoUsuario.close();
                    break;
                    
                case "4":
                    
                    System.out.println("Opcao Selecionar seu livro selecionada!");
                    Scanner buscaLivro = new Scanner(System.in);
                    System.out.println("Qual livro deseja saber a disponibilidade?");
                    String livroTitulo = buscaLivro.nextLine();
                    
                    Livro livroConfirmado = b1.confirmarLivro(livroTitulo);
                    if (livroConfirmado != null){
                        System.out.println("Livro está disponível");
                    }
                    else{
                        Emprestimo emprestimo1 = b1.verificarLivroEmprestado(titulo);
                        if(emprestimo1 != null){
                            System.out.println("Livro existe mas está emprestado!");
                        }else{
                            System.out.println("Livro não existe!");
                        }
                }
                            
                            
                    //tecladoTitulo.close();
                    break;
                    
                /*case "5":
                    System.out.println("Opcao Buscar livro por titulo selecionada!");
                    
                    Livro livroProcurado1 = b1.buscarLivroPorTitulo(titulo);
                    if (livroProcurado1 == null) {
                        System.out.println("Nao temos esse livro!");
                    } else {
                        System.out.println("Livro encontrado: " + livroProcurado1.getTitulo());
                    }
                    break;
                */    
                case "5":
                    System.out.println("Opcao realizar remocao de livro selecionada!");
                    Scanner admSenha = new Scanner(System.in);                    
                    System.out.println("Para conseguir utilizar essa opcao, coloque sua senha de administrador:");
                    String lerSenha = admSenha.nextLine();
                    String senhaAdm = b1.colocarSenha(lerSenha);
                    if(lerSenha != senhaAdm){
                        System.out.println("Senha incorreta!");
                    }
                    else{
                        System.out.println("Senha correta!");
                        Scanner livroRemover = new Scanner (System.in);
                        System.out.println("Qual livro você deseja retirar?");
                        String livroEscolhido = b1.removerLivro(livrosas);
                    }
                    admSenha.close();
                case "6":
                    
                    System.out.println("Opcao realizar emprestimo selecionada!");
                    Emprestimo e1 = b1.realizarEmprestimo(b1, u1, l2);
                    if(e1 == null) {
                        System.out.println("Não foi possível realizar o emprestimo!");
                    }else{
                        System.out.println("Emprestimo realizado com sucesso");
                    }
                    break;
                    
                case "7":
                    System.out.println("Saindo da biblioteca...");
                    break loopPrincipal;
                    default:
                    System.out.println("Você selecionou um número errado.");
                    
            }
             
        }
        System.out.println("Muito obrigado por por visistar a bilioteca Severgnini Cultura!\n"
                + "Volte Sempre!!!");

        
        
       
        
            
//        Remove livros do sistema
        b1.removerLivro(l1);
//        System.out.println("Livro removido da biblioteca: " + livro.getTitulo());
//        b1.mostrarLivros();
        
    }
    
}