import java.util.TimerTask;

/**
 * Represents an Executive Meeting
 * @author Magikarpets (Team 3) 
 *
 */
public class ExecutiveMeeting extends TimerTask implements Task{
	
	private Employee manager;
	
	/**Constructs an executive meeting with the manager provided*/
	public ExecutiveMeeting(Employee manager) {
		this.manager = manager;
	}
	
	/**Runs the executive meeting*/
	public void run() {
		manager.request(this,true);
	}
	
	/**Captures the response from the manager when the manager is available*/
	@Override
	public void response(Employee e) {
		System.out.println(Clock.stringTime() + e.getName() + "'s executive meeting begins");
		try {
			Thread.sleep(60*10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(Clock.stringTime() + e.getName() + "'s executive meeting ends");
	}
	
}
