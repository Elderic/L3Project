/**
 * 
 */
package game;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class EnemyCharacter extends Character {
	private String type;
	private String rarity;
	
	public EnemyCharacter(String name, int health, int attack, int defense) {
		super(name, health, attack, defense);
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @return the rarity
	 */
	public String getRarity() {
		return rarity;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
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
