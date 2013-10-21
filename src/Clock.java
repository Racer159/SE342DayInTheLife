/**
 * Represents a clock that allows timing to be scheduled properly
 * @author Magikarpets (Team 3)
 *
 */
public class Clock {
	
	private static long start = 0;
	
	public static void startClock() {
		start = System.currentTimeMillis();
	}
	
	public static long getTime() {
		return (System.currentTimeMillis() - start);
	}
	
	public static int getHour() {
		long time = System.currentTimeMillis() - start;
		time = time / (600);
		return (int) time;
	}
	
	public static int getMinute() {
		long time = System.currentTimeMillis() - start;
		time = time / (10);
		return (int) time;
	}
	
	public static String stringTime() {
		return getHour() % 24 + ":" + String.format("%02d", getMinute() % 60)  + " ";
	}
}
