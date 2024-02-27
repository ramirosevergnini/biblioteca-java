package bibliotecaprojeto;
import java.util.Scanner;
public class BibliotecaProjeto {
    public static void main(String[] args) {
        Biblioteca b1 = new Biblioteca();
        boolean sair = false;
        boolean reiniciarCadastro = false;
        boole
               
        Livro l1 = new Livro("Minecraft");
        b1.inserirLivro1(l1);
        Usuario u1 = new Usuario("Ramiro", "1234");
        b1.inserirUsuario1(u1);        
        
        Livro novoLivro;
        Usuario usuarioLogado;
        
        Scanner tecladoAdmOuUsuario = new Scanner(System.in);
        System.out.println("""
                           1) Usuario
                           2) Administrador""");
        String AdmOuUsuario = tecladoAdmOuUsuario.nextLine();
        
        switch(AdmOuUsuario){
            case"1":
                while (!reiniciarCadastro){ 
                Scanner tecladoRegisterOuLogin = new Scanner(System.in);
                System.out.println("""
                                   1) LOGIN
                                   2) REGISTER""");
                String RegisterOuLogin = tecladoRegisterOuLogin.nextLine();
        
                switch(RegisterOuLogin){
                    
                case"1":
                
                    System.out.println("Opcao Login selecionada!");
                    Scanner tecladoUsuarioLogin = new Scanner(System.in);
                    System.out.println("Escreva o seu nome:");
                    String nomeUsuarioLogin = tecladoUsuarioLogin.nextLine();
                    System.out.println("Escreva a sua senha:");
                    String senhaUsuario = tecladoUsuarioLogin.nextLine();

                    usuarioLogado = b1.login(nomeUsuarioLogin, senhaUsuario);
                   
                    if (usuarioLogado != null){
                        System.out.println("Seja bem-vindo(a) "+nomeUsuarioLogin);
                        reiniciarCadastro = true;
                    }else{
                        System.out.println("""
                                           Nao foi possivel realizar o login.
                                           1) Tentar novamente""");
                        String cadastroNovamente = tecladoUsuarioLogin.nextLine();
                        if("1".equals(cadastroNovamente)){
                            reiniciarCadastro = false;
                        }
                    }

                    break;
                    
                case"2":
                    System.out.println("Opcao Register selecionada!");
                    Scanner tecladoUsuarioRegister = new Scanner(System.in);
                    System.out.println("Escreva o seu nome:");
                    String nomeUsuarioRegistro = tecladoUsuarioRegister.nextLine();
                    System.out.println("Escreva sua senha:");
                    String senhaUsuarioRegistro = tecladoUsuarioRegister.nextLine();
                    
                    b1.registrarUsuario(nomeUsuarioRegistro, senhaUsuarioRegistro);
                    
                    break;
                }
                }
                
            case"2":
                
                System.out.println("Faça o login como administrador!");
                Scanner nomeAdmLogin = new Scanner(System.in);                    
                    System.out.println("Coloque seu nome:");
                    String lerSenha2 = admSenha2.nextLine();
                    String senhaAdm2 = b1.colocarSenha(lerSenha2);
                    if(!lerSenha2.equals(senhaAdm2)){
                        System.out.println("Senha incorreta!");
                    }
                    else{
                        System.out.println("Senha correta!");
                
                    }
        }

        loopPrincipal:
        while (!sair){
            Scanner lerAlternativa = new Scanner(System.in);
            String cli;
            System.out.println("""
                               O que pretende fazer?
                               (1) Mostrar livros.
                               (2) Mostar usuarios
                               (3) Confirmar cadastro.
                               (4) Selecione seu livro.
                               (5) Realizar emprestimo.
                               (6) Remover livro.
                               (7) Cadastrar usuario.
                               (8) Cadastrar livro.
                               (9) Sair""");
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
                    
                case "4":
                    
                    System.out.println("Opcao Selecionar seu livro selecionada!");
                    Scanner buscaLivro = new Scanner(System.in);
                    System.out.println("Qual livro deseja saber a disponibilidade?");
                    String livroTitulo = buscaLivro.nextLine();
                    Livro livroConfirmado = b1.buscarLivros(livroTitulo);
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
                    break;
                case "5":
                    System.out.println("Opcao realizar emprestimo selecionada!");
                    Emprestimo e1 = b1.realizarEmprestimo(b1, u1, l1);
                    if(e1 == null) {
                        System.out.println("Não foi possível realizar o emprestimo!");
                    }else{
                        System.out.println("Emprestimo do livro: "+l1+" para o(a) "+u1+" realizado com sucesso");
                    }
                    break;      
                case "6":
                    System.out.println("Opcao realizar remocao de livro selecionada!");
                    Scanner admSenha = new Scanner(System.in);                    
                    System.out.println("Para conseguir utilizar essa opcao, coloque sua senha de administrador:");
                    String lerSenha = admSenha.nextLine();
                    String senhaAdm = b1.colocarSenha(lerSenha);
                    if(!lerSenha.equals(senhaAdm)){
                        System.out.println("Senha incorreta!");
                    }
                    else{
                        System.out.println("Senha correta!");
                        Scanner livroRemover = new Scanner (System.in);
                        System.out.println("Qual livro você deseja retirar?");
                        String livroEscolhido = livroRemover.nextLine();
                        b1.removerLivro(livroEscolhido);
                    }
                case "7":
                    //duvida, porque ele não está salvando e exibindo no comeco
                    System.out.println("Opcao Realizar cadastro selecionada!");
                    Scanner admSenha2 = new Scanner(System.in);                    
                    System.out.println("Para conseguir utilizar essa opcao, coloque sua senha de administrador:");
                    String lerSenha2 = admSenha2.nextLine();
                    String senhaAdm2 = b1.colocarSenha(lerSenha2);
                    if(!lerSenha2.equals(senhaAdm2)){
                        System.out.println("Senha incorreta!");
                    }
                    else{
                        System.out.println("Senha correta!");
                        Scanner cadastroUsuario = new Scanner (System.in);
                        System.out.println("Qual o nome do usuario");
                        String nomeDoUsuario = cadastroUsuario.nextLine();
                    }
                    
                case "8":
                    System.out.println("Opcao Cadastrar livro selecionada!");
                    Scanner admSenha3 = new Scanner(System.in);                    
                    System.out.println("Para conseguir utilizar essa opcao, coloque sua senha de administrador:");
                    String lerSenha3 = admSenha3.nextLine();
                    String senhaAdm3 = b1.colocarSenha(lerSenha3);
                    if(!lerSenha3.equals(senhaAdm3)){
                        System.out.println("Senha incorreta!");
                    }
                    else{
                        System.out.println("Senha correta!");
                        Scanner cadastroLivro = new Scanner (System.in);
                        System.out.println("Qual o nome do livro");
                        String nomeDoLivro  = cadastroLivro.nextLine();
                        b1.inserirLivro(nomeDoLivro);
                    }
                    
                case "9":
                    System.out.println("Saindo da biblioteca...");
                    sair = true;

        
                default:  
                    System.out.println("Você selecionou um número errado.");
            }
             
        }
        System.out.println("""
                           Muito obrigado por por visitar a bilioteca Severgnini Cultura!
                           Volte Sempre!!!""");
        
    }
    
}