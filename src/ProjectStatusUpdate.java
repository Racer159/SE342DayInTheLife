import java.util.ArrayList;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

/**
 * This represents a Project Status Meeting
 * @author Magikarpets (Team 3) 
 *
 */
public class ProjectStatusUpdate extends TimerTask implements Task{

	private ArrayList<Employee> members;
	private CountDownLatch go = new CountDownLatch(13);
	private String name;
	
	/**
	 * Creates a project status meeting with given name and members
	 * @param name
	 * @param members
	 */
	public ProjectStatusUpdate(String name, ArrayList<Employee> members){
		this.members = members;
		this.name = name;
	}
	
	/**
	 * Runs the project status meeting, first trying to get the room, then
	 * requesting members to attend.
	 */
	public void run() {
		TeamRoom.acquire();
		for(int i = 0; i < members.size(); i++){
			members.get(i).request(this,true);
		}
		try {
			go.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Clock.stringTime() + name + " has begun.");
		try {
			Thread.sleep(15*10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TeamRoom.release();
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
	}
}
