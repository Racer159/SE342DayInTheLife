import java.util.TimerTask;


public class ExecutiveMeeting extends TimerTask implements Task{
	
	private Employee manager;
	
	public ExecutiveMeeting(Employee manager) {
		this.manager = manager;
	}
	
	public void run() {
		manager.request(this,true);
	}
	
	@Override
	public void response(Employee e) {
		// TODO Auto-generated method stub
		System.out.println(Clock.stringTime()+"Manager's executive meeting begins");
		try {
			Thread.sleep(60*10);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(Clock.stringTime()+"Manager's executive meeting ends");
	}
	
}
