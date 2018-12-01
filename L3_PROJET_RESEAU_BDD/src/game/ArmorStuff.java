package game;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class ArmorStuff extends Stuff {
	private int defense;
	
	
	/**
	 * Get the defense of the armor
	 * 
	 * @return defense
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * Set the defense of the armor
	 * 
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
