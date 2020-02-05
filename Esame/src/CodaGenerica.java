
// Coda generica.
public class CodaGenerica<E> 
{

	// Definisco la classe NodoCoda.
	private class NodoCoda
	{
		E dato;
		NodoCoda pros;
	}
	
	NodoCoda primo;
	NodoCoda ultimo;

	// Costruttore.
	CodaGenerica()
	{
		primo = ultimo = null;
	}
	
	// Inserisco un nodo all'interno della coda.
	public void insert(E x)
	{
		NodoCoda t = new NodoCoda();
		t.dato = x;
		t.pros = null;
		
		// Nel caso in cui è il primo elemento.
		if (primo == null)
		{
			primo = t;
			ultimo = t;
		} 
		else
		{
			ultimo.pros = t; // Nel caso in cui non è il primo elemento.
			ultimo = t;
		}
	}
	
	// Prelevo un nodo dalla coda.
	public void preleva()
	{
		for(NodoCoda i = primo;i !=null; i=i.pros)
		{
			if(i.pros==ultimo)
			{
				ultimo = i;
				i.pros=null;
				break;
			}
		}
	}
	
	// Stampa della coda.
	public void print()
	{
		for(NodoCoda i = primo; i!= null; i = i.pros)
		{
			System.out.print(i.dato + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) 
	{
		CodaGenerica<Integer> c = new CodaGenerica<Integer>();
		c.insert(5);
		c.print();
		c.insert(10);
		c.print();
		c.insert(20);
		c.print();
		c.preleva();
		c.print();
		c.insert(8);
		c.print();
	}
	
}

