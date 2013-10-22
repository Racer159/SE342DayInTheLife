import java.util.ArrayList;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;


public class StandUpMeeting extends TimerTask implements Task{
	
	private ArrayList<Employee> members;
	private CountDownLatch go = new CountDownLatch(4);
	private String name;
	
	public StandUpMeeting(String name, ArrayList<Employee> members){
		this.members = members;
		this.name = name;
	}
	
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
		System.out.println(Clock.stringTime() + name + " has begun.");
	}

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
