package data;

//import java.util.logging.Logger;

//import org.apache.log4j.Logger;

import game.*;

/**
 * @author 
 *
 */
public class VariableFactory {
	private static VariableFactory instance = new VariableFactory();
	//private static Logger logger = LoggerUtility.getLogger(VariableFactory.class);
	
	
	/**
	 * 
	 */
	private VariableFactory() {

	}

	
	/**
	 * 
	 * 
	 * @return instance
	 */
	public static VariableFactory getInstance() {
		return instance;
	}
	
	
	/*
	public static Constant createConstant(int value) {
		Constant constant = new Constant(value);
		logger.info("Constant creation with value : " + value);
		return constant;
	}

	*/
	// (String name, int health, int attack, int defense, String variableName, int experience, String gender)
	/*
	public static PlayersCharacter createPlayersCharacter(String type, String name) {
		PlayersCharacter player = new PlayersCharacter(name);
		// logger.info("Character Variable creation");
		System.out.println("Character Variable creation");
		return player;
	}
	*/
	
	/**
	 * 
	 * 
	 * @param nbFight
	 * @param nbWin
	 * @param nbLose
	 * 
	 * @return playerStats
	 */
	public static Object createPlayersStatistics(int nbFight, int nbWin, int nbLose) {
		PlayersStatistics playersStats = new PlayersStatistics(nbFight, nbWin, nbLose);
		return playersStats;
	}
	
	/**
	 * 
	 * 
	 * @return playerStuff
	 */
	public static Object createPlayersStuff() {
		PlayersStuff playersStuff = new PlayersStuff();
		return playersStuff;
	}
	
	/**
	 * 
	 * 
	 * @param type
	 * @param name
	 * @param health
	 * @param attack
	 * @param defense
	 * 
	 * @return enemy or null
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
