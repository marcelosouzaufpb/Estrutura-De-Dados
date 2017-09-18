package questoes;

import java.util.Scanner;
public class Jogo {

	public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String linhaDeEntrada;
        int quant, dig1, letra, dig2, result;

        linhaDeEntrada = leitor.nextLine().trim();
        quant = Integer.parseInt(linhaDeEntrada);

        for (int k = 0; k < quant; k++) {
            linhaDeEntrada = leitor.nextLine().trim();
            dig1 = Character.getNumericValue(linhaDeEntrada.charAt(0));
            dig2 = Character.getNumericValue(linhaDeEntrada.charAt(2));

            if (dig1 == dig2) {
                result = dig1 * dig2;
            } else {
                letra = linhaDeEntrada.charAt(1);
                if (letra >= 97) { //97 é onde começam as letras minúsculas na tabela ASCII
                    result = dig1 + dig2;
                } else {
                    result = dig2 - dig1;
                }
            }
            System.out.println(result);
        }
        leitor.close();
    }
}
