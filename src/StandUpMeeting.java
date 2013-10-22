import java.util.ArrayList;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

/**
 * Represents a Stand Up Meeting
 * @author Magikarpets (Team 3) 
 *
 */
public class StandUpMeeting extends TimerTask implements Task{
	
	private ArrayList<Employee> members;
	private CountDownLatch go;
	private String name;
	
	/**Constructs a stand up meeting with a name and members*/
	public StandUpMeeting(String name, ArrayList<Employee> members){
		this.members = members;
		this.go = new CountDownLatch(members.size());
		this.name = name;
	}
	
	/**Runs the stand up meeting*/
	public void run() {
		for(int i = 0; i < members.size(); i++){
			members.get(i).request(this,true);
		}
		try {
			go.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " has begun.");
	}

	/**Captures the response from an employee to the meeting*/
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
	}

}
