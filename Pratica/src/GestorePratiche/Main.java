package GestorePratiche;


import Procedure.*;


import java.util.ArrayList;
import java.util.Calendar;


public class Main 
{
	public static void main(String[] args) 
	{
		//ArrayList<Procedure> a = new ArrayList<Procedure>();
		Procedure supp;
		Client c=new Client("Gabriel","Silvas",22,"UDUHWUS1234");
		Calendar d=Calendar.getInstance();
		d.set(2020, 1, 27);
		supp=new ConciliationProcedure("FirstProcedure",c,"Eccesso di velocità",0,0,1000,d,1);
		supp.viewProcedure();
		
		/*a.add(supp);

			(a.get(0)).viewProcedure();*/
		
		
	}
	
}
