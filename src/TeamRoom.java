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
	 * @param t
	 */
	public static void acquire(TimerTask t) {
		try {
			lock.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Releases the team room when complete
	 * @param t
	 */
	public static void release(TimerTask t) {
		lock.release();
	}
}
