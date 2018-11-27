/**
 * 
 */
package game;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class Stuff {
	private String name;
	private String type;
	private String rarity;
	private String description;
	private int attack;
	private int defense;

	
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	public int getAttack(){
		return attack;
	}
	public int getDefense(){
		return defense;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	public void setAttack(int attack){
		this.attack=attack;
	}
	public void setDefense(int defense){
		this.defense=defense;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Stuff [name=" + name + ", type=" + type + ", rarity=" + rarity + ", description=" + description 
				+ ", attack=" +attack+", defense="+defense+"]";
	}
}
