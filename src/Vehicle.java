
public class Vehicle {
	private Ride ride;
	private int row;
	private int column;
	
	public Vehicle() {
		this.row = 0;
		this.column = 0;
		this.ride = null;
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
}
