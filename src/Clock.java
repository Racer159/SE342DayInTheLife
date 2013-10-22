/**
 * Represents a clock that allows timing to be scheduled properly
 * @author Magikarpets (Team 3)
 *
 */
public class Clock {
	
	private static long start = 0;
	
	/**
	 * Starts the clock
	 */
	public static void startClock() {
		start = System.currentTimeMillis();
		start -= 8*600;
	}
	
	/**
	 * Gets the time in milliseconds since start
	 * @return milliseconds
	 */
	public static long getTime() {
		return (System.currentTimeMillis() - start);
	}
	
	/**
	 * Gets the total simulation hours
	 * @return hours
	 */
	public static int getHour() {
		long time = System.currentTimeMillis() - start;
		time = time / (600);
		return (int) time;
	}
	
	/**
	 * Gets the total simulation minutes
	 * @return minutes
	 */
	public static int getMinute() {
		long time = System.currentTimeMillis() - start;
		time = time / (10);
		return (int) time;
	}
	
	/**
	 * Gets a string representing the time
	 * @return stringTime
	 */
	public static String stringTime() {
		return getHour() % 24 + ":" + String.format("%02d", getMinute() % 60)  + " ";
	}
}
