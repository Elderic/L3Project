/**
 * 
 */
package gui;

import game.Map;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class ConsoleMode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			int width = 20;
			int height = 10;
		
		Map map = new Map(height, width);
		map.printMap();

	}

}
