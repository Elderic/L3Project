/**
 * 
 */
package game;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class PlayersStatistics {
	private int nb_fights;
	private int nb_victories;
	private int nb_defeats;
	
	
	
	
	
	/**
	 * @return the nb_fights
	 */
	public int getNb_fights() {
		return nb_fights;
	}
	
	/**
	 * @return the nb_victories
	 */
	public int getNb_victories() {
		return nb_victories;
	}
	
	/**
	 * @return the nb_defeats
	 */
	public int getNb_defeats() {
		return nb_defeats;
	}
	
	/**
	 * @param nb_fights the nb_fights to set
	 */
	public void setNb_fights(int nb_fights) {
		this.nb_fights = nb_fights;
	}
	
	/**
	 * @param nb_victories the nb_victories to set
	 */
	public void setNb_victories(int nb_victories) {
		this.nb_victories = nb_victories;
	}
	
	/**
	 * @param nb_defeats the nb_defeats to set
	 */
	public void setNb_defeats(int nb_defeats) {
		this.nb_defeats = nb_defeats;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PlayersStatistics [nb_fights=" + nb_fights + ", nb_victories=" + nb_victories + ", nb_defeats="
				+ nb_defeats + "]";
	}
}
