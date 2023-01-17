package TPDOO;

public class TAE extends Funcionario{
    public TAE(String nome, String email, String telefone, String endereco, int formacaoCod, int exp) {
        super(nome, email, telefone, endereco, formacaoCod, exp);
        this.calculaPontos();
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

            case 5:
                this.pontos += 5;
                this.formacaoPorEscrito = "Curso superior";
                break;

            case 6:
                this.pontos += 3;
                this.formacaoPorEscrito = "Nivel Médio";
                break;
        }
        this.pontos += this.exp;
    }

}