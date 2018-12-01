package game;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class PlayersStuff {
	private Stuff helmet;
	private Stuff epaulets;
	private Stuff breastplate;
	private Stuff leggings;
	private Stuff shoes;
	private Stuff armbands;
	private Stuff weapon;
	
	
	/**
	 * Create a stuff of a player
	 */
	public PlayersStuff() {
		this.helmet = null;
		this.epaulets = null;
		this.breastplate = null;
		this.leggings = null;
		this.shoes = null;
		this.armbands = null;
		this.weapon = null;
	}
	
	
	/**
	 * Get the helmet of the player
	 * 
	 * @return the helmet
	 */
	public Stuff getHelmet() {
		return helmet;
	}
	
	/**
	 * Get the epaulets of the player
	 * 
	 * @return the epaulets
	 */
	public Stuff getEpaulets() {
		return epaulets;
	}
	
	/**
	 * Get the breastplate of the player
	 * 
	 * @return the breastplate
	 */
	public Stuff getBreastplate() {
		return breastplate;
	}
	
	/**
	 * Get the leggings of the player
	 * 
	 * @return the leggings
	 */
	public Stuff getLeggings() {
		return leggings;
	}
	
	/**
	 * Get the shoes of the player
	 * 
	 * @return the shoes
	 */
	public Stuff getShoes() {
		return shoes;
	}
	
	/**
	 * Get the armbands of the player
	 * 
	 * @return the armbands
	 */
	public Stuff getArmbands() {
		return armbands;
	}
	
	/**
	 * Get the weapon of the player
	 * 
	 * @return the weapon
	 */
	public Stuff getWeapon() {
		return weapon;
	}
	
	/**
	 * Set the helmet of the player
	 * 
	 * @param helmet the helmet to set
	 */
	public void setHelmet(Stuff helmet) {
		this.helmet = helmet;
	}
	
	/**
	 * Set the epaulets of the player
	 * 
	 * @param epaulets the epaulets to set
	 */
	public void setEpaulets(Stuff epaulets) {
		this.epaulets = epaulets;
	}
	
	/**
	 * Set the breastplate of the player
	 * 
	 * @param breastplate the breastplate to set
	 */
	public void setBreastplate(Stuff breastplate) {
		this.breastplate = breastplate;
	}
	
	/**
	 * Set the leggings of the player
	 * 
	 * @param leggings the leggings to set
	 */
	public void setLeggings(Stuff leggings) {
		this.leggings = leggings;
	}
	
	/**
	 * Set the shoes of the player
	 * 
	 * @param shoes the shoes to set
	 */
	public void setShoes(Stuff shoes) {
		this.shoes = shoes;
	}
	
	/**
	 * Set the armbands of the player
	 * 
	 * @param armbands the armbands to set
	 */
	public void setArmbands(Stuff armbands) {
		this.armbands = armbands;
	}
	
	/**
	 * Set the weapon of the player
	 * 
	 * @param weapon the weapon to set
	 */
	public void setWeapon(Stuff weapon) {
		this.weapon = weapon;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PlayersStuff [helmet=" + helmet + ", epaulets=" + epaulets + ", breastplate=" + breastplate
				+ ", leggings=" + leggings + ", shoes=" + shoes + ", armbands=" + armbands + ", weapon=" + weapon + "]";
	}
}
