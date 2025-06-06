import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Estatistica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> valores = new ArrayList<>();

        System.out.println("Digite valores numéricos (vazio para sair):");

        while (true) {
            System.out.print("Informe um valor: ");
            String entrada = scanner.nextLine();

            if (entrada.isBlank()) {
                break;
            }

            try {
                double valor = Double.parseDouble(entrada);
                valores.add(valor);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número válido.");
            }
        }

        if (valores.isEmpty()) {
            System.out.println("Nenhum valor informado.");
        } else {
            double media = calcularMedia(valores);
            double moda = calcularModa(valores);
            double minimo = calcularMinimo(valores);
            double maximo = calcularMaximo(valores);
            double desvioPadrao = calcularDesvioPadrao(valores, media);

            System.out.printf("Média = %.3f\n", media);
            System.out.printf("Moda = %.3f\n", moda);
            System.out.printf("Mínimo = %.3f\n", minimo);
            System.out.printf("Máximo = %.3f\n", maximo);
            System.out.printf("Desvio Padrão = %.3f\n", desvioPadrao);
        }

        scanner.close();
    }

    public static double calcularMedia(ArrayList<Double> lista) {
        double soma = 0;
        for (double num : lista) {
            soma += num;
        }
        return soma / lista.size();
    }

    public static double calcularModa(ArrayList<Double> lista) {
        HashMap<Double, Integer> frequencia = new HashMap<>();
        for (double num : lista) {
            frequencia.put(num, frequencia.getOrDefault(num, 0) + 1);
        }

        double moda = lista.get(0);
        int maxFreq = 0;

        for (Map.Entry<Double, Integer> entry : frequencia.entrySet()) {
            if (entry.getValue() > maxFreq) {
                moda = entry.getKey();
                maxFreq = entry.getValue();
            }
        }
        return moda;
    }

    public static double calcularMinimo(ArrayList<Double> lista) {
        double min = lista.get(0);
        for (double num : lista) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static double calcularMaximo(ArrayList<Double> lista) {
        double max = lista.get(0);
        for (double num : lista) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static double calcularDesvioPadrao(ArrayList<Double> lista, double media) {
        double somaQuadrados = 0;
        for (double num : lista) {
            somaQuadrados += Math.pow(num - media, 2);
        }
        return Math.sqrt(somaQuadrados / lista.size());
    }
}
