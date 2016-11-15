package metier;

import java.util.Vector;
/**
 * 
 * @author gervais
 *Définie la liste des jours  et des tranches horaires dans une semaine
 */
public class TimeSet {

	private Vector<String> dayList;
	private Vector<String> hourList;
	
	public TimeSet() {
		dayList = new Vector<String>();
		hourList = new Vector<String>();
	}

	public Vector<String> getDay() {
		return dayList;
	}

	public Vector<String> getHour() {
		return hourList;
	}

}
