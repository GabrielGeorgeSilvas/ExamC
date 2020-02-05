
public class ListaOrdinata<E extends Comparable<E>> 
{
	// Definisco la classe NodoLista.
	private class NodoLista 
	{
		E dato;
		NodoLista pros;

		// Costruttutore.
		NodoLista(E d, NodoLista n) 
		{
			dato = d;
			pros = n;
		}

	}

	NodoLista inizio;

	// Costruisco la lista vuota.
	public ListaOrdinata() 
	{
		inizio = null;
	}

	// Inserisco un nodo all'interno della lista.
	public void inserisci(E x) 
	{
		// Nel caso in cui è il primo elemento.
		if (inizio == null) 
		{
			inizio = new NodoLista(x, null);
		} 
		else 
		{
			// Nel caso in cui non è il primo elemento.
			NodoLista p = inizio;
			NodoLista q = null;
			while (p!= null && p.dato.compareTo(x) < 0) 
			{
				q = p;
				p = p.pros;
			}
			// Inserisco il nodo nella posizione corretta.
			NodoLista t = new NodoLista(x, p);
			
			// Nel caso in cui la posizione è la prima.
			if (q == null)
				inizio = t;
			else
				q.pros = t; // Nel caso in cui la posizione non è la prima.

		}
	}

	// Stampa della lista ordinata.
	public void print()
	{
		for(NodoLista i = inizio; i!= null; i = i.pros)
		{
			System.out.print(i.dato + " ");
		}
		System.out.println();
	}
	
	// Cerco un elemento nella lista e restituisco true solo le lo trovo.
	public boolean trova(E x)
	{
		for(NodoLista i = inizio; i!= null; i = i.pros)
		{
			int c = i.dato.compareTo(x);
			
			// Nel caso in cui lo ho trovato
			if (c == 0) return true;
			
			// Nel caso in cui il numero con cui confronto è maggiore di quello
			// da cercare.
			if (c>0) return false;
		}
		return false; // Nel caso in cui non lo ho trovato.
	}
	
	// Cancello un nodo dalla lista.
	public void cancella(E x)
	{
		NodoLista p = inizio;
		NodoLista q = null;
		while(p!=null)
		{
			int c = p.dato.compareTo(x);
			if (c==0)
			{
				// Prelevo c che è uguale a quello che devo eliminare.
				if (q == null)
					// Nel caso in cui è il primo elemento.
					inizio = p.pros;
				else
					q.pros = p.pros; // Nel caso in cui non è il primo elemento.
				return;
			}
			
			// Nel caso in cui il numero con cui confronto è maggiore di quello
			// da cercare.
			if (c>0) return;
			// Altrimenti vado avanti.
			q = p;
			p = p.pros;
		}
	}

	public static void main(String[] args) 
	{
		ListaOrdinata<String> nomi = new ListaOrdinata<>();
		nomi.inserisci("anna");
		nomi.print();
		nomi.inserisci("angelo");
		nomi.print();
		nomi.inserisci("anhan");
		nomi.print();
		nomi.inserisci("zorro");
		nomi.print();
		System.out.println(nomi.trova("anna"));
		System.out.println(nomi.trova("paolo"));
		// cancello elementi
		nomi.cancella("anhan");
		nomi.print();
		nomi.cancella("paolo");
		nomi.print();
		nomi.cancella("angelo");
		nomi.print();

	}
}
