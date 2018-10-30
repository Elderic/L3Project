/**
 * 
 */
package game;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class WeaponStuff extends Stuff {
	private int damage;

	
	
	/**
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Weapon [damage=" + damage + "]";
	}
}
