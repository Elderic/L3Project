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
	 * Create a Character
	 * 
	 * @param name
	 * @param health
	 * @param attack
	 * @param defense
	 */
	public Character ( String name, int health, int attack, int defense) {
		this.name = name;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
	}
	
	/**
	 * Get the name of the character
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Get the health of the character
	 * 
	 * @return the health
	 */
	public int getHealth() {
		return this.health;
	}
	
	/**
	 * Get the attack of the character
	 * 
	 * @return the attack
	 */
	public int getAttack() {
		return this.attack;
	}
	
	/**
	 * Get the defense of the character
	 * 
	 * @return the defense
	 */
	public int getDefense() {
		return this.defense;
	}
	
	/**
	 * Set the name of the character
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Set the health of the character
	 * 
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	
	/**
	 * Set the attack of the character
	 * 
	 * @param attack the attack to set
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	/**
	 * Set the defense of the character
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
		return "Character [name=" + name + ", health=" + health + ", attack=" + attack + ", defense=" + defense + "]";
	}
}
