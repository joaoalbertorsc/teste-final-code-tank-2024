import java.util.Scanner;

public class CalculoSalario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double salariosBrutos[] = new double[5];

        int j = 0;
        System.out.println("--- CALCULO DE SALARIO ---");
        for (int i = 0; i < salariosBrutos.length; i++) {
            j++;
            System.out.println("Digite o salario da posição " + j + ":");
            try {
                salariosBrutos[i] = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("ERRO: DIGITE APENAS O VALOR DO SALARIO.");
                i--;
                j--;
            }
        }

        j = 0;
        for (double salarioBruto : salariosBrutos) {
            j++;
            System.out.println("--- SALARIO DA POSIÇÃO " + j + "---");
            System.out.println("Salario bruto: R$" + salarioBruto);
            System.out.println("Quanto pagou ao INSS: R$" + descontoDoInss(salarioBruto));
            System.out.println("Quanto pagou de Imposto de Renda: R$" + descontoDoImpostoDeRenda(salarioBruto));
            System.out.println("Salario líquido: R$" + salarioLiquido(salarioBruto));
            System.out.println();
        }
        scanner.close();
    }
    public static double descontoDoInss(double salarioBruto){
        double descontoInss;
        if (salarioBruto <= 1212){
            descontoInss = salarioBruto * 0.075;
        } else if (salarioBruto >= 1212.01 && salarioBruto <= 2427.35) {
            descontoInss = salarioBruto * 0.09;
        } else if (salarioBruto >=  2427.36 && salarioBruto <= 3641.03) {
            descontoInss = salarioBruto * 0.12;
        } else {
            descontoInss = salarioBruto * 0.14;
        }
        return descontoInss;
    }

    public static double descontoDoImpostoDeRenda(double salarioBruto){
        double descontoImpostoDeRenda;
        if (salarioBruto <= 1903.98) {
            descontoImpostoDeRenda = salarioBruto * 0;
        } else if (salarioBruto >= 1903.99 && salarioBruto <=  2826.65){
            descontoImpostoDeRenda = salarioBruto * 0.075;
        } else if (salarioBruto >= 2826.66  && salarioBruto <= 3751.05) {
            descontoImpostoDeRenda = salarioBruto * 0.15;
        } else if (salarioBruto >=  3751.06  && salarioBruto <= 4664.68) {
            descontoImpostoDeRenda = salarioBruto * 0.225;
        } else {
            descontoImpostoDeRenda = salarioBruto * 0.275;
        }
        return descontoImpostoDeRenda;
    }
    public static double salarioLiquido(double salarioBruto){
        double salarioLiquido;
        double totalDescontos;
        totalDescontos = descontoDoInss(salarioBruto) + descontoDoImpostoDeRenda(salarioBruto);
        salarioLiquido = salarioBruto - totalDescontos;
        return salarioLiquido;
    }

}
