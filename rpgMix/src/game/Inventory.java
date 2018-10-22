/**
 * 
 */
package game;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class Inventory {
	private int max;
	private int current;
	
	
	
	
	/**
	 * @return the max
	 */
	public int getMax() {
		return max;
	}
	
	/**
	 * @return the current
	 */
	public int getCurrent() {
		return current;
	}
	
	/**
	 * @param max the max to set
	 */
	public void setMax(int max) {
		this.max = max;
	}
	
	/**
	 * @param current the current to set
	 */
	public void setCurrent(int current) {
		this.current = current;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Inventory [max=" + max + ", current=" + current + "]";
	}
}
