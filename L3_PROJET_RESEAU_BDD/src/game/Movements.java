package game;

import java.io.IOException;

import query.FightQuery;

import core.VariableRepository;
import data.VariableFactory;
import game.Map;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class Movements {
	private int currentPlayerPositionX; //width
	private int currentPlayerPositionY; //height
	private Map map; //INITIALISER DANS CONSTRUCTEUR
	
	
	// On va cr�er un joueur ici
	/**
	 * Create Movements, to move the player on the map
	 * 
	 * @param width
	 * @param height
	 * @param monsterPercentage
	 * @param obstaclePercentage
	 * @param xPlayer
	 * @param yPlayer
	 */
	public Movements(int width, int height, int monsterPercentage, int obstaclePercentage, int xPlayer, int yPlayer) {
		this.map = new Map(height, width, monsterPercentage, obstaclePercentage);
		
		// PlayersCharacter (String name, int health, int attack, int defense, String variableName, int experience, String gender, PlayersStuff stuff, PlayersStatistics stats)
		// Faudra donc mettre un query ici pour pouvoir cr�er le personnage suivant ce qui se trouve sur la base de donn�es
		// PlayersCharacter player = new PlayersCharacter("Marcross", 20, 3, 2, 0,"male",null,null);
		PlayersStuff playersStuff = new PlayersStuff();
		PlayersStatistics playersStatistics = new PlayersStatistics(0,0,0);
		// PlayersCharacter player = (PlayersCharacter) VariableFactory.getInstance().createVariable("PlayersCharacter", "Marcross", 20, 3, 2);
		PlayersCharacter player = (PlayersCharacter) VariableFactory.createVariable("PlayersCharacter", "Marcross", 20, 3, 2);
		VariableRepository.getInstance().register("player1", player);
		((PlayersCharacter) VariableRepository.getInstance().searchByName("player1")).setStuff(playersStuff);
		((PlayersCharacter) VariableRepository.getInstance().searchByName("player1")).setStats(playersStatistics);
		this.currentPlayerPositionX = xPlayer;
		this.currentPlayerPositionY = yPlayer;
		
		//On ins�re dans le stock de variables le bool�en characterInFight, qui nous permettra de savoir de n'importe o� si le personnage est en combat ou non
		
		VariableRepository.getInstance().register("characterInFight", false);
	}
	
	
	/**
	 * Get the required movement and move the player if it is possible
	 * 
	 * @param letter
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void movement(char letter) throws IOException, InterruptedException {
		switch(letter) {
			case 'z': this.moveUp(); //UP
					break;
					
			case 'q': this.moveLeft(); //LEFT
					break;
					
			case 's': this.moveDown(); //DOWN
					break;
					
			case 'd': this.moveRight(); //RIGHT
					break;
					
			default: System.out.println("Error: z,q,s,d expected!");
					break;
		}
		
		if(map.getPositionInMap(currentPlayerPositionX, currentPlayerPositionY)=='M') {
			// System.out.println("Valeur de characterInFight avant modification dans le VariableRepository " + VariableRepository.getInstance().searchByName("characterInFight"));
			VariableRepository.getInstance().register("characterInFight", true);
			// ((PlayersCharacter) VariableRepository.getInstance().searchByName("PlayersCharacter")).getStats().setNbFights();;
			// System.out.println("Valeur de characterInFight apr�s modification dans le VariableRepository " + VariableRepository.getInstance().searchByName("characterInFight"));

/****************requete*****************/			
			boolean resultQuery=FightQuery.FightQuery();
			
			return;
			//LET'S FIGHT
			// System.out.println("FIght Begin !!");
			
			// System.out.println("D�but du combat !");
			// System.out.println("Veuillez choisir si vous souhaitez attaquer l'ennemi (a) ou vous d�fendre pendant le tour ennemi (d).");
			
			// Fight fight = new Fight();
			// qsfight.inFight();
		}
	}
	
	/**
	 * Move the player up if it is possible
	 */
	private void moveUp() {
		int currentX = this.getCurrentPlayerPositionX();
		int currentY = this.getCurrentPlayerPositionY();

		if(map.playerCanMoveHere(currentX, currentY-1)) {
			//Can move to this place
			this.setCurentPlayerPositionY(currentY-1);
		}
	}
	
	/**
	 * Move the player down if it is possible
	 */
	private void moveDown() {
		int currentX = this.getCurrentPlayerPositionX();
		int currentY = this.getCurrentPlayerPositionY();

		if(map.playerCanMoveHere(currentX, currentY+1)) {
			//Can move to this place
			this.setCurentPlayerPositionY(currentY+1);
		}
	}
	
	/**
	 * Move the player right if it is possible
	 */
	private void moveRight() {
		int currentX = this.getCurrentPlayerPositionX();
		int currentY = this.getCurrentPlayerPositionY();

		if(map.playerCanMoveHere(currentX+1, currentY)) {
			//Can move to this place
			this.setCurentPlayerPositionX(currentX+1);
		}
	}
	
	/**
	 * Move the player left if it is possible
	 */
	private void moveLeft() {
		int currentX = this.getCurrentPlayerPositionX();
		int currentY = this.getCurrentPlayerPositionY();

		if(map.playerCanMoveHere(currentX-1, currentY)) {
			//Can move to this place
			this.setCurentPlayerPositionX(currentX-1);
		}
	}
	
	/**
	 * Get the current X coordinates of the player 
	 * 
	 * @return the curentPlayerPositionX
	 */
	public int getCurrentPlayerPositionX() {
		return currentPlayerPositionX;
	}
	
	/**
	 * Get the current Y coordinates of the player 
	 * 
	 * @return the curentPlayerPositionY
	 */
	public int getCurrentPlayerPositionY() {
		return currentPlayerPositionY;
	}
	
	/**
	 * Get the map
	 * 
	 * @return the current map
	 */
	public Map getMap() {
		return this.map;
	}
	
	/**
	 * Set the current X coordinates of the player 
	 * 
	 * @param curentPlayerPositionX the curentPlayerPositionX to set
	 */
	public void setCurentPlayerPositionX(int curentPlayerPositionX) {
		this.currentPlayerPositionX = curentPlayerPositionX;
	}
	
	/**
	 * Set the current Y coordinates of the player 
	 * 
	 * @param curentPlayerPositionY the curentPlayerPositionY to set
	 */
	public void setCurentPlayerPositionY(int curentPlayerPositionY) {
		this.currentPlayerPositionY = curentPlayerPositionY;
	}

	/**
	 * Set the map
	 * 
	 * @param mapToSet
	 */
	public void setMap(Map mapToSet) {
		this.map = mapToSet;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InteractionOnWorldMapHandler [curentPlayerPositionX=" + currentPlayerPositionX
				+ ", curentPlayerPositionY=" + currentPlayerPositionY + "]";
	}
}
