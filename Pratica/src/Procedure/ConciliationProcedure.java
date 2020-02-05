package Procedure;
import java.util.Calendar;

import GestorePratiche.*;

public class ConciliationProcedure extends Procedure
{
	public ConciliationProcedure(String id,Client c,String desc,double nHourOfWork,long priority,double cost,Calendar d,int stateToInsert) {
		this.id=id;
		this.c=c;
		this.desc=desc;
		this.nHourOfWork=nHourOfWork;
		this.priority=priority;
		this.cost=cost;
		this.d=d;
		this.currentState=stateOfProcedure.values()[stateToInsert-1];
	}
	public void costEvaluation() {
		cost=120*nHourOfWork;
	}
}
