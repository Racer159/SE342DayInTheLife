import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * Represents the Stand Up Meeting
 * @author Magikarpets (Team 3) 
 *
 */
public class StandUpMeeting extends Thread implements Task{
	
	private ArrayList<Employee> members;
	private CountDownLatch go = new CountDownLatch(4);
	
	/**Constructor used to build a Stand Up Meeting*/
	public StandUpMeeting(String name, ArrayList<Employee> members){
		this.members = members;
		this.setName(name);
	}
	
	/**Runs the meeting*/
	public void run() {
		for(int i = 0; i < members.size(); i++){
			members.get(i).request(this,true);
		}
	}

	/**Captures responses from employees*/
	@Override
	public void response(Employee e) {
		System.out.println(Clock.stringTime() + e.getName() + " has arrived at " + this.getName());
		go.countDown();
		try {
			go.await();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(Clock.stringTime() + e.getName() + " has left " + this.getName());
	}

}
