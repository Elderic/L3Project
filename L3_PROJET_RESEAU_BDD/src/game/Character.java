/**
 * 
 */
package game;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class Character {
	protected String name;
	protected int health;
	protected int attack;
	protected int defense;
	
	public Character ( String name, int health, int attack, int defense) {
		this.name = name;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @return the health
	 */
	public int getHealth() {
		return this.health;
	}
	
	/**
	 * @return the attack
	 */
	public int getAttack() {
		return this.attack;
	}
	
	/**
	 * @return the defense
	 */
	public int getDefense() {
		return this.defense;
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
