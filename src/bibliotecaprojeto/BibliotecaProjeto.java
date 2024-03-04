package bibliotecaprojeto;
import java.util.Scanner;

public class BibliotecaProjeto {
    public static void mostrarMenuAdministrador() {
        System.out.println("""
                            O que pretende fazer?
                            (1) Mostar usuarios
                            (2) Realizar emprestimo.
                            (3) Remover livro.
                            (4) Cadastrar livro.
                            (5) Devolver livro emprestado.
                            (6) Sair""");
    } 
    public static void caso1Adm(Biblioteca b1, Boolean sair, Usuario usuarioLogado, Livro novoLivro){
        System.out.println("Opcao Mostrar usuarios selecionada!");
        System.out.println("USUARIOS CADASTRADOS:");
        b1.mostrarUsuarios();
        System.out.println("---------------------");
        casosAdm(sair, b1, usuarioLogado, novoLivro);   
    }
    public static void caso2Adm(Biblioteca b1, Boolean sair, Usuario usuarioLogado, Livro novoLivro){
        System.out.println("Opcao realizar emprestimo selecionada!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Livros disponíveis:");
        b1.mostrarLivros();
        System.out.println("Qual livro deseja retirar?"); 
        String livroEmprestimo = scanner.nextLine();  
        Livro livroEmprestimo1 = b1.buscarLivroPorTitulo(livroEmprestimo);
        if (livroEmprestimo1 != null) {
            b1.realizarEmprestimo(b1, usuarioLogado, novoLivro);
            System.out.println("Empréstimo de "+livroEmprestimo+" para "+usuarioLogado+" realizada coms sucesso!");
        } else {
            System.out.println("Não foi possível realizar o empréstimo.");
        }
        casosAdm(sair, b1, usuarioLogado, novoLivro);   
    }  
    public static void caso3Adm(Biblioteca b1, Boolean sair, Usuario usuarioLogado, Livro novoLivro){
        System.out.println("Opcao realizar remocao de livro selecionada!");
        Scanner livroRemover = new Scanner (System.in);
        System.out.println("Qual livro você deseja retirar?");
        String livroEscolhido = livroRemover.nextLine();
        Livro livroEscolhido1 = b1.buscarLivroPorTitulo(livroEscolhido);
        if (livroEscolhido1!=null) {
            b1.removerLivro(livroEscolhido);
            System.out.println("Livro removido!");
        } else {
            System.out.println("Livro não encontrado na biblioteca.");
        }
        b1.removerLivro(livroEscolhido);
        casosAdm(sair, b1, usuarioLogado, novoLivro);   
    }  
    public static void caso4Adm(Biblioteca b1, Boolean sair, Usuario usuarioLogado, Livro novoLivro){
        System.out.println("Opcao Cadastrar livro selecionada!");
        Scanner cadastroLivro = new Scanner (System.in);
        System.out.println("Qual o nome do livro?");
        String nomeDoLivro  = cadastroLivro.nextLine();
        b1.inserirLivro(nomeDoLivro);
        System.out.println("Livro inserido com sucesso!");
        
        casosAdm(sair, b1, usuarioLogado, novoLivro);      
    }  
    public static void caso5Adm(Biblioteca b1, Boolean sair, Usuario usuarioLogado, Livro novoLivro){   
        System.out.println("Opcção devolver livro selecionada.");
        Scanner livroParaDevolver= new Scanner(System.in);
        System.out.println("Qual livro você deseja devolver?");
        String LivroEscolhidoDevolver = livroParaDevolver.nextLine();
        Livro livroParaDevolver2 = b1.buscarLivroPorTitulo(LivroEscolhidoDevolver);
        if (livroParaDevolver2 != null) {                            
            Emprestimo devolver1 = b1.devolverLivro(usuarioLogado, livroParaDevolver2);                            
            if (devolver1 != null) {                           
                System.out.println("Livro devolvido: " + livroParaDevolver2.getTitulo() +
                                                        " pelo usuário: " + usuarioLogado.getNome());                           
            } else {                          
                System.out.println("Este livro não está emprestado para este usuário.");                         
            }                      
        } else {                       
            System.out.println("Livro não encontrado na biblioteca.");                      
            }                  
        casosAdm(sair, b1, usuarioLogado, novoLivro);   
    }  
    public static void caso6Adm(Boolean sair){
        System.out.println("Opção sair selecionada");
        sair = true;
    }  
    public static void casosAdm(Boolean sair, Biblioteca b1, Usuario usuarioLogado, Livro novoLivro){
        Scanner tecladoAdm = new Scanner(System.in);
        do{
            mostrarMenuAdministrador();
            String opcaoAdm = tecladoAdm.nextLine();
            if (opcaoAdm.equals("1")) {
                caso1Adm(b1, sair, usuarioLogado, novoLivro);
            } else if (opcaoAdm.equals("2")) {
                caso2Adm(b1, sair, usuarioLogado, novoLivro);
            } else if (opcaoAdm.equals("3")) {                      
                caso3Adm(b1, sair, usuarioLogado, novoLivro);
            } else if (opcaoAdm.equals("4")) {
                caso4Adm(b1, sair, usuarioLogado, novoLivro);
            } else if (opcaoAdm.equals("5")) {
                caso5Adm(b1, sair, usuarioLogado, novoLivro);
            } else if (opcaoAdm.equals("6")) {
                caso6Adm(sair);
            } else {               
                System.out.println("Opção incorreta!");
            }
        }while(!sair);    
        
        tecladoAdm.close();
    }    
    public static void mostrarMenuNaoLogado() {
        System.out.println("""
                            Escolha alguma das opcoes abaixo:
                            1) Fazer Login.
                            2) Registrar-se.
                            3) Mostrar livros disponiveis.
                            4) Sair.
                            """);
    }

    public static void mostrarMenuLogado() {
        System.out.println("""
                           Escolha alguma das opcoes abaixo:
                           1) Devolver livro emprestado.
                           2) Realizar emprestimo.
                           3) Mostrar livros disponiveis.
                           4) Sair.
                           """);
    }

    public static void main(String[] args) {
        Biblioteca b1 = new Biblioteca();
        System.out.println();
        
        Administrador adm = new Administrador("Ramiro", "123");
        b1.registrarUsuario(adm);
        
        boolean estadoUsuario = false;
        boolean sair = false;
        
        Scanner teclado = new Scanner(System.in);

        System.out.println("Seja bem-vindo a biblioteca!");
        
        Usuario usuarioLogado = null;
        Livro novoLivro = null;

        do {
            if (!estadoUsuario) {
                mostrarMenuNaoLogado();
            } else {
                mostrarMenuLogado();
            }

            System.out.print("Digite a sua opcao: ");
            String opcao = teclado.nextLine();

            switch (opcao) {
                case "1":
                    if (!estadoUsuario) {
                        System.out.println("Digite seu nome de usuário e senha para fazer login.");
                        
                        System.out.println("Opcao Login selecionada!");
                        Scanner tecladoUsuarioLogin = new Scanner(System.in);
                        System.out.println("Escreva o seu nome:");
                        String nomeUsuarioLogin = tecladoUsuarioLogin.nextLine();
                        System.out.println("Escreva a sua senha:");
                        String senhaUsuario = tecladoUsuarioLogin.nextLine();

                        usuarioLogado = b1.login(nomeUsuarioLogin, senhaUsuario);
                        
                        if (usuarioLogado instanceof Administrador){
                            casosAdm(sair, b1, usuarioLogado, novoLivro);
                        }else if(usuarioLogado != null){
                            System.out.println("Seja muito bem-vindo "+nomeUsuarioLogin);
                            estadoUsuario = true;
                        }else{
                            System.out.println("""
                                Nao foi possivel realizar o login.
                                           ENTRANDO EM CADASTRO NOVAMENTE...""");
                        }
                    }
            
                     
                    else {
                        System.out.println("Opcção devolver livro selecionada.");
                        Scanner livroParaDevolver= new Scanner(System.in);
                        System.out.println("Qual livro você deseja devolver?");
                        String LivroEscolhidoDevolver = livroParaDevolver.nextLine();
                        Livro livroParaDevolver2 = b1.buscarLivroPorTitulo(LivroEscolhidoDevolver);
                        if (livroParaDevolver2 != null) {
                            Emprestimo devolver1 = b1.devolverLivro(usuarioLogado, livroParaDevolver2);
                            if (devolver1 != null) {
                                System.out.println("Livro devolvido: " + livroParaDevolver2.getTitulo() +
                                        " pelo usuário: " + usuarioLogado.getNome());
                            } else {
                                System.out.println("Este livro não está emprestado para este usuário.");
                            }
                        } else {
                            System.out.println("Livro não encontrado na biblioteca.");
                        }
                    }
                          
                    break; 
                    
                case "2":
                    if (!estadoUsuario) {
                        System.out.println("Opção registrar-se selecionada.");
                        System.out.println("Opcao Register selecionada!");
                        Scanner tecladoUsuarioRegister = new Scanner(System.in);
                        System.out.println("Escreva o seu nome:");
                        String nomeUsuarioRegistro = tecladoUsuarioRegister.nextLine();
                        System.out.println("Escreva sua senha:");
                        String senhaUsuarioRegistro = tecladoUsuarioRegister.nextLine();
                        b1.registrarUsuario(nomeUsuarioRegistro, senhaUsuarioRegistro);
                        System.out.println("Usuario e senha registrados com sucesso!");
                        break;
                    } else {
                        System.out.println("Opcao realizar emprestimo selecionada!");
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Livros disponíveis:");
                        b1.mostrarLivros();
                        System.out.println("Qual livro deseja retirar?"); 
                        String livroEmprestimo = scanner.nextLine();  
                        Livro livroEmprestimo1 = b1.buscarLivroPorTitulo(livroEmprestimo);
                        if (livroEmprestimo1 != null) {
                            b1.realizarEmprestimo(b1, usuarioLogado, novoLivro);
                            System.out.println("Empréstimo de "+livroEmprestimo+" para "+usuarioLogado+" realizada coms sucesso!");
                        } else {
                            System.out.println("Não foi possível realizar o empréstimo.");
                        }
                    }
   
                        break;   

                    
                case "3":
                    
                    System.out.println("---------------------");
                    System.out.println("LIVROS DA BIBLIOTECA:");
                    b1.mostrarLivros();
                    System.out.println("---------------------");
                    break;
                case "4":
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (!sair);

        System.out.println("Obrigado por usar a biblioteca!");
        teclado.close();
    }
}
        
