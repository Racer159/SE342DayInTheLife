import java.util.TimerTask;

/**
 * Represents a timer task that tells an Employee when they can leave
 * @author Magikarpets (Team 3) 
 *
 */
public class Leave extends TimerTask implements Task{

	Employee e;
	
	/**
	 * Creates a leave task
	 * @param e
	 */
	public Leave(Employee e) {
		this.e = e;
	}
	
	/**
	 * Returns the type of the task
	 * @return TaskType - task
	 */
	public TaskType getTaskType(){
		return TaskType.IDLE;
	}
	
	/**
	 * Captures an employees response when they decide to perform the task
	 */
	@Override
	public void response(Employee e) {
		System.out.println(Clock.stringTime() + e.getName() + " has left for the day.");
		e.finish();
		if (e.getName().equals("Manager")){
			Main.printStatistics();
			System.exit(0);
		}
	}

	/**
	 * Runs the leave task.
	 */
	@Override
	public void run() {
		e.request(this, true);
	}

}
