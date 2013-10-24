
public class TeamLead extends Employee {
	
	public TeamLead (int team, int position, int arrivalTime) {
		super(team,position,arrivalTime);
		this.type = Positions.TEAMLEAD;
	}
}
