import java.util.ArrayList;

/**
 * The Main Class that drives the application
 * @author Magikarpets (Team 3) 
 *
 */
public class Main {

	/**The main class for the project*/
	public static void main (String[] args) {
		Employee manager = new Employee(0,0);
		Employee TeamLead1 = new Employee(1,1);
		Employee TeamLead2 = new Employee(2,1);
		Employee TeamLead3 = new Employee(3,1);
		manager.start();
		TeamLead1.start();
		TeamLead2.start();
		TeamLead3.start();
		ArrayList<Employee> meeting1 = new ArrayList<Employee>();
		meeting1.add(manager);
		meeting1.add(TeamLead1);
		meeting1.add(TeamLead2);
		meeting1.add(TeamLead3);
		ExecutiveMeeting exec1 = new ExecutiveMeeting(manager);
		ExecutiveMeeting exec2 = new ExecutiveMeeting(manager);
		StandUpMeeting execMeeting = new StandUpMeeting("standup meeting", meeting1);
		AskQuestion ques = new AskQuestion(manager,TeamLead2,TeamLead3);
		AskQuestion ques2 = new AskQuestion(manager,TeamLead2,TeamLead3);
		AskQuestion ques3 = new AskQuestion(manager,TeamLead2,TeamLead3);
		exec1.start();
		exec2.start();
		execMeeting.start();
		ques.start();
		ques2.start();
		ques3.start();
		
	}
	
}
