/**
 * Represents the Executive Meeting
 * @author Magikarpets (Team 3) 
 *
 */
public class ExecutiveMeeting extends Thread implements Task{
	
	private Employee manager;
	
	public ExecutiveMeeting(Employee manager) {
		this.manager = manager;
	}
	
	public void run() {
		manager.request(this,true);
	}
	
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
