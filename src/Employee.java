import java.util.ArrayList;

public class Employee extends Thread{

	ArrayList<Task> tasks = new ArrayList<Task>();
	
	public Employee(String name) {
		this.setName(name);
	}
	
	public void request(Task t, boolean priority){
		if (priority) {
			tasks.add(0,t);
		}
		else{
			tasks.add(t);
		}
	}
	
	public void run() {
		Task todo;
		while(true){
			if(!tasks.isEmpty()){
				todo = tasks.get(0);
				tasks.remove(0);
				todo.response(this);
			}
			Thread.yield();
		}
	}
}
