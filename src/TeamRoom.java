import java.util.TimerTask;

/**
 * Represents the team room used for Stand Up Meetings and Project Status Updates
 * @author Magikarpets (Team 3) 
 *
 */
public class TeamRoom {

	private static boolean permit = true;
	private static TimerTask holder = null;
	
	public static void acquire(TimerTask t) {
		if (permit) {
			permit = false;
			holder = t;
		} else {
			try {
				t.wait();
				permit = false;
				holder = t;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void release(TimerTask t) {
		if (t == holder) {
			permit = true;
			Thread.currentThread().notify();
		}
	}
}
