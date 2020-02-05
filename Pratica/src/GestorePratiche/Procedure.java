package GestorePratiche;
import java.util.*;
import GestorePratiche.Client;
import prog.io.ConsoleOutputManager;

public abstract class Procedure 
{
  public String id;
  public Client c = new Client();
  public String desc;
  public double nHourOfWork;
  public long priority;
  public double cost;
  public int severityOfProcedure;
  
  //creo una data y/m/d
  public Calendar d;
  
  public enum stateOfProcedure
  {
	  onGoing(1),
	  closed(2),
	  archived(3);
	  private int nState;
	  private stateOfProcedure(int newState) {
		  nState=newState;
	  }
	  public int getStateOfProcedure() {
		  return this.nState;
	  }
	  public void setStateOfProcedure(int newState) {
		  this.nState=newState;
	  }
  }
  public stateOfProcedure currentState; 

  
  //metodo per il calcolo della priorità per le varie procedure (passate tramite parametro)
  void priorityEvaluation() {
	  if(currentState.getStateOfProcedure()==3) {
		  priority=1000;
	  }
	  else {

		  TimeZone tz=TimeZone.getTimeZone("Europe/Italy");
		  Calendar supp=Calendar.getInstance();
		  supp.setTimeZone(tz);
		  
		  long daysBetween=supp.getTimeInMillis()-d.getTimeInMillis();
		  daysBetween=daysBetween/1000/60/60/24;
		  if(daysBetween<0) {
			  priority=Integer.MAX_VALUE;
		  }
		  else if(daysBetween==0) {
			  priority=0;
		  }
		  else {
			  priority=daysBetween-1;
		  }	
	  }  
  }
  
  //metodo superclasse (Procedure) per il calcolo del costo per procedura (pratica)
  //metodo ok per sottoclassi (CivilProcedure e PenaltyProcedure) OBBLIGATORIO overriding per sottoclasse(ConciliationProcedure)

  void setPriority(long priorityValue) {
	  priority=priorityValue;
  }
  long getPriority() {
	  return priority;
  }
  abstract public void costEvaluation();
  
  public double getCost() {
	  return this.cost;
  }

  public void viewProcedure() {
		ConsoleOutputManager out= new ConsoleOutputManager();
		out.println("procedure id: "+id);
		out.println("procedure client: "+c);
		out.println("brief descrition of the procedure: "+desc);
		out.println("procedure next court call: "+d);
		out.println("procedure state: "+currentState.getStateOfProcedure());
		out.println("procedure hours used until now: "+nHourOfWork);
		out.println("procedure priority index: "+priority);
		out.println("procedure cost until now: "+cost);
	}
  
  
}
