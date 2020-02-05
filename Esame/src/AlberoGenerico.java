/* Albero binario di ricerca (albero ordinato)*/

public class AlberoGenerico<E extends Comparable<E>> 
{

	// Definisco la classe NodoAlbero.
	class NodoAlbero{
		E dato;
		AlberoGenerico<E> sx;
		AlberoGenerico<E> dx;
	}
	
	NodoAlbero radice;
	
	// Costrutture.
	public AlberoGenerico() 
	{
		radice = null;
	}
	
	// Inserisco un elemento all'interno dell'albero.
	public void insert(E x)
	{
		// Se la radice � nulla.
		if (radice == null)
		{
			// Inserisci l'elemento nella radice.
			radice = new NodoAlbero();
			radice.dato = x;
			// Creo gli alberi vuoti a sinistra e destra!!!!!
			radice.sx = new AlberoGenerico<>();
			radice.dx = new AlberoGenerico<>();
		} 
		else
		{
			// Confronto con l'elemento della radice.
			if (x.compareTo(radice.dato) < 0)
			{ // Inverto x e dato per avere i dati pi� piccoli a sinistra e i pi� grandi a destra come da convenzione.
				// Se � minore della radice, inserisci a sinistra.
				radice.sx.insert(x);
			} 
			else
			{
				// Se � maggiore della radice, inserisci a destra
				radice.dx.insert(x);
			}
		}		
	}
	
	// Stampo l'albero in ordine simmetrico.
	void printInOrder()
	{
		// Se l'albero � vuoto non stampare nulla.
		if (radice == null) 
		{
			return;
		}
		else
		{
			// Stampa in ordine simmetrico l'albero.
			radice.sx.printInOrder(); // Sottoalbero sinistro.
			System.out.print(radice.dato + " "); // Radice.
			radice.dx.printInOrder(); // Sottoalbero destro.
		}
	}
	
	// Cerco un elemento nell'albero e, se lo trovo, restituisco true.
	boolean trova(E e)
	{
		int c = radice.dato.compareTo(e);
		
		System.out.println("cercando " + e +" in ");
		printInOrder();
		System.out.println("*****");
		// Nel caso l'albero � vuoto.
		if (radice == null)
		{
			return false;
		}
		// Altrimenti inizio a cercare.
		// Se � uguale alla radice, restituisco subito true.
		else if (c == 0) 
		{
			return true;
		}
		// Se la radice � minore dell'elemento, cerco a destra.
		else if (c <0) 
		{
			return radice.dx.trova(e);
		}
		// Se la radice � maggiore dell'elemento, cerco a sinsitra.
		else 
		{
			return (radice.sx.trova(e));
		}
	}
	
	public static void main(String[] args) 
	{
		AlberoGenerico<Integer> nomi = new AlberoGenerico<Integer>();
		nomi.insert(20);
		nomi.printInOrder();
		System.out.println();
		nomi.insert(30);
		nomi.printInOrder();
		System.out.println();
		nomi.insert(5);
		nomi.printInOrder();
		System.out.println();
		nomi.insert(15);
		nomi.printInOrder();
		System.out.println();
		
		System.out.println(nomi.trova(20));
	}
}
