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
    public static void caso1Adm(Biblioteca b1, Boolean sair){
        System.out.println("Opcao Mostrar usuarios selecionada!");
        System.out.println("USUARIOS CADASTRADOS:");
        b1.mostrarUsuarios();
        System.out.println("---------------------");
        casosAdm(sair, b1);
    }
    public static void caso2Adm(Biblioteca b1, Boolean sair){
        System.out.println("Opcao realizar emprestimo selecionada!");
        Emprestimo e1 = b1.realizarEmprestimo(b1, usuarioLogado, novoLivro);
        if(e1 == null) {
            System.out.println("Não foi possível realizar o emprestimo!");
        }else{
            System.out.println("Emprestimo do livro: "+novoLivro+" para o(a) "+usuarioLogado+" realizado com sucesso");
        }
        casosAdm(sair, b1);
    }  
    public static void caso3Adm(Biblioteca b1, Boolean sair){
        System.out.println("Opcao realizar remocao de livro selecionada!");
        Scanner livroRemover = new Scanner (System.in);
        System.out.println("Qual livro você deseja retirar?");
        String livroEscolhido = livroRemover.nextLine();
        if (livroRemover != null) {
            livros.remove(livroRemover);
            System.out.println("Livro removido: " + livroRemover.getTitulo());
        } else {
            System.out.println("Livro não encontrado na biblioteca.");
        }
        b1.removerLivro(livroEscolhido);
        casosAdm(sair, b1);
    }  
    public static void caso4Adm(Biblioteca b1, Boolean sair){
        System.out.println("Opcao Cadastrar livro selecionada!");
        System.out.println("Senha correta!");
        Scanner cadastroLivro = new Scanner (System.in);
        System.out.println("Qual o nome do livro?");
        String nomeDoLivro  = cadastroLivro.nextLine();
        Livro livroEscolhido = b1.buscarLivroPorTitulo(nomeDoLivro);
        if (livroEscolhido != null){
            b1.inserirLivro(nomeDoLivro);
            System.out.println("Livro inserido com sucesso!");
        }else{
            System.out.println("Livro não encontrado.");
        }
        casosAdm(sair, b1);      
    }  
    public static void caso5Adm(Biblioteca b1, Boolean sair){   
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
        casosAdm(sair, b1);
    }  
    public static void caso6Adm(Boolean sair){
        System.out.println("Opção sair selecionada");
        sair = true;
    }  
    public static void casosAdm(Boolean sair, Biblioteca b1){
        Scanner tecladoAdm = new Scanner(System.in);
        do{
            mostrarMenuAdministrador();
            String opcaoAdm = tecladoAdm.nextLine();
            if (opcaoAdm.equals("1")) {
                caso1Adm(b1, sair);
            } else if (opcaoAdm.equals("2")) {
                caso2Adm(b1, sair);
            } else if (opcaoAdm.equals("3")) {                      
                caso3Adm(b1, sair);
            } else if (opcaoAdm.equals("4")) {
                caso4Adm(b1, sair);
            } else if (opcaoAdm.equals("5")) {
                caso5Adm(b1, sair);
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
        
        Livro l1 = new Livro("Minecraft");
        b1.inserirLivro1(l1);
        Livro l2 = new Livro("Raio");
        b1.inserirLivro1(l2);
        Livro l3 = new Livro("Futebol");
        b1.inserirLivro1(l3);
        
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
                        
                        if (usuarioLogado != null){
                            System.out.println("Seja muito bem-vindo "+nomeUsuarioLogin);
                            estadoUsuario = true;
                        }else if(usuarioLogado == administrador){
                            casosAdm(sair, b1);
                            
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
                        Emprestimo e1 = b1.realizarEmprestimo(b1, usuarioLogado, l2);
                        if(e1 == null) {
                        System.out.println("Não foi possível realizar o emprestimo!");
                        }else{
                        System.out.println("Emprestimo do livro: "+l2+" para o(a) "+usuarioLogado+" realizado com sucesso");
                        }
                        
                        break;   

                    }
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
        
        
        
        
        
        
        
        
        
/*        Biblioteca b1 = new Biblioteca();
        boolean sair = false;
        boolean reiniciarCadastro = false;            
        boolean sairAdm = false;
        /*Livro l1 = new Livro("Minecraft");
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
                                    if (livroRemover != null) {
                                            livros.remove(livroRemover);
                                            System.out.println("Livro removido: " + livroRemover.getTitulo());
                                        } else {
                                            System.out.println("Livro não encontrado na biblioteca.");
                                            }
                                        }
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
    */}
}

                           
