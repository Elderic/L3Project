package game;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class EnemyCharacter extends Character {
	private String type;
	private String rarity;
	
	
	/**
	 * Create an Enemy
	 * 
	 * @param name
	 * @param health
	 * @param attack
	 * @param defense
	 */
	public EnemyCharacter(String name, int health, int attack, int defense) {
		super(name, health, attack, defense);
	}
	
	
	/**
	 * Get the type of the enemy
	 * 
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Get the rarity of the enemy
	 * 
	 * @return the rarity
	 */
	public String getRarity() {
		return rarity;
	}
	
	/**
	 * Set the type of the enemy
	 * 
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Set the rarity of the enemy
	 * 
	 * @param rarity the rarity to set
	 */
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EnemyCharacter [type=" + type + ", rarity=" + rarity + "]";
	}
}
