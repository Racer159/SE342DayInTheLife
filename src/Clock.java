/**
 * Represents a clock that allows timing to be scheduled properly
 * @author Magikarpets (Team 3)
 *
 */
public class Clock {
	
	private long start = 0;
	
	public void startClock() {
		start = System.currentTimeMillis();
	}
	
	public long getTime() {
		return (System.currentTimeMillis() - start);
	}
	
	public int getHour() {
		long time = System.currentTimeMillis() - start;
		time = time / (600);
		return (int) time;
	}
	
	public int getMinute() {
		long time = System.currentTimeMillis() - start;
		time = time / (10);
		return (int) time;
	}
	
	public String stringTime() {
		return getHour() + ":" + getMinute() % 60  + " ";
	}
}
