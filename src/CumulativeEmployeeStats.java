/**
 * Class used to add up EmployeeStats. Has total minutes, 
 * working minutes, lunch minutes, meeting minutes, question
 * minutes, and number of employees in the aggregation.
 * @author Magikarpets (Team 3)
 *
 */
public class CumulativeEmployeeStats {
	
	private int working;
	private int lunch;
	private int meetings;
	private int questions;
	private int total;		
	private int employees;
	
	public CumulativeEmployeeStats(){
		this.working = 0;
		this.lunch = 0;
		this.meetings = 0;
		this.questions = 0;
		this.total = 0;
		this.employees = 0;
	}
	
	public void add(EmployeeStats stats){
		this.working += stats.getWorking();
		this.lunch += stats.getLunch();
		this.meetings += stats.getMeetings();
		this.questions += stats.getQuestions();
		this.total += stats.getTotal();
		this.employees++;
	}
	
	public String toString(){
		return "Cumulative time for " + employees + " employees:\n" +
			"\tTotal Time: " + total + " minutes. \n"
			+ "\tWorking for " + working + " minutes.\n\tLunch for " + lunch +
			" minutes.\n\tQuestions for " + questions + " minutes.\n\t" + 
			"Meetings for " + meetings + " minutes.";
	}

}
