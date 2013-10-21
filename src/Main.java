import java.util.ArrayList;

/**
 * The Main Class that drives the application
 * @author Magikarpets (Team 3) 
 *
 */
public class Main {

	public static void main (String[] args) {
		Employee manager = new Employee("manager");
		Employee TeamLead1 = new Employee("Developer d11");
		Employee TeamLead2 = new Employee("Developer d21");
		Employee TeamLead3 = new Employee("Developer d31");
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
		StandUpMeeting execMeeting = new StandUpMeeting("exec standup meeting", meeting1);
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
