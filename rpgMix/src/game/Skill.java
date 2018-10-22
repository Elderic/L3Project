/**
 * 
 */
package game;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class Skill {
	private String skillName;

	
	/**
	 * @param skillName the skillName to set
	 * */
	public Skill(String skillName) {
		this.setSkillName(skillName);
	}
	
	
	/**
	 * @return the skillName
	 */
	public String getSkillName() {
		return skillName;
	}

	/**
	 * @param skillName the skillName to set
	 */
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Skill [skillName=" + skillName + "]";
	}
}
