package Procedure;
import GestorePratiche.Procedure;
import prog.io.ConsoleOutputManager;

public abstract class CourtProcedure extends Procedure 
{
	public enum severityOfProcedure
	{
		primo(1),
		appello(2),
		cassazione(3);
		private int nSeverity;
		private severityOfProcedure(int newSeverity)//costruttore della classe enumerativa severitOfProcedure
		{
			nSeverity=newSeverity;
		}
		public int getSeverity() {
			return this.nSeverity;
		}
		void setSeverityOfProcedure(int newSeverity) {
			this.nSeverity=newSeverity;
		}
	}
	public severityOfProcedure currentSeverity;
	
	public void viewProcedure() {
		ConsoleOutputManager out= new ConsoleOutputManager();
		super.viewProcedure();
		out.println("procedure severity index: "+currentSeverity);
	}
	 public void costEvaluation() {
		  int xStateOfProcedure=this.currentSeverity.getSeverity();
		  cost=(double)xStateOfProcedure*nHourOfWork*100;
	 }
}	


