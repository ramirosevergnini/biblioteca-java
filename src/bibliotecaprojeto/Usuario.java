package bibliotecaprojeto;
public class Usuario {
    private String nome;
    private String senhaUsuario;

    public Usuario(String nome, String senhaUsuario) {
        this.nome = nome;
        this.senhaUsuario = senhaUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
    
}
