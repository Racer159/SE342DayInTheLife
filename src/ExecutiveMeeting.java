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
	
	/**Captures a response from the Employees*/
	@Override
	public void response(Employee e) {
		// TODO Auto-generated method stub
		System.out.println("Manager's executive meeting begins");
		try {
			Thread.sleep(60*10);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Manager's executive meeting ends");
	}
	
}
