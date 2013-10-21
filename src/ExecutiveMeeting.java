/**
 * Represents the Executive Meeting
 * @author Magikarpets (Team 3) 
 *
 */
public class ExecutiveMeeting extends Thread implements Task{
	
	private Employee manager;
	
	/**Constructor used to create an Executive Meeting*/
	public ExecutiveMeeting(Employee manager) {
		this.manager = manager;
	}
	
	/**Runs the executive meeting*/
	public void run() {
		manager.request(this,true);
	}
	
	/**Captures a response from an Employee (manager)*/
	@Override
	public void response(Employee e) {
		System.out.println(Clock.stringTime() + e + " executive meeting begins");
		try {
			Thread.sleep(60*10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(Clock.stringTime() + e + " executive meeting ends");
	}
	
}
