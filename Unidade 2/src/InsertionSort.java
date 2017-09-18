public class InsertionSort{
	public static void Insertion(int [] vetor){
		int i;
		int j;
		int chave;
		for(j = 1; j < vetor.length; j++){
			chave = vetor[j];
			i = j-1;
			while(i >= 0 && vetor[i] > chave){
				vetor[i+1] = vetor[i];
				i--;
			}
			vetor[i+1] = chave;
		}
	}
	public static void main(String [] args){
		int [] vetor = {2,4,1,5,2,57,42,3};
		Insertion(vetor);
		for(int i = 0; i< vetor.length; i ++){
			System.out.println(vetor[i]);
		}
	}
}