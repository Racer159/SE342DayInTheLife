import java.util.ArrayList;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

/**
 * Represents a Project Status Meeting
 * @author Magikarpets (Team 3) 
 *
 */
public class ProjectStatusUpdate extends TimerTask implements Task{

	private ArrayList<Employee> members;
	private CountDownLatch go;
	private String name;
	
	/**Creates a project status meeting with a name and members*/
	public ProjectStatusUpdate(String name, ArrayList<Employee> members){
		this.members = members;
		this.name = name;
		this.go = new CountDownLatch(members.size());
	}
	
	/**Runs the project status meeting*/
	public void run() {
		TeamRoom.acquire(this);
		for(int i = 0; i < members.size(); i++){
			members.get(i).request(this,true);
		}
		try {
			go.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name + " has begun.");
	}

	/**Captures the response from an employee going to the meeting*/
	@Override
	public void response(Employee e) {
		System.out.println(Clock.stringTime() + e.getName() + " has arrived at " + name);
		go.countDown();
		try {
			go.await();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Thread.sleep(60*10);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(Clock.stringTime() + e.getName() + " has left " + name);
		TeamRoom.release(this);
	}
}
