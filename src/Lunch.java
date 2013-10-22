import java.util.TimerTask;


public class Lunch extends TimerTask implements Task{

	private int duration;
	private Employee e;
	
	public Lunch (int duration, Employee e){
		this.duration = duration;
		this.e = e;
	}
	
	public void run() {
		e.request(this, true);
	}
	
	@Override
	public void response(Employee e) {
		// TODO Auto-generated method stub
		System.out.println(Clock.stringTime() + e.getName() + " goes to lunch.");
		try {
			Thread.sleep(duration*10);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(Clock.stringTime() + e.getName() + " arrives from lunch.");
	}

}
