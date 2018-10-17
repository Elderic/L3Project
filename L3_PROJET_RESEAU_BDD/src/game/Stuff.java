/**
 * 
 */
package game;

import java.util.Arrays;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class Stuff {
	private String name;
	private String type;
	private String rarity;
	private String description;
	private Skill skills[];
	private int weight;
	
	
	
	
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
	
	/**
	 * @return the skills
	 */
	public Skill[] getSkills() {
		return skills;
	}
	
	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
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
	
	/**
	 * @param skills the skills to set
	 */
	public void setSkills(Skill[] skills) {
		this.skills = skills;
	}
	
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Stuff [name=" + name + ", type=" + type + ", rarity=" + rarity + ", description=" + description
				+ ", skills=" + Arrays.toString(skills) + ", weight=" + weight + "]";
	}
}
