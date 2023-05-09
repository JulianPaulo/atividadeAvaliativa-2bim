import java.time.LocalDate;
import java.time.LocalDateTime;

public class Usuario {
    private String codigo;
    private String nome;
    private String senha;
    private int tentativasAcesso;
    private boolean primeiroAcesso;
    private LocalDateTime dataDeInativacao;
    private statusUsuarioEnum status;

    public Usuario(){
        this.senha = "etec#123";
        this.primeiroAcesso = true;
        this.status = statusUsuarioEnum.ATIVO;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
        primeiroAcesso = false;
        status = statusUsuarioEnum.ATIVO;
        tentativasAcesso = 0;
    }

    void inativar(){
        dataDeInativacao = LocalDateTime.now();
        primeiroAcesso = false;
        status = statusUsuarioEnum.INATIVO;
    }

    void exibir(){
        System.out.println("Código: " + codigo);
        System.out.println("Usuário: " + nome);
        System.out.println("Senha: " + senha);
        System.out.println("Trocar senha: " + primeiroAcesso);
        System.out.println("Status: " + status);
    }

    String autenticar(String senhaInformadaPeloUsuario){
        if(status == statusUsuarioEnum.INATIVO || status == statusUsuarioEnum.BLOQUEADO) {
            return "Acesso Negado";
        } else if(tentativasAcesso >= 3) {
            status = statusUsuarioEnum.BLOQUEADO;
            return "Acesso Negado";
        } else if(senha == senhaInformadaPeloUsuario){
            tentativasAcesso = 0;
            return "Acesso Liberado";
        } else {
            tentativasAcesso++;
            return "Usuario/Senha invalidos";
        }

    }

    public int getTentativasAcesso() {
        return tentativasAcesso;
    }

    public void setTentativasAcesso(int tentativasAcesso) {
        this.tentativasAcesso = tentativasAcesso;
    }

    public boolean isPrimeiroAcesso() {
        return primeiroAcesso;
    }

    public void setPrimeiroAcesso(boolean primeiroAcesso) {
        this.primeiroAcesso = primeiroAcesso;
    }

    public LocalDateTime getDataDeInativacao() {
        return dataDeInativacao;
    }

    public void setDataDeInativacao(LocalDateTime dataDeInativacao) {
        this.dataDeInativacao = dataDeInativacao;
    }

    public statusUsuarioEnum getStatus() {
        return status;
    }

    public void setStatus(statusUsuarioEnum status) {
        this.status = status;
    }
}
