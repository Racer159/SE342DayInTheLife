import java.util.TimerTask;

/**
 * Represents an Executive Meeting
 * @author Magikarpets (Team 3)
 *
 */
public class ExecutiveMeeting extends TimerTask implements Task{
	
	private Employee manager;
	
	/**
	 * Creates a executive meeting task
	 * @param manager
	 */
	public ExecutiveMeeting(Employee manager) {
		this.manager = manager;
	}
	
	/**
	 * Returns the type of the task
	 * @return TaskType - task
	 */
	public TaskType getTaskType(){
		return TaskType.MEETING;
	}
	
	/**
	 * Runs the executive meeting
	 */
	public void run() {
		manager.request(this,true);
	}
	
	/**
	 * Captures an employees response when they decide to perform the task
	 */
	@Override
	public void response(Employee e) {
		System.out.println(Clock.stringTime()+"Manager's executive meeting begins");
		try {
			Thread.sleep(60*10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(Clock.stringTime()+"Manager's executive meeting ends");
	}
	
}
