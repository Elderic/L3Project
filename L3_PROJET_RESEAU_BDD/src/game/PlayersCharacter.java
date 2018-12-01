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
	
	
	/**
	 * Create a player's character
	 * 
	 * @param name
	 * @param health
	 * @param attack
	 * @param defense
	 * @param experience
	 * @param gender
	 * @param stuff
	 * @param stats
	 */
	public PlayersCharacter (String name, int health, int attack, int defense, int experience, String gender, PlayersStuff stuff, PlayersStatistics stats) {
		super(name, health, attack, defense);
		this.experience = experience;
		this.gender = gender;
		this.stuff = stuff;
		this.stats = stats;
	}
	
	/**
	 * Create a player's character
	 * 
	 * @param name
	 * @param health
	 * @param attack
	 * @param defense
	 */
	public PlayersCharacter (String name, int health, int attack, int defense) {
		super(name, health, attack, defense);
	}

	
	/**
	 * Calculate the level of the player with his current experience
	 */
	public void calculateLevel() {
		int level = (int) Math.log(this.experience);
		this.setLevel(level);
	}

	/**
	 * Get the experience of the player
	 * 
	 * @return the experience
	 */
	public int getExperience() {
		return this.experience;
	}

	/**
	 * Get the gender of the player
	 * 
	 * @return the gender
	 */
	public String getGender() {
		return this.gender;
	}

	/**
	 * Get the stuff of the player
	 * 
	 * @return the stuff
	 */
	public PlayersStuff getStuff() {
		return this.stuff;
	}

	/**
	 * Get the statistics of the player
	 * 
	 * @return the stats
	 */
	public PlayersStatistics getStats() {
		return this.stats;
	}

	/**
	 * Get the level of the player
	 * 
	 * @return the level
	 */
	public int getLevel() {
		return this.level;
	}

	/**
	 * Set the experience of the player
	 * 
	 * @param experience the experience to set
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * Set the gender of the player
	 * 
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Set the stuff of the player
	 * 
	 * @param stuff the stuff to set
	 */
	public void setStuff(PlayersStuff stuff) {
		this.stuff = stuff;
	}

	/**
	 * Set the statistics of the player
	 * 
	 * @param stats the stats to set
	 */
	public void setStats(PlayersStatistics stats) {
		this.stats = stats;
	}

	/**
	 * Set the level of the player
	 * 
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
