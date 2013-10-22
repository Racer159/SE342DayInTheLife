import java.util.TimerTask;

/**
 * Represents going to lunch
 * @author Wayne E Starr
 *
 */
public class Lunch extends TimerTask implements Task{

	private int duration;
	private Employee e;
	
	/**Constructs a lunch object*/
	public Lunch (int duration, Employee e){
		this.duration = duration;
		this.e = e;
	}
	
	/**Runs the lunch*/
	public void run() {
		e.request(this, true);
	}
	
	/**Captures a response from the employee going to lunch*/
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
