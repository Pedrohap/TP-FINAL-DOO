package TPDOO;

public class Professor extends Funcionario{
    protected int[] nota = new int[3] ;
    protected char habilitacao;

    public Professor(String nome, String email, String telefone, String endereco, int formacaoCod, int exp, int[] nota, char habilitacao) {
        super(nome, email, telefone, endereco, formacaoCod, exp);
        this.nota = nota;
        this.habilitacao = habilitacao;
        this.calculaPontos();
    }

    public int[] getNota() {
        return nota;
    }

    public void setNota(int[] nota) {
        this.nota = nota;
    }

    public char getHabilitacao() {
        return habilitacao;
    }

    public void setHabilitacao(char habilitacao) {
        this.habilitacao = habilitacao;
    }

    @Override
    public void calculaPontos(){
        this.pontos = 0;

        switch (this.formacaoCod){
            case 1:
                this.pontos += 20;
                this.formacaoPorEscrito = "Doutor";
                break;

            case 2:
                this.pontos += 15;
                this.formacaoPorEscrito = "Mestre";
                break;

            case 3:
                this.pontos += 10;
                this.formacaoPorEscrito = "Especialização com 360 horas";
                break;

            case 4:
                this.pontos += 8;
                this.formacaoPorEscrito = "Especialização com 180 horas";
                break;
        }

        if (this.habilitacao == 's' || this.habilitacao == 'S' ){
            this.pontos += 10;
            this.formacaoPorEscrito += " c/ Lic. Plena/Hab. Pedagogica";
        }

        if (this.exp <=5){
            this.pontos += exp*2;
        }else{
            this.pontos += 10;
        }

        this.pontos += (nota[0] + nota[1] + nota[2])/3;
    }

}
