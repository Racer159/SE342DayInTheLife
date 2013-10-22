import java.util.TimerTask;

public class Leave extends TimerTask implements Task{

	Employee e;
	
	public Leave(Employee e) {
		this.e = e;
	}
	
	@Override
	public void response(Employee e) {
		System.out.println(Clock.stringTime() + e.getName() + " has left for the day.");
		e.finish();
	}

	@Override
	public void run() {
		e.request(this, true);
	}

}
