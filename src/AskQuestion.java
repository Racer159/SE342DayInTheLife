import java.util.concurrent.CountDownLatch;

/**
 * Allows developers to ask questions of the team lead, or manager.
 * @author Magikarpets (Team 3)
 *
 */
public class AskQuestion extends Thread implements Task{
	
	Employee manager;
	Employee teamLead;
	Employee developer;
	
	boolean answered = false;
	
	CountDownLatch latch0 = new CountDownLatch(1);
	CountDownLatch latch1 = new CountDownLatch(2);
	CountDownLatch latch2 = new CountDownLatch(3);
	
	/**Constructor used to ask a question from a developer*/
	public AskQuestion (Employee manager, Employee teamLead, Employee developer) {
		this.manager = manager;
		this.teamLead = teamLead;
		this.developer = developer;
	}
	
	/**Constructor used to ask a question from a team lead*/
	public AskQuestion(Employee manager, Employee teamLead) {
		this.manager = manager;
		this.teamLead = teamLead;
	}
	
	/**Runs the AskQuestion Thread*/
	public void run() {
		if (developer == null){
			teamLead.request(this, false);
			try {
				latch1.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			manager.request(this, false);
			try {
				latch2.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			developer.request(this, false);
			try {
				latch0.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			teamLead.request(this, false);
			try {
				latch1.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (!answered){
				manager.request(this, false);
				try {
					latch2.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**Captures the response from an Employee*/
	@Override
	public void response(Employee e) {
		if (e == developer){
			System.out.println(e.getName() + " Has a question");
			latch0.countDown();
			latch1.countDown();
			latch2.countDown();
		}
		if (e == teamLead){
			if (developer == null){
				System.out.println(e.getName() + " Has a question");
				latch1.countDown();
				latch2.countDown();
				latch1.countDown();
				latch2.countDown();
			}
			else{
				if(Math.random() > .5){
					System.out.println(e.getName() + " Answered " + developer.getName() + "'s question.");
					answered = true;
					latch1.countDown();
					latch2.countDown();
					latch2.countDown();
				}
				else{
					System.out.println(e.getName() + " has to take " + developer.getName() + "'s question to the manager");
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
				System.out.println(e.getName() + " answered " + developer.getName() + "'s question.");
			} else {
				System.out.println(e.getName() + " answered " + teamLead.getName() + "'s question.");
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
