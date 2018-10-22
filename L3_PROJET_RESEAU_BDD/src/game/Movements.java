/**
 * 
 */
package game;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class Movements {
	private int currentPlayerPositionX; //width
	private int currentPlayerPositionY; //height
	private int monsterPercentage;
	
	
	public Movements(int monsterPercentage) {
		this.setMonsterPercentage(monsterPercentage);
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
		}
		int random = (int) (Math.random()*100);
		boolean isThereMonster = false;
		if(random<=monsterPercentage) {
			isThereMonster = true;
		}
		
		if(isThereMonster) {
			//LET'S FIGHT!
		}
	}
	
	private void moveUp() {
		int current = this.getCurentPlayerPositionY();
		this.setCurentPlayerPositionY(current+1);
	}
	
	private void moveDown() {
		int current = this.getCurentPlayerPositionY();
		this.setCurentPlayerPositionY(current-1);
	}
	
	private void moveRight() {
		int current = this.getCurentPlayerPositionX();
		this.setCurentPlayerPositionX(current+1);
	}
	
	private void moveLeft() {
		int current = this.getCurentPlayerPositionX();
		this.setCurentPlayerPositionX(current-1);
	}
	
	
	/**
	 * @return the curentPlayerPositionX
	 */
	public int getCurentPlayerPositionX() {
		return currentPlayerPositionX;
	}
	
	/**
	 * @return the curentPlayerPositionY
	 */
	public int getCurentPlayerPositionY() {
		return currentPlayerPositionY;
	}
	
	/**
	 * @return the monsterPercentage
	 */
	public int getMonsterPercentage() {
		return monsterPercentage;
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
	 * @param monsterPercentage the monsterPercentage to set
	 */
	public void setMonsterPercentage(int monsterPercentage) {
		this.monsterPercentage = monsterPercentage;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InteractionOnWorldMapHandler [curentPlayerPositionX=" + currentPlayerPositionX
				+ ", curentPlayerPositionY=" + currentPlayerPositionY + ", monsterPercentage=" + monsterPercentage + "]";
	}
}
