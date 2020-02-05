import java.util.Arrays;

public class MergeSort
{
	// Ordina l'array a, dalla posizione min alla posizione max.
	static void mergeSort(int[] a, int min, int max) 
	{
		// Se la parte da ordinare ha solo un elemento, ho finito.
		if (min == max)
		{
			return;
		}
		// Altrimenti prendo l'elemento in mezzo.
		int middle = (max + min) / 2;
		// Ordino gli elementi dal min al middle.
		mergeSort(a, min, middle);
		// Ordino dal middle+1 al max.
		mergeSort(a, middle + 1, max);
		// A questo punto, gli elementi da min a middle e da middle a max
		// sono ordinati tra di loro nelle due parti.
		merge(a, min, middle, max);
	}

	// Assume a ordinato da min a middle e da middle +1 a max.
	// Merge degli elementi di a da min a max.
	private static void merge(int[] a, int min, int middle, int max) 
	{
		// Scorro i due sotto array con gli indici sx e dx.
		int sx = min, dx = middle + 1;
		
		// Array di supporto che conterrà gli elementi su cui fare il merge.
		int temp[] = new int[max - min + 1];
		
		for (int i = 0; i < temp.length; i++) 
		{
			// Copio quello di sinistra se minore oppure 
			// ho copiato già tutti quelli di destra
			// ma non ho copiato ancora tutti quelli di sinistra.
			if (dx > max  || (a[sx] < a[dx] && sx <= middle))  
			{
				// Copio a[sx] e incremento sx.
				temp[i] = a[sx];
				sx++;
			} 
			else 
			{
				// Copio a{dx} e incremento dx.
				temp[i] = a[dx];
				dx++;
			}
		}
		// Ricopio temp dentro in a.
		for (int i = 0; i < temp.length; i++)
		{
			a[i + min] = temp[i];
		}
	}

	// Ordina l'array.
	static void mergeSort(int[] a) 
	{
		mergeSort(a, 0, a.length - 1);
	}

	public static void main(String[] args) 
	{
		int[] a = { 2, 6, 5, 4, 5 };
		System.out.println(Arrays.toString(a));
		mergeSort(a);
		System.out.println(Arrays.toString(a));
	}
}
