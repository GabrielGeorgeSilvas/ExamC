import java.util.Arrays;

public class BubbleSort 
{
	static void ordinaBubbleSort(int a[]) 
	{
		boolean scambiato;
		do 
		{
			scambiato = false;
			for (int i = 0; i < a.length - 1; i++) 
			{
				// coppia disordinata
				if (a[i] > a[i + 1]) 
				{
					// scambio
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					scambiato = true;
				}
			}
		} while (scambiato);
	}
	
	static void stampa(int[] array)
	{
			System.out.println(Arrays.toString(array));
	}
	
	public static void main(String[] args) 
	{
		int[] valori= {5,4,2,5,78,1,6,456,453,21};
		stampa(valori);
		ordinaBubbleSort(valori);
		System.out.println();
		stampa(valori);
		
	}
}
