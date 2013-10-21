/**
 * Represents Lunch for the Developers and Manager
 * @author Magikarpets (Team 3) 
 *
 */
public class Lunch extends Thread implements Task{

	private int duration;
	private Employee e;
	
	/**Constructor used to build Lunch*/
	public Lunch (int duration, Employee e){
		this.duration = duration;
		this.e = e;
	}
	
	/**Runs Lunch on an employee*/
	public void run() {
		e.request(this, true);
	}
	
	/**Captures the response from an employee*/
	@Override
	public void response(Employee e) {
		System.out.println(e.getName() + " goes to lunch.");
		try {
			Thread.sleep(duration*10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(e.getName() + " arrives from lunch.");
	}

}
