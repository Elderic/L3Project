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
	
	
	/**
	 * @param height the height to set
	 * @param width the width to set
	 * */
	public Map(int height, int width){
		this.setHeight(height);
		this.setWidth(width);
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
