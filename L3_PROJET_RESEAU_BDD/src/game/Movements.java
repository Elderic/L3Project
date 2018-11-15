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
	private int currentPlayerPositionX = 5; //width A RECUP
	private int currentPlayerPositionY = 5; //height A RECUP
	private static Map map; //INITIALISER DANS CONSTRUCTEUR
	
	
	
	
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
		}
		
		if(map.getPositionInMap(currentPlayerPositionX, currentPlayerPositionY)=='M') {
			Fight fight = new Fight();
			fight.inFight();
		}
	}
	
	private void moveUp() {
		int currentX = this.getCurrentPlayerPositionX();
		int currentY = this.getCurrentPlayerPositionY();
		
		if(map.playerCanMoveHere(currentX, currentY+1)) {
			//Can move to this place
			this.setCurentPlayerPositionY(currentY+1);
		}
	}
	
	private void moveDown() {
		int currentX = this.getCurrentPlayerPositionX();
		int currentY = this.getCurrentPlayerPositionY();
		
		if(map.playerCanMoveHere(currentX, currentY-1)) {
			//Can move to this place
			this.setCurentPlayerPositionY(currentY-1);
		}
	}
	
	private void moveRight() {
		int currentX = this.getCurrentPlayerPositionX();
		int currentY = this.getCurrentPlayerPositionY();
		
		if(map.playerCanMoveHere(currentX+1, currentY)) {
			//Can move to this place
			this.setCurentPlayerPositionY(currentX+1);
		}
	}
	
	private void moveLeft() {
		int currentX = this.getCurrentPlayerPositionX();
		int currentY = this.getCurrentPlayerPositionY();
		
		if(map.playerCanMoveHere(currentX-1, currentY)) {
			//Can move to this place
			this.setCurentPlayerPositionY(currentX-1);
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

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InteractionOnWorldMapHandler [curentPlayerPositionX=" + currentPlayerPositionX
				+ ", curentPlayerPositionY=" + currentPlayerPositionY + "]";
	}
}
