import java.util.ArrayList;

public class Vehicle {
	private Ride ride;
	private int row;
	private int column;
	private ArrayList<Integer> ridesTaken;
	private int availableIn;
	
	public Vehicle() {
		this.row = 0;
		this.column = 0;
		this.ride = null;
		this.ridesTaken = new ArrayList<Integer>();
		this.availableIn = 0;
	}

	public void setRide(Ride ride, int num) {
		this.ride = ride;
		ridesTaken.add(ride.getIndex());
		this.availableIn = num - 1;
		this.ride.setTaken();
	}
	
	public void endRide() {
		this.row = this.ride.getRowFinish();
		this.column = this.ride.getColFinish();
		this.availableIn = 0;
		this.ride = null;
	}
	
	public boolean isTaken() {
		return ride == null;
	}
	
	public void update() {
		if (availableIn == 0) endRide();
		else availableIn--;
	}
	
	/**
	 * @return the availableIn
	 */
	public int getAvailableIn() {
		return availableIn;
	}

	/**
	 * @param availableIn the availableIn to set
	 */
	public void setAvailableIn(int availableIn) {
		this.availableIn = availableIn;
	}

	/**
	 * @param ride the ride to set
	 */
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
