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
	 * Get the name of the stuff
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get the type of the stuff
	 * 
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Get the rarity of the stuff
	 * 
	 * @return the rarity
	 */
	public String getRarity() {
		return rarity;
	}
	
	/**
	 * Get the description of the stuff
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Get the attack of the stuff
	 * 
	 * @return the attack
	 */
	public int getAttack(){
		return attack;
	}
	
	/**
	 * Get the defense of the stuff
	 * 
	 * @return the defense
	 */
	public int getDefense(){
		return defense;
	}
	
	/**
	 * Set the name of the stuff
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Set the type of the stuff
	 * 
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Set the rarity of the stuff
	 * 
	 * @param rarity the rarity to set
	 */
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
	
	/**
	 * Set the description of the stuff
	 * 
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Set the attack of the stuff
	 * 
	 * @param attack the attack to set
	 */
	public void setAttack(int attack){
		this.attack=attack;
	}
	
	/**
	 * Set the defense of the stuff
	 * 
	 * @param defense the defense to set
	 */
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
