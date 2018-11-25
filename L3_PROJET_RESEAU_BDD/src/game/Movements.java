/**
 * 
 */
package game;

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
	
	// On va créer un joueur ici
	public Movements(int width, int height, int monsterPercentage, int obstaclePercentage, int xPlayer, int yPlayer) {
		this.map = new Map(height, width, monsterPercentage, obstaclePercentage);
		
		// PlayersCharacter (String name, int health, int attack, int defense, String variableName, int experience, String gender, PlayersStuff stuff, PlayersStatistics stats)
		// Faudra donc mettre un query ici pour pouvoir créer le personnage suivant ce qui se trouve sur la base de données
		// PlayersCharacter player = new PlayersCharacter("Marcross", 20, 3, 2, 0,"male",null,null);
		PlayersStuff playersStuff = new PlayersStuff();
		PlayersStatistics playersStatistics = new PlayersStatistics(0,0,0);
		PlayersCharacter player = (PlayersCharacter) VariableFactory.getInstance().createVariable("PlayersCharacter", "Marcross", 20, 3, 2);
		VariableRepository.getInstance().register("player1", player);
		((PlayersCharacter) VariableRepository.getInstance().searchByName("player1")).setStuff(playersStuff);
		((PlayersCharacter) VariableRepository.getInstance().searchByName("player1")).setStats(playersStatistics);
		this.currentPlayerPositionX = xPlayer;
		this.currentPlayerPositionY = yPlayer;
		
		//On insère dans le stock de variables le booléen characterInFight, qui nous permettra de savoir de n'importe où si le personnage est en combat ou non
		
		VariableRepository.getInstance().register("characterInFight", false);
	}
	
	public void movement(char letter) {
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
			VariableRepository.getInstance().modify("characterInFight", true);
			// ((PlayersCharacter) VariableRepository.getInstance().searchByName("PlayersCharacter")).getStats().setNb_fights();;
			// System.out.println("Valeur de characterInFight après modification dans le VariableRepository " + VariableRepository.getInstance().searchByName("characterInFight"));
			
			return;
			//LET'S FIGHT
			// System.out.println("FIght Begin !!");
			
			// System.out.println("Début du combat !");
			// System.out.println("Veuillez choisir si vous souhaitez attaquer l'ennemi (a) ou vous défendre pendant le tour ennemi (d).");
			
			// Fight fight = new Fight();
			// qsfight.inFight();
		}
	}
	
	private void moveUp() {
		int currentX = this.getCurrentPlayerPositionX();
		int currentY = this.getCurrentPlayerPositionY();

		if(map.playerCanMoveHere(currentX, currentY-1)) {
			//Can move to this place
			this.setCurentPlayerPositionY(currentY-1);
		}
	}
	
	private void moveDown() {
		int currentX = this.getCurrentPlayerPositionX();
		int currentY = this.getCurrentPlayerPositionY();

		if(map.playerCanMoveHere(currentX, currentY+1)) {
			//Can move to this place
			this.setCurentPlayerPositionY(currentY+1);
		}
	}
	
	private void moveRight() {
		int currentX = this.getCurrentPlayerPositionX();
		int currentY = this.getCurrentPlayerPositionY();

		if(map.playerCanMoveHere(currentX+1, currentY)) {
			//Can move to this place
			this.setCurentPlayerPositionX(currentX+1);
		}
	}
	
	private void moveLeft() {
		int currentX = this.getCurrentPlayerPositionX();
		int currentY = this.getCurrentPlayerPositionY();

		if(map.playerCanMoveHere(currentX-1, currentY)) {
			//Can move to this place
			this.setCurentPlayerPositionX(currentX-1);
		}
	}
	
	
	/**
	 * @return the curentPlayerPositionX
	 */
	public int getCurrentPlayerPositionX() {
		return currentPlayerPositionX;
	}
	
	/**
	 * @return the curentPlayerPositionY
	 */
	public int getCurrentPlayerPositionY() {
		return currentPlayerPositionY;
	}
	
	/**
	 * @return the current map attribute
	 */
	public Map getMap() {
		return this.map;
	}
	
	/**
	 * @param curentPlayerPositionX the curentPlayerPositionX to set
	 */
	public void setCurentPlayerPositionX(int curentPlayerPositionX) {
		this.currentPlayerPositionX = curentPlayerPositionX;
	}
	
	/**
	 * @param curentPlayerPositionY the curentPlayerPositionY to set
	 */
	public void setCurentPlayerPositionY(int curentPlayerPositionY) {
		this.currentPlayerPositionY = curentPlayerPositionY;
	}

	/**
	 * 
	 * @param mapToSet the current map to set
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
