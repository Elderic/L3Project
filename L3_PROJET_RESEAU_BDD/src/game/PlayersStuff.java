/**
 * 
 */
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
	 * @return the helmet
	 */
	public Stuff getHelmet() {
		return helmet;
	}
	/**
	 * @return the epaulets
	 */
	public Stuff getEpaulets() {
		return epaulets;
	}
	
	/**
	 * @return the breastplate
	 */
	public Stuff getBreastplate() {
		return breastplate;
	}
	
	/**
	 * @return the leggings
	 */
	public Stuff getLeggings() {
		return leggings;
	}
	
	/**
	 * @return the shoes
	 */
	public Stuff getShoes() {
		return shoes;
	}
	
	/**
	 * @return the armbands
	 */
	public Stuff getArmbands() {
		return armbands;
	}
	
	/**
	 * @return the weapon
	 */
	public Stuff getWeapon() {
		return weapon;
	}
	
	/**
	 * @param helmet the helmet to set
	 */
	public void setHelmet(Stuff helmet) {
		this.helmet = helmet;
	}
	
	/**
	 * @param epaulets the epaulets to set
	 */
	public void setEpaulets(Stuff epaulets) {
		this.epaulets = epaulets;
	}
	
	/**
	 * @param breastplate the breastplate to set
	 */
	public void setBreastplate(Stuff breastplate) {
		this.breastplate = breastplate;
	}
	
	/**
	 * @param leggings the leggings to set
	 */
	public void setLeggings(Stuff leggings) {
		this.leggings = leggings;
	}
	
	/**
	 * @param shoes the shoes to set
	 */
	public void setShoes(Stuff shoes) {
		this.shoes = shoes;
	}
	
	/**
	 * @param armbands the armbands to set
	 */
	public void setArmbands(Stuff armbands) {
		this.armbands = armbands;
	}
	
	/**
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
