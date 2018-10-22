/**
 * 
 */
package game;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class Character {
	private String name;
	private int health;
	private int attack;
	private int defense;
	
	
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
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
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
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
		return "Character [name=" + name + ", health=" + health + ", attack=" + attack + ", defense=" + defense + "]";
	}
}
