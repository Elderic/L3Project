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
	private int defense;
	private int attack;
	
	
	
	
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
	 * @return the defense
	 */
	public int getDefense() {
		return defense;
	}
	
	/**
	 * @return the attack
	 */
	public int getAttack() {
		return attack;
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
	
	/**
	 * @param defense the defense to set
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	/**
	 * @param attack the attack to set
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EnemyCharacter [type=" + type + ", rarity=" + rarity + ", defense=" + defense + ", attack=" + attack
				+ "]";
	}
}
