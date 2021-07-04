package src;

public class Simulacao {

    private String cpf;
    private String nome;
    private String email;
    private float valor;
    private Integer parcelas;
    private Boolean seguro;

    public Simulacao() {
    }

    public Simulacao(String cpf, String nome, String email, float valor, Integer parcelas, Boolean seguro) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.valor = valor;
        this.parcelas = parcelas;
        this.seguro = seguro;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }

    public Boolean getSeguro() {
        return seguro;
    }

    public void setSeguro(Boolean seguro) {
        this.seguro = seguro;
    }

}
