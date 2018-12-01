package game;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class FightAbilities {
	private int attack;
	private int defense;
	
	
	/**
	 * Create a FightAbilities
	 * 
	 * @param attack
	 * @param defense
	 */
	public FightAbilities(int attack, int defense) {
		setAttack(attack);
		setDefense(defense);
	}
	
	
	/**
	 * Get the attack
	 * 
	 * @return the attack
	 */
	public int getAttack() {
		return attack;
	}
	
	/**
	 * Get the defense
	 * 
	 * @return the defense
	 */
	public int getDefense() {
		return defense;
	}
	
	/**
	 * Set the attack
	 * 
	 * @param attack the attack to set
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	/**
	 * Set the defense
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
		return "FightAbilities [attack=" + attack + ", defense=" + defense + "]";
	}
}
