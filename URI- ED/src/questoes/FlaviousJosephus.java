import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlaviousJosephus {

	public static class No {
		int proximo;
		int anterior;
		int pessoa;
		int indexNaLista;

		public No(int pro, int ant, int pos, int ind) {
			this.proximo = pro;
			this.anterior = ant;
			this.pessoa = pos;
			this.indexNaLista = ind;
		}
	}

	public static void criaListaDuplamenteEncadeada(int qtdePessoas, List<No> nos) {
		for (int i = 1; i < qtdePessoas + 1; i++) {
			int prox = i;
			int ant = i - 2;
			int eu = i;
			int ind = i - 1;
			if (i == qtdePessoas) {
				prox = 0;
			}
			if (i == 1) {
				ant = qtdePessoas - 1;
			}
			nos.add(new No(prox, ant, eu, ind));
		}
	}

	public static void exibeCase(No no, int n) {
		System.out.println("Case " + (n + 1) + ": " + no.pessoa);
	}

	public static No josephus(int comeco, int pulo, List<No> nos, int qtdeM) {
		if (qtdeM == nos.size() - 1) {
			return nos.get(nos.get(comeco).proximo);
		}
		int eliminado[] = elimina(comeco, pulo, nos, qtdeM);
		return josephus(eliminado[0], pulo, nos, eliminado[1]);
	}

	public static int[] elimina(int comeco, int pulo, List<No> nos, int qtdeMortos) {
		No temp = nos.get(comeco);
		for (int i = 0; i < pulo; i++) {
			temp = nos.get(temp.proximo);
		}
		nos.get(temp.anterior).proximo = nos.get(temp.proximo).indexNaLista;
		// anterior de temp tem como prox o prox de temp
		nos.get(temp.proximo).anterior = nos.get(temp.anterior).indexNaLista;
		// prox de temp tem como anterior o anterior de temp
		return new int[] { temp.indexNaLista, qtdeMortos + 1 };
	}

	public static void main(String[] args) {
		Scanner digitado = new Scanner(System.in);
		int nc = Integer.parseInt(digitado.nextLine());
		for (int i = 0; i < nc; i++) {
			String qp[] = digitado.nextLine().split(" ");
			int qtdePessoas = Integer.parseInt(qp[0]);
			int pulo = Integer.parseInt(qp[1]);
			List<No> nos = new ArrayList<No>();
			criaListaDuplamenteEncadeada(qtdePessoas, nos);
			exibeCase(josephus(qtdePessoas - 1, pulo, nos, 0), i);
		}
		digitado.close();

	}
}
