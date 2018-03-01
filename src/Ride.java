import java.util.Comparator;

public class Ride {
	
	public int rowStart;
	public int colStart;
	public int rowFinish;
	public int colFinish;
	public int earliestStart;
	public int latestFinish;
	Boolean taken;
	
	
	public Ride(int rs, int cs, int rf, int cf, int es, int lf) {
		this.rowStart = rs;
		this.colStart = cs;
		this.rowFinish = rf;
		this.colFinish = cf;
		this.earliestStart = es;
		this.latestFinish = lf;
	}
	
	public static int compare(Ride r1, Ride r2) {
		return r1.earliestStart < r2.earliestStart ? -1 : r1.earliestStart == r2.earliestStart ? 0 : 1;
	}

}

class RideComparator implements Comparator<Ride> {
	public int compare(Ride r1, Ride r2) {
		return r1.earliestStart < r2.earliestStart ? -1 : r1.earliestStart == r2.earliestStart ? 0 : 1;
	}
}