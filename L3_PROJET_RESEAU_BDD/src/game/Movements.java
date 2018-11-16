/**
 * 
 */
package game;

import game.Map;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class Movements {
	private int currentPlayerPositionX; //width
	private int currentPlayerPositionY; //height
	private Map map; //INITIALISER DANS CONSTRUCTEUR
	
	
	public Movements(int width, int height, int monsterPercentage, int obstaclePercentage, int xPlayer, int yPlayer) {
		this.map = new Map(height, width, monsterPercentage, obstaclePercentage);
		this.currentPlayerPositionX = xPlayer;
		this.currentPlayerPositionY = yPlayer;
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
			//LET'S FIGHT
			System.out.println("FIght Begin !!");
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
