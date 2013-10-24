
public class Manager extends Employee {
	
	public Manager( int team, int position, int arrivalTime ){
		super(team,position,arrivalTime);
		super.type = Positions.MANAGER;
	}
	
	@Override
	public String toString() {
		return "Manager";
	}

}
