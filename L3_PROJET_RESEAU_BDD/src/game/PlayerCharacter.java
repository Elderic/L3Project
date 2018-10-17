/**
 * 
 */
package game;

import java.util.Arrays;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class PlayerCharacter extends Character {
	private int experience;
	private int level;
	private String gender;
	private Skill skills[];
	private Stuff stuff[];
	
	
	
	
	public void calculateLevel() {
		int level = (int) Math.log(this.experience);
		this.setLevel(level);
	}
	
	
	/**
	 * @return the experience
	 */
	public int getExperience() {
		return experience;
	}
	
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * @return the skills
	 */
	public Skill[] getSkills() {
		return skills;
	}
	
	/**
	 * @return the stuff
	 */
	public Stuff[] getStuff() {
		return stuff;
	}
	
	/**
	 * @param experience the experience to set
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * @param skills the skills to set
	 */
	public void setSkills(Skill[] skills) {
		this.skills = skills;
	}
	
	/**
	 * @param stuff the stuff to set
	 */
	public void setStuff(Stuff[] stuff) {
		this.stuff = stuff;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PlayerCharacter [experience=" + experience + ", level=" + level + ", gender=" + gender + ", skills="
				+ Arrays.toString(skills) + "]";
	}
}
