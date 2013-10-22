import java.util.TimerTask;
import java.util.concurrent.Semaphore;

/**
 * Represents the team room used for Stand Up Meetings and Project Status Updates
 * @author Magikarpets (Team 3) 
 *
 */
public class TeamRoom {

	private static Semaphore lock = new Semaphore(1);
	private static TimerTask holder = null;
	
	/**
	 * Acquires the team room for use
	 */
	public static void acquire() {
		try {
			lock.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Releases the team room when complete
	 */
	public static void release() {
		lock.release();
	}
}
