/**
 * Represents the statistics for what an employee does during 
 * the day
 * @author Magikarpets (Team 3) 
 *
 */
public class EmployeeStats {
	
	private int prevTime;
	private TaskType prevTask;
	
	private int working;
	private int lunch;
	private int meetings;
	private int questions;
	private int total;
	
	/**
	 * Set everything to 0 and set the task type to 
	 * NOTATWORK. When calcStats is called for the 
	 * first time it will not add anything because
	 * non work time isn't saved.
	 * 
	 * @param arrivalTime
	 */
	public EmployeeStats(){
		this.working = 0;
		this.lunch = 0;
		this.meetings = 0;
		this.questions = 0;
		this.total = 0;
		this.prevTime = 0;
		this.prevTask = TaskType.NOTATWORK;
	}
	
	/**
	 * On switching tasks add the elapsed time on the previous
	 * task to its corresponding total as well as the overall 
	 * total. Don't add to anything if the previous task was 
	 * TaskType.NOTATWORK.
	 * 
	 * @param TaskType task that the employee is switching too.
	 */
	public void calcStats( TaskType task ){
		int endTime = (int) (Clock.getTime()/10);
		
		if( prevTask.equals(TaskType.MEETING) ){
			meetings += endTime - prevTime;
		} else if ( prevTask.equals(TaskType.LUNCH) ){
			lunch += endTime - prevTime;
		} else if ( prevTask.equals(TaskType.QUESTION) ){
			questions += endTime - prevTime;
		} else if ( prevTask.equals(TaskType.WORK) ){
			working += endTime - prevTime;
		}
		
		if( !prevTask.equals(TaskType.NOTATWORK) ){
			total += endTime - prevTime;
		}
		
		this.prevTime = endTime;
		this.prevTask = task;
	}
	
	
	
	public int getWorking() {
		return working;
	}

	public int getLunch() {
		return lunch;
	}

	public int getMeetings() {
		return meetings;
	}

	public int getQuestions() {
		return questions;
	}

	public int getTotal() {
		return total;
	}

	public String toString(){
		return "Total Time: " + total + " minutes. \n"
			+ "\tWorking for " + working + " minutes.\n\tLunch for " + lunch +
			" minutes.\n\tQuestions for " + questions + " minutes.\n\t" + 
			"Meetings for " + meetings + " minutes.";
	}
	
}
