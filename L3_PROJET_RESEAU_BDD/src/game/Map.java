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
	
	
	/**
	 * @param height the height to set
	 * @param width the width to set
	 * */
	public Map(int height, int width){
		this.setHeight(height);
		this.setWidth(width);
		this.map = new char[width][height];
		
		for(int i=0 ; i<height ; i++) {
			for(int j=0 ; j<width ; j++) {
				setMap(i, j, defaultCharInMap);
				//Ajouter if pour les bordures > &
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
	public void setMap(int positionX, int positionY, char character) {
		this.map[positionY][positionX]=character;
	}
	
	public char getMap(int positionX, int positionY) {
		return map[positionY][positionX];
	}
	
	public void printMap() {
		System.out.print("\nMAP:\n");
		for(int i=0 ; i<this.height ; i++) {
			for(int j=0 ; j<this.width ; j++) {
				System.out.print(" | " + getMap(i, j));
			}
			System.out.print(" |\n");
		}
	}

	/*
	 * WALL = /
	 * STONE / TREE = *
	 */
	private void generateRandomMap() {
		
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
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Map [height=" + height + ", width=" + width + "]";
	}
}
