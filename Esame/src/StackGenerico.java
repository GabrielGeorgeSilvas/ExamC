public class StackGenerico<E> 
{
	// Definisco la classe NodoStack.
	private class NodoStack
	{
		E dato;
		NodoStack pros;
	}
	
	// Creo il riferimento al primo elemento dello stack.
	NodoStack cima;
	
	// Costruttore.
	public StackGenerico()
	{
		cima = null;
	}
	
	// Inserisco un elemento all'interno dello stack.
	public void push(E x)
	{
		// Creo nuovo nodo.
		NodoStack t = new NodoStack();
		// Assegno, al campo dato del nodo, il valore di x.
		t.dato = x;
		// Punto alla cima dello stack perchè la tecnica è LIFO.
		t.pros = cima;
		// Imposto t come primo elemento dello stack.
		cima = t;
	}

	// Tolgo un elemento dallo stack.
	public void pop()
	{
		cima = cima.pros;
	}
	
	@Override
	// Stampo lo stack.
	public String toString() 
	{
		String result = "[";

		for(NodoStack i = cima; i != null; i = i.pros)
		{
			result += i.dato+ ( i.pros == null? "":", ");
		}
		return result + "]";
	}
	

	public static void main(String[] args) 
	{
		StackGenerico<Integer> s = new StackGenerico<Integer>();
		s.push(3);
		System.out.println(s.toString());
		s.push(30);
		System.out.println(s.toString());
		s.push(10);
		System.out.println(s.toString());
		s.pop();
		System.out.println("elemento rimosso");
		System.out.println(s.toString());
		s.pop();
		System.out.println("elemento rimosso");
		System.out.println(s.toString());
		s.pop();
		System.out.println("elemento rimosso");
		System.out.println(s.toString());
	}
}
