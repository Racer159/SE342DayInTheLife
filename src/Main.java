import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

/**
 * The main driver for our progam, used to schedule tasks
 * @author Magikarpets (Team 3)
 *
 */
public class Main {
	
	private static ArrayList<Employee> all;
	
	/**
	 * Drives the Employees and tasks
	 * @param args
	 */
	public static void main (String[] args) {
		
		// initialize the timer
		Timer timer = new Timer();
		
		//start the clock
		Clock.startClock();
		
		//initialize all of the actors and teams
		
		Random rando = new Random();
		
		Employee manager = new Employee(0,0,0);
		manager.start();
		Employee teamLead1 = new Employee(1,1,rando.nextInt(30));
		teamLead1.start();
		Employee teamLead2 = new Employee(2,1,rando.nextInt(30));
		teamLead2.start();
		Employee teamLead3 = new Employee(3,1,rando.nextInt(30));
		teamLead3.start();
		Employee dev12 = new Employee(1,2,rando.nextInt(30));
		dev12.start();
		Employee dev13 = new Employee(1,3,rando.nextInt(30));
		dev13.start();
		Employee dev14 = new Employee(1,4,rando.nextInt(30));
		dev14.start();
		Employee dev22 = new Employee(2,2,rando.nextInt(30));
		dev22.start();
		Employee dev23 = new Employee(2,3,rando.nextInt(30));
		dev23.start();
		Employee dev24 = new Employee(2,4,rando.nextInt(30));
		dev24.start();
		Employee dev32 = new Employee(3,2,rando.nextInt(30));
		dev32.start();
		Employee dev33 = new Employee(3,3,rando.nextInt(30));
		dev33.start();
		Employee dev34 = new Employee(3,4,rando.nextInt(30));
		dev34.start();
		ArrayList<Employee> bosses = new ArrayList<Employee>();
		ArrayList<Employee> team1 = new ArrayList<Employee>();
		ArrayList<Employee> team2 = new ArrayList<Employee>();
		ArrayList<Employee> team3 = new ArrayList<Employee>();
		all = new ArrayList<Employee>();
		
		//put each employee in their respective teams

		// team of the bosses
		bosses.add(manager);
		bosses.add(teamLead1);
		bosses.add(teamLead2);
		bosses.add(teamLead3);
		// team 1
		team1.add(teamLead1);
		team1.add(dev12);
		team1.add(dev13);
		team1.add(dev14);
		// team 2
		team2.add(teamLead2);
		team2.add(dev22);
		team2.add(dev23);
		team2.add(dev24);
		// team 3
		team3.add(teamLead3);
		team3.add(dev32);
		team3.add(dev33);
		team3.add(dev34);
		// all employees
		all.add(manager);
		all.add(teamLead1);
		all.add(teamLead2);
		all.add(teamLead3);
		all.add(dev12);
		all.add(dev13);
		all.add(dev14);
		all.add(dev22);
		all.add(dev23);
		all.add(dev24);
		all.add(dev32);
		all.add(dev33);
		all.add(dev34);

		//schedule executive standup meeting with team leads and manager
		StandUpMeeting execStandUp = new StandUpMeeting("Team lead stand up meeting",bosses);
		timer.schedule(execStandUp, 0);
		//schedule each team's standup meeting
		StandUpMeeting team1StandUp = new StandUpMeeting("Team 1 stand up meeting",team1);
		timer.schedule(team1StandUp, 1);
		StandUpMeeting team2StandUp = new StandUpMeeting("Team 2 stand up meeting",team2);
		timer.schedule(team2StandUp, 2);
		StandUpMeeting team3StandUp = new StandUpMeeting("Team 3 stand up meeting",team3);
		timer.schedule(team3StandUp, 3);
		//schedule managers executive meetings
		ExecutiveMeeting exec1 = new ExecutiveMeeting(manager);
		ExecutiveMeeting exec2 = new ExecutiveMeeting(manager);
		timer.schedule(exec1,120*10);
		timer.schedule(exec2,360*10);
		//schedule manager's lunch
		Lunch mlunch = new Lunch(60,manager);
		timer.schedule(mlunch, 240*10);
		//schedule everyone elses lunches
		scheduleLunchesAndLeavesAndArrivals(all,timer);
		scheduleQuestions(manager, team1,timer);
		scheduleQuestions(manager, team2,timer);
		scheduleQuestions(manager, team3,timer);
		Leave mleave = new Leave(manager);
		timer.schedule(mleave, 540*10);
		ProjectStatusUpdate psu = new ProjectStatusUpdate("Project status update",all);
		timer.schedule(psu, 4800);
	}
	
	/**
	 * Schedules arrival times, lunches, and leaving times
	 * @param all
	 * @param timer
	 */
	private static void scheduleLunchesAndLeavesAndArrivals(ArrayList<Employee> all, Timer timer) {
		Lunch elunch;
		Leave eleave;
		Random rando = new Random();
		int lunchDuration;
		int arrivalTime;
		// assuming the manager is index 1
		for (int i = 1; i < all.size(); i++){
			arrivalTime = all.get(i).getArrivalTime();
			lunchDuration = (int) (rando.nextInt(30))+30-arrivalTime;
			elunch = new Lunch(lunchDuration,all.get(i));
			// this math means that employees will take lunch for between half and a full hour, and take it between 11:30 to 12:30
			timer.schedule(elunch, (long) (240 + (rando.nextInt(60)) -30)*10);
			eleave = new Leave(all.get(i));
			timer.schedule(eleave,10*(480+arrivalTime+lunchDuration));
		}
	}
	
	/**
	 * Schedules questions from developers and team leads
	 * @param manager
	 * @param team
	 * @param timer
	 */
	private static void scheduleQuestions (Employee manager, ArrayList<Employee> team, Timer timer) {
		AskQuestion q;
		Random rando = new Random();
		int rand;
		int time;
		for (int i = 0; i < 10; i++){
			rand = (int) rando.nextInt(4);
			time = (int) rando.nextInt(4800);
			if (rand == 0){
				q = new AskQuestion(manager,team.get(0));
				timer.schedule(q, time);
			}
			else{
				q = new AskQuestion(manager,team.get(0),team.get(rand));
				timer.schedule(q, time);
			}
		}
	}
	
	public static void printStatistics(){
		CumulativeEmployeeStats ces = new CumulativeEmployeeStats();
		for(Employee e : all){
			ces.add(e.getEmployeeStats());
		}
		System.out.println(ces);
	}
	
}
