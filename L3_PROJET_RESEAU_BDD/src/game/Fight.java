/**
 * 
 */
package game;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class Fight {
	private EnemyCharacter enemy;
	private PlayersCharacter player;
	
	
	
	
	/**
	 * @return the enemy
	 */
	public EnemyCharacter getEnemy() {
		return enemy;
	}
	
	/**
	 * @return the player
	 */
	public PlayersCharacter getPlayer() {
		return player;
	}
	
	/**
	 * @param enemy the enemy to set
	 */
	public void setEnemy(EnemyCharacter enemy) {
		this.enemy = enemy;
	}
	
	/**
	 * @param player the player to set
	 */
	public void setPlayer(PlayersCharacter player) {
		this.player = player;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Fight [enemy=" + enemy + ", player=" + player + "]";
	}
}
