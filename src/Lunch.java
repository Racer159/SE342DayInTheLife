import java.util.TimerTask;

/**
 * Represents going to lunch for an Employee
 * @author Magikarpets (Team 3)
 *
 */
public class Lunch extends TimerTask implements Task{

	private int duration;
	private Employee e;
	
	/**
	 * Creates a lunch task
	 * @param duration
	 * @param e
	 */
	public Lunch (int duration, Employee e){
		this.duration = duration;
		this.e = e;
	}
	
	/**
	 * Returns the type of the task
	 * @return TaskType - task
	 */
	public TaskType getTaskType(){
		return TaskType.LUNCH;
	}
	
	/**
	 * Runs the lunch task
	 */
	public void run() {
		e.request(this, true);
	}
	
	/**
	 * Captures an employees response when they decide to perform the task
	 */
	@Override
	public void response(Employee e) {
		System.out.println(Clock.stringTime() + e.getName() + " goes to lunch.");
		try {
			Thread.sleep(duration*10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(Clock.stringTime() + e.getName() + " arrives from lunch.");
	}

}
