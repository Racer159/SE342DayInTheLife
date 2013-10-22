import java.util.ArrayList;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;


public class ProjectStatusUpdate extends TimerTask implements Task{

	private ArrayList<Employee> members;
	private CountDownLatch go = new CountDownLatch(13);
	private String name;
	
	public ProjectStatusUpdate(String name, ArrayList<Employee> members){
		this.members = members;
		this.name = name;
	}
	
	public void run() {
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

	@Override
	public void response(Employee e) {
		// TODO Auto-generated method stub
		System.out.println(e.getName() + " has arrived at " + name);
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
		System.out.println(e.getName() + " has left " + name);
	}
}
