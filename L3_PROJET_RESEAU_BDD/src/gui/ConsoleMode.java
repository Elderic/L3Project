/**
 * 
 */
package gui;

import java.util.Scanner;

import game.*;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class ConsoleMode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	//MAP
			int width = 20;
			int height = 10;
			int monsterPercentage = 50;
			int obstaclePercentage = 20;
		
		Map map = new Map(height, width, monsterPercentage, obstaclePercentage);
		
		while(true) {
			map.printMap();
			System.out.println("Appuyez sur z, q, s, d (puis entrer) pour vous déplacer");
			
			Scanner read = new Scanner(System.in);
			String content = read.nextLine();
			if(content.length()==1) {
				char letter = content.charAt(0);
				/*
				Movements m = new Movements();
				m.movement(letter);
				*/
			}
			else {
				System.out.println("Erreur : Vous avez entré trop de caractères !");
			}
			
		}
		

		
	//FIGHT
		
		//Fight f = new Fight();
	}

}
