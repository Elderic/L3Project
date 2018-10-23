/**
 * 
 */
package game;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class FightAbilities {
	private int attack;
	private int defense;
	
	
	
	public FightAbilities(int attack, int defense) {
		setAttack(attack);
		setDefense(defense);
	}
	
	
	/**
	 * @return the attack
	 */
	public int getAttack() {
		return attack;
	}
	
	/**
	 * @return the defense
	 */
	public int getDefense() {
		return defense;
	}
	
	/**
	 * @param attack the attack to set
	 */
	public void setAttack(int attack) {
		this.attack = attack;
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
		return "FightAbilities [attack=" + attack + ", defense=" + defense + "]";
	}
}
