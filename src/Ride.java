import java.util.Comparator;

public class Ride {
	
	public int index;
	public int rowStart;
	public int colStart;
	public int rowFinish;
	public int colFinish;
	public int earliestStart;
	public int latestFinish;
	public Boolean taken;
	public boolean done;
	public int stepDone;
	
	public Ride(int rs, int cs, int rf, int cf, int es, int lf, int index) {
		this.rowStart = rs;
		this.colStart = cs;
		this.rowFinish = rf;
		this.colFinish = cf;
		this.earliestStart = es;
		this.latestFinish = lf;
		this.index = index;
		this.taken = false;
	}
	
	/**
	 * @return the rowStart
	 */
	public int getRowStart() {
		return rowStart;
	}

	/**
	 * @param rowStart the rowStart to set
	 */
	public void setRowStart(int rowStart) {
		this.rowStart = rowStart;
	}

	/**
	 * @return the colStart
	 */
	public int getColStart() {
		return colStart;
	}

	/**
	 * @param colStart the colStart to set
	 */
	public void setColStart(int colStart) {
		this.colStart = colStart;
	}

	/**
	 * @return the rowFinish
	 */
	public int getRowFinish() {
		return rowFinish;
	}

	/**
	 * @param rowFinish the rowFinish to set
	 */
	public void setRowFinish(int rowFinish) {
		this.rowFinish = rowFinish;
	}

	/**
	 * @return the colFinish
	 */
	public int getColFinish() {
		return colFinish;
	}

	/**
	 * @param colFinish the colFinish to set
	 */
	public void setColFinish(int colFinish) {
		this.colFinish = colFinish;
	}

	/**
	 * @return the earliestStart
	 */
	public int getEarliestStart() {
		return earliestStart;
	}

	/**
	 * @param earliestStart the earliestStart to set
	 */
	public void setEarliestStart(int earliestStart) {
		this.earliestStart = earliestStart;
	}

	/**
	 * @return the latestFinish
	 */
	public int getLatestFinish() {
		return latestFinish;
	}

	/**
	 * @param latestFinish the latestFinish to set
	 */
	public void setLatestFinish(int latestFinish) {
		this.latestFinish = latestFinish;
	}

	/**
	 * @return the taken
	 */
	public Boolean getTaken() {
		return taken;
	}

	/**
	 * @param taken the taken to set
	 */
	public void setTaken() {
		this.taken = true;
	}
	
	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getTotalTripDistance() {
		return Math.abs(this.rowStart - this.rowFinish) + Math.abs(this.colStart - this.colFinish);
	}

}

class RideComparator implements Comparator<Ride> {
	public int compare(Ride r1, Ride r2) {
		return r1.earliestStart < r2.earliestStart ? -1 : r1.earliestStart == r2.earliestStart ? 0 : 1;
	}
}