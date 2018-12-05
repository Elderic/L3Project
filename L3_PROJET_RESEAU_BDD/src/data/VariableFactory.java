package data;

import game.*;

/**
 * @author Amaury SIHARATH
 *
 */
public class VariableFactory {
	private static VariableFactory instance = new VariableFactory();
	
	/**
	 * This class is used as a Singleton. So the class is instantiaded only once in the entire program. This class is used to create every Variable useful for the game.
	 */
	private VariableFactory() {

	}

	
	/**
	 * Return the only instance of this class.
	 * 
	 * @return instance
	 */
	public static VariableFactory getInstance() {
		return instance;
	}
	
	/**
	 * Used to create the statistics of a player.
	 * 
	 * @param nbFight Number of fights of a player that is going to be set.
	 * @param nbWin Number of wins of a player that is going to be set.
	 * @param nbLose Number of loses of a player that is going to be set.
	 * 
	 * @return playerStats An object containing the stats of a player.
	 */
	public static Object createPlayersStatistics(int nbFight, int nbWin, int nbLose) {
		PlayersStatistics playersStats = new PlayersStatistics(nbFight, nbWin, nbLose);
		return playersStats;
	}
	
	/**
	 * Used to instantiate the stuff of a player.
	 * 
	 * @return playerStuff An object containing the stuff of a player.
	 */
	public static Object createPlayersStuff() {
		PlayersStuff playersStuff = new PlayersStuff();
		return playersStuff;
	}
	
	/**
	 * Used to create a player-class or an enemy-class object.
	 * 
	 * @param type A string, which indicates the type of variable we want to create. Parameters should be "PlayersCharacter" or "EnemyCharacter".
	 * @param name Name of the character or the monster
	 * @param health Amount of Health of the character or the monster
	 * @param attack Attack capacity of the character or the monster
	 * @param defense Defence capacity of the character or the monster
	 * 
	 * @return An enemy, a playerCharacter or null
	 */
	public static Object createVariable(String type, String name, int health, int attack, int defense) {
		switch (type) {
		case "PlayersCharacter":
			PlayersCharacter player = new PlayersCharacter(name, health, attack, defense);
			System.out.println("Character Variable creation");
			return player;
		case "EnemyCharacter":
			EnemyCharacter enemy= new EnemyCharacter(name, health, attack, defense);
			System.out.println("Enemy Variable creation");
			return enemy;
		default:
			return null;
		}
	}
}
