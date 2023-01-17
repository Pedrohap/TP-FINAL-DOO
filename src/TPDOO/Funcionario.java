package TPDOO;

public abstract class Funcionario implements Operacoes {
    protected String nome;
    protected String email;
    protected String telefone;
    protected String endereco;
    protected String formacaoPorEscrito;
    protected int formacaoCod;
    protected int pontos;
    protected int exp;

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFormacaoPorEscrito() {
        return formacaoPorEscrito;
    }

    public void setFormacaoPorEscrito(String formacaoPorEscrito) {
        this.formacaoPorEscrito = formacaoPorEscrito;
    }

    public int getFormacaoCod() {
        return formacaoCod;
    }

    public void setFormacaoCod(int formacaoCod) {
        this.formacaoCod = formacaoCod;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void listarCandidato() {
        System.out.printf("%30s | %30s | %11s | %45s | %60s | %5s\n", this.nome, this.email,this.telefone, this.endereco, this.formacaoPorEscrito, this.pontos );
    }

    public Funcionario(String nome, String email, String telefone, String endereco, int formacaoCod, int exp) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.formacaoCod = formacaoCod;
        this.exp = exp;
    }

}
