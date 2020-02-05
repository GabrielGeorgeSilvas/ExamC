package Procedure;
import java.util.Calendar;

import GestorePratiche.*;

public class CivilProcedure extends CourtProcedure
{
	public CivilProcedure(String id,Client c,String desc,double nHourOfWork,long priority,double cost,int severityToInsert,Calendar d,int stateToInsert) {
		this.id=id;
		this.c=c;
		this.desc=desc;
		this.nHourOfWork=nHourOfWork;
		this.priority=priority;
		this.cost=cost;
		this.currentSeverity.setSeverityOfProcedure(severityToInsert);
		this.d=d;
		this.currentState=stateOfProcedure.values()[stateToInsert-1];
	}

}
