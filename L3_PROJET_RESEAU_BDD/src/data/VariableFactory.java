package data;

import core.VariableRepository;

//import java.util.logging.Logger;

// import org.apache.log4j.Logger;

import game.EnemyCharacter;
import game.PlayersCharacter;
import game.PlayersStatistics;
import game.PlayersStuff;

public class VariableFactory {
	private VariableFactory() {

	}

	private static VariableFactory instance = new VariableFactory();

	public static VariableFactory getInstance() {
		return instance;
	}
	// private static Logger logger = LoggerUtility.getLogger(VariableFactory.class);
	
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
	
	public static Object createPlayersStatistics(int nbFight, int nbWin, int nbLose) {
		PlayersStatistics playersStats = new PlayersStatistics(nbFight, nbWin, nbLose);
		return playersStats;
	}
	
	public static Object createPlayersStuff() {
		PlayersStuff playersStuff = new PlayersStuff();
		return playersStuff;
	}
	
	public static Object createVariable(String type, String name, int health, int attack, int defense) {
		/*
		Variable variable = new Variable(name);
		logger.info("Variable creation with name : " + name);
		return variable;
	*/
		switch (type) {
		case "PlayersCharacter":
			PlayersCharacter player = new PlayersCharacter(name, health, attack, defense);
			// logger.info("Character Variable creation");
			System.out.println("Character Variable creation");
			return player;
		case "EnemyCharacter":
			EnemyCharacter enemy= new EnemyCharacter(name, health, attack, defense);
			// logger.info("Enemy Variable creation");
			System.out.println("Enemy Variable creation");
			return enemy;
		default:
			return null;
		}
	}
}
