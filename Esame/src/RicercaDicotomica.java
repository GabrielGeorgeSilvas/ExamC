
import java.util.Arrays;

public class RicercaDicotomica 
{

	public static int cerca(int[] a, int x) 
	{
		int i = 0; // Indice che scorre da sinistra verso destra.
		int j = a.length - 1;// Indice che scorre da destra verso sinistra.
		
		for (;;) 
		{ 
			// Uso un for infinito per scorrere tutto l'array.
			System.out.println("cerca in a "+ Arrays.toString(a) + " da "+ i + " a "+ j);
			int m = (i + j) / 2; // Calcolo elemento centrale.
			if (a[m] == x) // Se è uguale alla metà, ritorno la metà.
				return m;
			if (a[m] < x) 
			{ 
				// Se è maggiore della metà, scorro da destra.
				i = m + 1;
			} 
			else 
			{ 
				// Altrimenti, scorro da sinistra perchè sarà minore della metà.
				j = m - 1;
			}
			if (j<i) // Nel momento in cui j<i, significa che con l'indice 
					 // sinistro ho superato la metà e quindi non ho trovato
					 // l'elemento.
				return -1;
		}
	}
	
	public static void main(String[] args) 
	{
		int[] test = {1,4,7,9,10};
		System.out.println(cerca(test, 10));
		System.out.println(cerca(test, 40));
		System.out.println(Arrays.binarySearch(test, 10));
	}
}
