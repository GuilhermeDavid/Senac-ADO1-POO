package application;

import java.util.Scanner;

import entities.Funcionario;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("*Bem vindo ao sistema de calculo de salário, favor escolher uma opção*");

        int dec;
        char decHoraExtra, decBonus;
        double horaExtra = 0, bonus = 0;
        //Critério 3
        do {
            //Critério 5 e Critério 4
            System.out.print("1-Novo holerite\n0-Encerrar programa\ndigite:");
            dec = sc.nextInt();

            if (dec == 1) {
                System.out.print("Digite o nome do funcionario: ");
                String nome = sc.next();

                System.out.print("Digite o salário bruto deste funcionario: ");
                double salarioBruto = sc.nextDouble();

                System.out.print("Esse funcionário trabalhou horas extras?(s/n): ");

                do {
                    decHoraExtra = sc.next().charAt(0);
                    //Critério 2
                    if (decHoraExtra != 's' && decHoraExtra != 'n') {
                        System.out.print("Opção invalida, favor digitar 's' para sim ou 'n' para não: ");

                    }
                    if (decHoraExtra == 's') {
                        System.out.print("Valor da hora extra do funcionário: ");
                        horaExtra = sc.nextDouble();
                    }
                } while (decHoraExtra != 's' && decHoraExtra != 'n');

                System.out.print("Esse funcionário tem bônus a receber?(s/n): ");

                do {
                    decBonus = sc.next().charAt(0);

                    if (decBonus != 's' && decBonus != 'n') {
                        System.out.print("Opção invalida, favor digitar 's' para sim ou 'n' para não: ");

                    }
                    if (decBonus == 's') {
                        System.out.print("Valor do bônus do funcionário: ");
                        bonus = sc.nextDouble();
                    }
                } while (decBonus != 's' && decBonus != 'n');

                Funcionario funcionario = new Funcionario(salarioBruto, horaExtra, bonus, nome);
                //Critério 6
                horaExtra = (Double) 0.0;

                bonus = (Double) 0.0;

                System.out.println(funcionario);
                System.out.println();
                System.out.println();

            }
        } while (dec != 0);

        System.out.println("Obrigado por usar nosso sistema");

        sc.close();
    }
}
