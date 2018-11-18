/**
 * 
 */
package game;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class PlayersCharacter extends Character {
	private int experience;
	private String gender;
	private PlayersStuff stuff;
	private PlayersStatistics stats;
	
	private int level;
	
	public PlayersCharacter (String name, int health, int attack, int defense, int experience, String gender, PlayersStuff stuff, PlayersStatistics stats) {
		super(name, health, attack, defense);
		this.experience = experience;
		this.gender = gender;
		this.stuff = stuff;
		this.stats = stats;
	}
	
	public PlayersCharacter (String name, int health, int attack, int defense) {
		super(name, health, attack, defense);
	}

	public void calculateLevel() {
		int level = (int) Math.log(this.experience);
		this.setLevel(level);
	}


	/**
	 * @return the experience
	 */
	public int getExperience() {
		return this.experience;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return this.gender;
	}

	/**
	 * @return the stuff
	 */
	public PlayersStuff getStuff() {
		return this.stuff;
	}

	/**
	 * @return the stats
	 */
	public PlayersStatistics getStats() {
		return this.stats;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return this.level;
	}

	/**
	 * @param experience the experience to set
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @param stuff the stuff to set
	 */
	public void setStuff(PlayersStuff stuff) {
		this.stuff = stuff;
	}

	/**
	 * @param stats the stats to set
	 */
	public void setStats(PlayersStatistics stats) {
		this.stats = stats;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PlayersCharacter [experience=" + experience + ", gender=" + gender + ", stuff=" + stuff + ", stats="
				+ stats + ", level=" + level + "]";
	}
}
