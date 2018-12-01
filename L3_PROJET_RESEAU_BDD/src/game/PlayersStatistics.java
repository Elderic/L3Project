package game;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class PlayersStatistics {
	private int nbFights;
	private int nbVictories;
	private int nbDefeats;
	
	
	/**
	 * Create player's statistics
	 * 
	 * @param nbFights
	 * @param nbWins
	 * @param nbLoses
	 */
	public PlayersStatistics(int nbFights, int nbWins, int nbLoses) {
		this.nbFights = nbFights;
		this.nbVictories = nbWins;
		this.nbDefeats = nbLoses;
	}
	
	
	/**
	 * Get the fights number of the player
	 * 
	 * @return the nbFights
	 */
	public int getNbFights() {
		return nbFights;
	}
	
	/**
	 * Get the victories number of the player
	 * 
	 * @return the nbVictories
	 */
	public int getNbVictories() {
		return nbVictories;
	}
	
	/**
	 * Get the defeats number of the player
	 * 
	 * @return the nbDefeats
	 */
	public int getNbDefeats() {
		return nbDefeats;
	}
	
	/**
	 * Set the fights number of the player
	 * 
	 * @param nb_Fights the nbFights to set
	 */
	public void setNbFights(int nbFights) {
		this.nbFights = nbFights;
	}
	
	/**
	 * Set the victories number of the player
	 * 
	 * @param nbVictories the nbVictories to set
	 */
	public void setNbVictories(int nbVictories) {
		this.nbVictories = nbVictories;
	}
	
	/**
	 * Set the defeats number of the player
	 * 
	 * @param nbDefeats the nbDefeats to set
	 */
	public void setNbDefeats(int nbDefeats) {
		this.nbDefeats = nbDefeats;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PlayersStatistics [nbFights=" + nbFights + ", nbVictories=" + nbVictories + ", nbDefeats="
				+ nbDefeats + "]";
	}
}
