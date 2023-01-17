package TPDOO;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void menu() {
        System.out.println("________________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println("Sistema para a classificação de candidatos");
        System.out.println("Selecione uma opção:");
        System.out.print("""
                1- Cadastrar candidato docente.
                2- Cadatrar candidato TAE.
                3- Listar candidatos docente.
                4- Listar candidatos TAE.
                5- Listar o 1º colocado docente.
                6- Listar o 1º colocado TAE.
                9- Sair
                """);
    }

    public static Professor cadastraProfessor() {
        Scanner inpt = new Scanner(System.in);
        String nome, endereco, email, telefone;
        char habilitacao = 'x';
        int formacao=0, exp = -1;
        int[] nota = new int[]{-1,-1,-1};
        System.out.println("Qual o nome do candidato?");
        nome = inpt.nextLine();
        System.out.println("Qual o e-mail do candidato?");
        email = inpt.nextLine();
        System.out.println("Qual o endereço do candidato?");
        endereco = inpt.nextLine();
        System.out.println("Qual o telefone do candidato?");
        telefone = inpt.nextLine();
        while (formacao < 1 || formacao > 4){
            try {
                System.out.print("""
                Qual a escolaridade do candidato?
                1- Doutorado
                2- Mestrado
                3- Especialização com 360 horas
                4- Especialização com 180 horas
                """);
                formacao = inpt.nextInt();
                if (formacao < 1 || formacao > 4){
                    System.out.printf("O numero %d não faz parte da seleção, por favor digite um numero valido dentre as opções: \n",formacao);
                }
            }catch (InputMismatchException f) {
                System.out.println("Você digitou um charactere, por favor, digite um numero correspondente as opções.");
            }
            inpt.nextLine();
        }
        while ((habilitacao != 'S') && (habilitacao != 's') && (habilitacao != 'N') && (habilitacao != 'n')) {
            System.out.println("O candidato possui licenciatura plena ou habilitação pedagogica? Digite 'S' para sim e 'N' para não");
            habilitacao = inpt.next().charAt(0);
            if ((habilitacao != 'S') && (habilitacao != 's') && (habilitacao != 'N') && (habilitacao != 'n')){
                System.out.printf("O char/numero %c não faz parte da seleção, por favor digite 'S' para sim e 'N' para não: \n",habilitacao);
            }
        }
        while (exp < 0){
            System.out.println("Qual a experiência em magistério do candidato? (Em anos)");
            try {
                exp = inpt.nextInt();
                if (exp < 0){
                    System.out.println("Você digitou um numero negativo, por favor digite um numero maior que 0:");
                }
            }catch (InputMismatchException f){
                System.out.println("Você digitou um charactere, por favor, digite um valor para experiencia que seja maior ou igual a zero.");
            }
            inpt.nextLine();
        }

        System.out.println("Prova didatica - Informe as três notas das provas: (Separadas por Enter e somenta valores de 0 a 100)");
        for (int i = 0; i < 3; i++){
            while (nota[i] > 100 || nota[i] < 0){
                try {
                    nota[i] = inpt.nextInt();
                    if(nota[i] > 100 || nota[i] < 0){
                        System.out.println("Você digitou um numero negativo ou maior q 100, por favor, digite um numero correspondente ao limite de 0 a 100.");
                    }
                } catch (InputMismatchException f){
                    System.out.println("Você digitou um charactere, por favor, digite um numero correspondente ao limite de 0 a 100.");
                }
                inpt.nextLine();
            }
        }
        return new Professor(nome,email,telefone,endereco,formacao,exp,nota,habilitacao);
    }

    public static TAE cadastraTAE() {
        Scanner inpt = new Scanner(System.in);
        String nome, endereco, email, telefone;
        int formacao=0, exp = -1;
        System.out.println("Qual o nome do candidato?");
        nome = inpt.nextLine();
        System.out.println("Qual o e-mail do candidato?");
        email = inpt.nextLine();
        System.out.println("Qual o endereço do candidato?");
        endereco = inpt.nextLine();
        System.out.println("Qual o telefone do candidato?");
        telefone = inpt.nextLine();
        while (formacao < 1 || formacao > 6) {
            try {
                System.out.print("""
                    Qual a escolaridade do candidato?
                    1- Doutorado
                    2- Mestrado
                    3- Especialização com 360 horas
                    4- Especialização com 180 horas
                    5- Curso superior
                    6- Nivel Médio
                    """);
                formacao = inpt.nextInt();
                if (formacao < 1 || formacao > 6) {
                    System.out.printf("O numero %d não faz parte da seleção, por favor digite um numero valido dentre as opções: \n", formacao);
                }
            }catch (InputMismatchException f){
                System.out.println("Você digitou um charactere, por favor, digite um numero correspondente as opções.");
            }
            inpt.nextLine();
        }
        while (exp < 0){
            System.out.println("Qual o tempo de experiência do candidato? (Em anos)");
            try {
                exp = inpt.nextInt();
                if (exp < 0){
                    System.out.println("Você digitou um numero negativo, por favor digite um numero maior que 0:");
                }
            }catch (InputMismatchException f){
                System.out.println("Você digitou um charactere, por favor, digite um valor para experiencia que seja maior ou igual a zero.");
            }
            inpt.nextLine();
        }
        return new TAE(nome, email, telefone, endereco, formacao, exp);
    }


    public static void main(String[] args) {
        ArrayList<TAE> quadroTAE = new ArrayList<TAE>();
        ArrayList<Professor> quadroProfessor = new ArrayList<Professor>();
        Scanner inpt = new Scanner(System.in);
        int opt = 0;
        while (true) {
            menu();
            try {
                opt = inpt.nextInt();
            }catch (InputMismatchException f){
                System.out.println("Você digitou um charactere, por favor, digite um numero correspondente as opções.");
            }
            inpt.nextLine();

            switch (opt){
                case 1:
                    quadroProfessor.add(cadastraProfessor());
                    break;

                case 2:
                    quadroTAE.add(cadastraTAE());
                    break;

                case 3:
                    System.out.printf("%30s | %30s | %11s | %45s | %60s | %5s\n", "NOME", "E-MAIL","TELEFONE", "ENDEREÇO", "FORMAÇÃO", "PONTUAÇÃO" );
                    System.out.println("________________________________________________________________________________________________________________________________________________________________________________________________________" );
                    for (Professor professor : quadroProfessor){
                        professor.listarCandidato();
                    }
                    break;

                case 4:
                    System.out.printf("%30s | %30s | %11s | %45s | %60s | %5s\n", "NOME", "E-MAIL","TELEFONE", "ENDEREÇO", "FORMAÇÃO", "PONTUAÇÃO" );
                    System.out.println("________________________________________________________________________________________________________________________________________________________________________________________________________" );
                    for (TAE tae : quadroTAE){
                        tae.listarCandidato();
                    }
                    break;

                case 5:
                    if (!quadroProfessor.isEmpty()) {
                        System.out.println("O docente 1º colocado é:");
                        System.out.printf("%30s | %30s | %11s | %45s | %60s | %5s\n", "NOME", "E-MAIL","TELEFONE", "ENDEREÇO", "FORMAÇÃO", "PONTUAÇÃO" );
                        System.out.println("________________________________________________________________________________________________________________________________________________________________________________________________________" );
                        Professor maiorProf = quadroProfessor.get(0);
                        for (Professor professor : quadroProfessor) {
                            if (professor.getPontos() > maiorProf.getPontos()) {
                                maiorProf = professor;
                            }
                        }
                        maiorProf.listarCandidato();
                    }else
                        System.out.println("Não existe nenhum candidato na Lista");
                    break;

                case 6:
                    if (!quadroTAE.isEmpty()) {
                        System.out.println("O TAE 1º colocado é:");
                        System.out.printf("%30s | %30s | %11s | %45s | %60s | %5s\n", "NOME", "E-MAIL","TELEFONE", "ENDEREÇO", "FORMAÇÃO", "PONTUAÇÃO" );
                        System.out.println("________________________________________________________________________________________________________________________________________________________________________________________________________" );
                        TAE maiorTAE = quadroTAE.get(0);
                        for (TAE tae : quadroTAE) {
                            if (tae.getPontos() > maiorTAE.getPontos()) {
                                maiorTAE = tae;
                            }
                        }
                        maiorTAE.listarCandidato();
                    }else
                        System.out.println("Não existe nenhum candidato na Lista");
                    break;

                case 9:
                    inpt.close();
                    return;

                default:
                    System.out.printf("O numero %d não é uma opção valida, por favor digite uma opção de acordo! \n",opt);
                    break;
            }
        }
    }
}