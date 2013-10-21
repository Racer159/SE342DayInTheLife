import java.util.ArrayList;

/**
 * Represents an Employee either Developer or Manager
 * @author Magikarpets (Team 3) 
 *
 */
public class Employee extends Thread{

	private ArrayList<Task> tasks = new ArrayList<Task>();
	private int team = 0;
	private int position = 0;
	private Positions type = Positions.DEVELOPER;
	
	/**Builds an Employee with a certain team and position, team 0 for manager*/
	public Employee(int team, int position) {
		this.team = team;
		this.position = position;
		if (team == 0) {
			this.type = Positions.MANAGER;
		} else if (position == 1) {
			this.type = Positions.TEAMLEAD;
		}
		this.setName(this.toString());
	}
	
	/**Accepts a request to perform a task*/
	public void request(Task t, boolean priority){
		if (priority) {
			tasks.add(0,t);
		}
		else{
			tasks.add(t);
		}
	}
	
	/**Runs the employee*/
	@SuppressWarnings("static-access")
	public void run() {
		Task todo;
		while(true){
			if(!tasks.isEmpty()){
				todo = tasks.remove(0);
				todo.response(this);
			}
			this.yield();
		}
	}
	
	/**Creates a string from the employee data
	 * @return string representation */
	public String toString() {
		if (this.type == Positions.MANAGER) {
			return "Manager";
		} else {
			return "Developer " + team + position;
		}
	}
}
