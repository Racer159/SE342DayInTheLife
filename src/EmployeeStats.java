
public class EmployeeStats {
	
	private int prevTime;
	private TaskType prevTask;
	
	private int working;
	private int lunch;
	private int meetings;
	private int questions;
	private int total;
	
	public EmployeeStats( int arrivalTime ){
		this.working = 0;
		this.lunch = 0;
		this.meetings = 0;
		this.questions = 0;
		this.total = 0;
		this.prevTime = arrivalTime;
		this.prevTask = TaskType.NOTATWORK;
	}
	
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
