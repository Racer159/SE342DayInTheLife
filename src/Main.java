import java.util.ArrayList;

/**
 * The Main Class that drives the application
 * @author Magikarpets (Team 3) 
 *
 */
public class Main {

	/**The main class for the project
	 * @throws InterruptedException */
	public static void main (String[] args) throws InterruptedException {
		//TODO: IMPLEMENT SCHEDULING
		Clock time = new Clock();
		Employee manager = new Employee(0,0);
		Employee TeamLead11 = new Employee(1,1);
		Employee Developer12 = new Employee(1,2);
		Employee Developer13 = new Employee(1,3);
		time.startClock();
		manager.start();
		TeamLead11.start();
		Developer12.start();
		Developer13.start();
		ArrayList<Employee> meeting1 = new ArrayList<Employee>();
		System.out.println(time.stringTime());
		meeting1.add(manager);
		meeting1.add(TeamLead11);
		meeting1.add(Developer12);
		meeting1.add(Developer13);
		ExecutiveMeeting exec1 = new ExecutiveMeeting(manager);
		ExecutiveMeeting exec2 = new ExecutiveMeeting(manager);
		StandUpMeeting execMeeting = new StandUpMeeting("standup meeting", meeting1);
		AskQuestion ques = new AskQuestion(manager,Developer12,Developer13);
		AskQuestion ques2 = new AskQuestion(manager,Developer12,Developer13);
		AskQuestion ques3 = new AskQuestion(manager,Developer12,Developer13);
		exec1.start();
		exec2.start();
		execMeeting.start();
		ques.start();
		ques2.start();
		ques3.start();
		Thread.currentThread().sleep(1000);
		System.out.println(time.stringTime());
	}
	
}
