/**
 * 
 */
package game;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class Map {
	private int height; // |
	private int width; // --
	private char[][] map;
	private char defaultCharInMap = '-';
	private char borderCharInMap = '&';
	
	private int monsterPercentage;
	private int obstaclePercentage;
	
	
	/**
	 * 
	 * @param height
	 * @param width
	 * @param monsterPercentage
	 * @param obstaclePercentage
	 */
	public Map(int height, int width, int monsterPercentage, int obstaclePercentage){
		setMonsterPercentage(monsterPercentage);
		setObstaclePercentage(obstaclePercentage);
		
		setHeight(height);
		setWidth(width);
		this.map = new char[width][height];
		
		for(int i=0 ; i<height ; i++) {
			for(int j=0 ; j<width ; j++) {
				if(i==0 || i==height-1 || j==0 || j==width-1) {
					setPositionInMap(i, j, borderCharInMap);
				}
				else {
					setPositionInMap(i, j, defaultCharInMap);
				}
			}
		}
		
		this.generateRandomMap();
	}
	
	/**
	 * 
	 * @param positionX (--)
	 * @param positionY (|)
	 * @param character
	 */
	public void setPositionInMap(int positionX, int positionY, char character) {
		this.map[positionY][positionX]=character;
	}
	
	public char getPositionInMap(int positionX, int positionY) {
		return map[positionY][positionX];
	}
	
	public void printMap() {
		System.out.print("\nMAP:\n");
		for(int i=-1 ; i<getHeight() ; i++) {
			for(int j=-1 ; j<getWidth() ; j++) {
				if(i==-1) {
					//LINE
					int tmp = j;
					if(tmp!=-1) {
						System.out.print("|\t" + tmp);
					}
				}
				else if(j==-1) {
					//COLUMN
					int tmp = i;
					System.out.print(tmp);
				}
				else {
					System.out.print(" |\t" + getPositionInMap(i, j));
				}
			}
			System.out.print(" |\n");
		}
	}

	/*
	 * WALL = /
	 * STONE / TREE = *
	 * MONSTER = M
	 */
	private void generateRandomMap() {
		for(int i=1 ; i<getHeight()-1 ; i++) {
			for(int j=1 ; j<getWidth()-1 ; j++) {
				int randomMonster = (int) (Math.random()*100);
				int randomObstacle = (int) (Math.random()*100);
				
				if(randomMonster<=getMonsterPercentage()) {
					setPositionInMap(i, j, 'M');
				}
				else if(randomObstacle<=getObstaclePercentage()) {
					char characterToSet;
					if(j%2==0) {
						characterToSet = '*';
					}
					else {
						characterToSet = '/';
					}
					setPositionInMap(i, j, characterToSet);
				}
			}
		}
	}
	
	
	public boolean playerCanMoveHere(int positionX, int positionY) {
		if(getPositionInMap(positionX, positionY) != '&' && getPositionInMap(positionX, positionY) != '/' && getPositionInMap(positionX, positionY) != '*') {
			return true;
		}
		return false;
	}

	
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return the monsterPercentage
	 */
	public int getMonsterPercentage() {
		return monsterPercentage;
	}
	
	/**
	 * 
	 * @return the obstaclePercentage
	 */
	public int getObstaclePercentage() {
		return obstaclePercentage;
	}

	/**
	 * @param height the height to set
	 */
	private void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * @param width the width to set
	 */
	private void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * @param monsterPercentage the monsterPercentage to set
	 */
	public void setMonsterPercentage(int monsterPercentage) {
		this.monsterPercentage = monsterPercentage;
	}
	
	/**
	 * 
	 * @param obstaclePercentage the obstaclePercentage to set
	 */
	public void setObstaclePercentage(int obstaclePercentage) {
		this.obstaclePercentage = obstaclePercentage;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Map [height=" + height + ", width=" + width + "]";
	}
}
