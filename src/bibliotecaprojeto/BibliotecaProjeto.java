package bibliotecaprojeto;
import java.util.Scanner;
public class BibliotecaProjeto {
    public static void main(String[] args) {
        Biblioteca b1 = new Biblioteca();
        boolean sair = false;
        boolean reiniciarCadastro = false;            
        boolean sairAdm = false;
        /*Livro l1 = new Livro("Minecraft");
        b1.inserirLivro1(l1);
        Usuario u1 = new Usuario("Ramiro", "1234");
        b1.inserirUsuario1(u1);   */     
        
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
                            while (!sair){
                            Scanner lerAlternativa = new Scanner(System.in);
                            String cli;
                            System.out.println("""
                                               O que pretende fazer?
                                               (1) Mostrar livros.
                                               (2) Selecione seu livro.
                                               (3) Realizar emprestimo.
                                               (4) Sair""");
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
                                case "3":
                                    System.out.println("Opcao realizar emprestimo selecionada!");
                                    Emprestimo e1 = b1.realizarEmprestimo(b1, usuarioLogado, novoLivro);
                                    if(e1 == null) {
                                        System.out.println("Não foi possível realizar o emprestimo!");
                                    }else{
                                        System.out.println("Emprestimo do livro: "+novoLivro+" para o(a) "+usuarioLogado+" realizado com sucesso");
                                    }
                                    break;   

                                case "4":
                                    System.out.println("Saindo da biblioteca...");
                                    sair = true;


                                default:  
                                    System.out.println("Você selecionou um número errado.");
                            }

                        }
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
                    System.out.println("Usuario e senha registrados com sucesso!");
                    
                    break;
                }
                }
                
            case"2":
                
                System.out.println("Faça o login como administrador!");
                Scanner nomeAdmLogin = new Scanner(System.in);                    
                    System.out.println("Coloque seu nome:");
                    String lerSenha = nomeAdmLogin.nextLine();
                    String senhaAdm = b1.colocarSenha(lerSenha);
                    if(!lerSenha.equals(senhaAdm)){
                        System.out.println("Senha incorreta!");
                    }
                    else{
                        System.out.println("Senha correta!");
                        while (!sairAdm){
                            Scanner lerAlternativa = new Scanner(System.in);
                            String cliAdm;
                            System.out.println("""
                                               O que pretende fazer?
                                               (1) Mostar usuarios
                                               (2) Realizar emprestimo.
                                               (3) Remover livro.
                                               (4) Cadastrar livro.
                                               (5) Sair""");
                            cliAdm = lerAlternativa.nextLine();
                            switch(cliAdm){
                                case "1":

                                    System.out.println("Opcao Mostrar usuarios selecionada!");
                                    System.out.println("USUARIOS CADASTRADOS:");
                                    b1.mostrarUsuarios();
                                    System.out.println("---------------------");
                                    break;
                                    
                                case "2":
                                    
                                    System.out.println("Opcao realizar emprestimo selecionada!");
                                    Emprestimo e1 = b1.realizarEmprestimo(b1, usuarioLogado, novoLivro);
                                    if(e1 == null) {
                                        System.out.println("Não foi possível realizar o emprestimo!");
                                    }else{
                                        System.out.println("Emprestimo do livro: "+novoLivro+" para o(a) "+usuarioLogado+" realizado com sucesso");
                                    }
                                    break;   
                                    
                                case "3":
                                    
                                    System.out.println("Opcao realizar remocao de livro selecionada!");
                                    Scanner livroRemover = new Scanner (System.in);
                                    System.out.println("Qual livro você deseja retirar?");
                                    String livroEscolhido = livroRemover.nextLine();
                                    b1.removerLivro(livroEscolhido);
                                    break;
                                    
                                case "4":
                                    System.out.println("Opcao Cadastrar livro selecionada!");
                                    System.out.println("Senha correta!");
                                    Scanner cadastroLivro = new Scanner (System.in);
                                    System.out.println("Qual o nome do livro");
                                    String nomeDoLivro  = cadastroLivro.nextLine();
                                    b1.inserirLivro(nomeDoLivro);
                                    break;
                                    
                                case "5":
                                    sairAdm=true;
                                    break;
                                    
                                default:  
                                    System.out.println("Você selecionou um número errado.");    
                            }
                        }
                    }
        }
    


        loopPrincipal:
        
        System.out.println("""
                           Muito obrigado por por visitar a bilioteca Severgnini Cultura!
                           Volte Sempre!!!""");
    }
}

                           
