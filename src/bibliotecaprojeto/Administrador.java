package bibliotecaprojeto;
public class Administrador {
    private String nomeAdm;
    private String codigo;

    public Administrador(String nomeAdm, String codigo) {
        this.nomeAdm = nomeAdm;
        this.codigo = codigo;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nomeAdm;
    }

    public void setNome(String nomeAdm) {
        this.nomeAdm = nomeAdm;
    }
    
    
    
    
}
