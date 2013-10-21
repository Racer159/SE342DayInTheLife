/**
 * Represents Lunch for the Developers and Manager
 * @author Magikarpets (Team 3) 
 *
 */
public class Lunch extends Thread implements Task{

	private int duration;
	private Employee e;
	
	public Lunch (int duration, Employee e){
		this.duration = duration;
		this.e = e;
	}
	
	public void run() {
		e.request(this, true);
	}
	
	@Override
	public void response(Employee e) {
		// TODO Auto-generated method stub
		System.out.println(e.getName() + " goes to lunch.");
		try {
			Thread.sleep(duration*10);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(e.getName() + " arrives from lunch.");
	}

}
