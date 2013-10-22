import java.util.ArrayList;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

/**
 * This represents a Stand Up Meeting
 * @author Magikarpets (Team 3) 
 *
 */
public class StandUpMeeting extends TimerTask implements Task{
	
	private ArrayList<Employee> members;
	private CountDownLatch go = new CountDownLatch(4);
	private String name;
	
	/**
	 * Creates a Stand Up Meeting with a given name and members
	 * @param name
	 * @param members
	 */
	public StandUpMeeting(String name, ArrayList<Employee> members){
		this.members = members;
		this.name = name;
	}
	
	/**
	 * Runs the stand up meeting, first trying to get the room, then
	 * requesting members to attend.
	 */
	public void run() {
		TeamRoom.acquire(this);
		for(int i = 0; i < members.size(); i++){
			members.get(i).request(this,true);
		}
		try {
			go.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Clock.stringTime() + name + " has begun.");
	}

	/**
	 * Captures an employees response when they decide to perform the task
	 */
	@Override
	public void response(Employee e) {
		System.out.println(Clock.stringTime() + e.getName() + " has arrived at " + name);
		go.countDown();
		try {
			go.await();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			Thread.sleep(15*10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(Clock.stringTime() + e.getName() + " has left " + name);
		TeamRoom.release(this);
	}

}
