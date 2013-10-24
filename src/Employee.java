import java.util.ArrayList;

/**
 * Represents an Employee either Developer or Manager
 * @author Magikarpets (Team 3) 
 *
 */
public class Employee extends Thread{

	private ArrayList<Task> tasks = new ArrayList<Task>();
	private ArrayList<Task> done = new ArrayList<Task>();
	private int team = 0;
	private int position = 0;
	private int arrivalTime;
	private Positions type = Positions.DEVELOPER;
	private boolean working = true;
	
	/**
	 * Creates an Employee with a certain team and position, team 0 for manager
	 */
	public Employee(int team, int position, int arrivalTime) {
		this.team = team;
		this.position = position;
		if (team == 0) {
			this.type = Positions.MANAGER;
		} else if (position == 1) {
			this.type = Positions.TEAMLEAD;
		}
		this.setName(this.toString());
		this.arrivalTime = arrivalTime;
	}
	
	/**
	 * Accepts a request to perform a task
	 */
	public void request(Task t, boolean priority){
		if (priority) {
			tasks.add(0,t);
		}
		else{
			tasks.add(t);
		}
	}
	
	/**
	 * Runs the employee in a loop that ends after the employee leaves
	 */
	@SuppressWarnings("static-access")
	public void run() {
		Task todo;
		try {
			this.sleep(arrivalTime*10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Clock.stringTime() + this.getName() + " has arrived to work.");
		while(working){
			if(!tasks.isEmpty()){
				todo = tasks.remove(0);
				if (todo != null){
					done.add(todo);
					todo.response(this);
				}
			}
			this.yield();
		}
		return;
	}
	
	/**
	 * Returns the Arrival Time of the Employee
	 * @return arrivalTime
	 */
	public int getArrivalTime(){
		return arrivalTime;
	}
	
	/**
	 * Creates a string from the employee data
	 * @return stringRep
	 */
	public String toString() {
		if (this.type == Positions.MANAGER) {
			return "Manager";
		} else {
			return "Developer " + team + position;
		}
	}
	
	/**
	 * Tells the Employee that they are done for the day
	 */
	public void finish() {
		this.working = false;
	}
}