import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

/**
 * Allows a developer or team lead to ask a question
 * @author Magikarpets (Team 3) 
 *
 */
public class AskQuestion extends TimerTask implements Task{
	
	Employee manager;
	Employee teamLead;
	Employee developer;
	
	boolean answered = false;
	
	CountDownLatch latch0 = new CountDownLatch(1);
	CountDownLatch latch1 = new CountDownLatch(2);
	CountDownLatch latch2 = new CountDownLatch(3);
	
	/**
	 * Creates a question from a developer
	 * @param manager
	 * @param teamLead
	 * @param developer
	 */
	public AskQuestion (Employee manager, Employee teamLead, Employee developer) {
		this.manager = manager;
		this.teamLead = teamLead;
		this.developer = developer;
	}
	
	/**
	 * Creates a question from a team leader
	 * @param manager
	 * @param teamLead
	 */
	public AskQuestion(Employee manager, Employee teamLead) {
		this.manager = manager;
		this.teamLead = teamLead;
	}
	
	/**
	 * Returns the type of the task
	 * @return TaskType - task
	 */
	public TaskType getTaskType(){
		return TaskType.QUESTION;
	}
	
	/**
	 * Runs the asking of the question
	 */
	public void run() {
		if (developer == null){
			teamLead.request(this, false);
			try {
				latch1.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			manager.request(this, false);
			try {
				latch2.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else{
			developer.request(this, false);
			try {
				latch0.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			teamLead.request(this, false);
			try {
				latch1.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (!answered){
				manager.request(this, false);
			}
		}
		try {
			latch2.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Captures an employees response when they decide to perform the task
	 */
	@Override
	public void response(Employee e) {
		if (e == developer){
			System.out.println(Clock.stringTime() + e.getName() + " Has a question");
			latch0.countDown();
			latch1.countDown();
			latch2.countDown();
		}
		if (e == teamLead){
			if (developer == null){
				System.out.println(Clock.stringTime() + e.getName() + " Has a question");
				latch1.countDown();
				latch2.countDown();
				latch1.countDown();
				latch2.countDown();
			}
			else{
				if(Math.random() > .5){
					System.out.println(Clock.stringTime() + e.getName() + " Answered " + developer.getName() + "'s question.");
					answered = true;
					latch1.countDown();
					latch2.countDown();
					latch2.countDown();
				}
				else{
					System.out.println(Clock.stringTime() + e.getName() + " has to take " + developer.getName() + "'s question to the manager");
					latch1.countDown();
					latch2.countDown();
				}
			}
		}
		if (e == manager){
			try {
				Thread.sleep(10*10);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			if (developer != null){
				System.out.println(Clock.stringTime() + e.getName() + " answered " + developer.getName() + "'s question.");
			} else {
				System.out.println(Clock.stringTime() + e.getName() + " answered " + teamLead.getName() + "'s question.");
			}
			latch2.countDown();
		}
		try {
			latch2.await();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
}
