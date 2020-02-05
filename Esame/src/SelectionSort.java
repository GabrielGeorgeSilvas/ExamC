public class SelectionSort 
{
	public static void selectionSort(int [] array) 
	{

		for(int i = 0; i < array.length-1; i++) 
		{
			int minimo = i; //Partiamo dall'i-esimo elemento.
			for(int j = i+1; j < array.length; j++) 
			{
				//Qui avviene la selezione. Ogni volta
				//che nell' iterazione troviamo un elemento piú piccolo di minimo
				//facciamo puntare minimo all'elemento trovato.
				if(array[minimo]>array[j]) 
				{
					minimo = j;
				}
			}

			//Se minimo e diverso dall'elemento di partenza
			//allora avviene lo scambio.
			if(minimo!=i) 
			{ 
				int k = array[minimo];
				array[minimo]= array[i];
				array[i] = k;
			}
		}
	}
	
	static void stampa(int[] array) 
	{
		for(int i=0; i<array.length; i++) 
		{
			System.out.println(array[i]);
		}
	}
	
	public static void main(String[] args) 
	{
		int[] valori= {23,556,12,3,2,1,34};
		
		stampa(valori);
		selectionSort(valori);
		stampa(valori);
	}

}
