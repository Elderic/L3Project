package checker.core;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;

import checker.gui.BoardParameter;

public class GameVariableRepository {
	
	// Varies from 0 to 2, each digits indicating a player. Will varies between the turns.
	private int playerTurn;
	
	private String actualPlayerName;
	private String previousPlayerName;

	
	
	private boolean aPieceIsSelected;
	private boolean gameStarted;
	private boolean isUpdating;
	private int indexOfEmplacementToBeEmptied;
	private int nbRound;
	private boolean player3Exists;
	
	
	private GameVariableRepository() {
		
		this.playerTurn = 0;
		this.actualPlayerName = "Player 1";
		this.indexOfEmplacementToBeEmptied = 0;
		this.gameStarted = false;
		this.isUpdating = false;
		this.nbRound=0;
		this.player3Exists=true;
	}
	
	static GameVariableRepository instance = new GameVariableRepository();
	
	
	
	
	
	
	
	
	
}