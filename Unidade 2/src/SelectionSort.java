
public class SelectionSort  {
	public static void Selection(int [] vetor){
		int indMenor;
		int menor;
		for(int i = 0; i < vetor.length; i++ ){
			indMenor = i;
			menor = vetor[i];
			for(int j = i+1; j< vetor.length; j ++ ){
				if(vetor[j] < menor){
					indMenor = j;
					menor = vetor[j];
				}
			}
			vetor[indMenor] = vetor[i];
			vetor[i] = menor;
		}
		
	}
	public static void main (String[] args){
		int [] vetor = {2,4,1,5,2,57,42,3};
		Selection(vetor);
		for(int i = 0; i< vetor.length; i ++){
			System.out.println(vetor[i]);
		}
	}
}
