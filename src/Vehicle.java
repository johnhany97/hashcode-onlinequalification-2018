import java.util.ArrayList;

public class Vehicle {
	private Ride ride;
	private int row;
	private int column;
	private ArrayList<Integer> ridesTaken;
	
	public Vehicle() {
		this.row = 0;
		this.column = 0;
		this.ride = null;
		this.ridesTaken = new ArrayList<Integer>();
	}

	public void setRide(Ride ride) {
		this.ride = ride;
	}
	
	public Ride getRide() {
		return this.ride;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getColumn() {
		return this.column;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public void setColumn(int column) {
		this.column = column;
	}

	public int getDistance(int row, int column) {
		return Math.abs(this.row - row) + Math.abs(this.column - column);
	}
	
	public String outputOfVehicle() {
		if (ridesTaken.size() == 0) return "0";
		StringBuilder sb = new StringBuilder();
		sb.append(ridesTaken.size());
		for (int i = 0; i < ridesTaken.size(); i++) {
			sb.append(" " + ridesTaken.get(i));
		}
		return sb.toString();
	}
}
