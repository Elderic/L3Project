/**
 * 
 */
package game;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class Armor extends Stuff {
	private int defense;

	
	
	/**
	 * @return the defense
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * @param defense the defense to set
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Armor [defense=" + defense + "]";
	}
}
