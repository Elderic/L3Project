package gui;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import game.Movements;
import gui.GRPGParameters;

/**
 * @author 
 *
 * The painter class is needed for drawing all the graphics, 
 * such as the maps, characters skins, everything that involves graphic rendering.
 */
public class Painter extends JPanel {
	private static final long serialVersionUID = 1L;
	
	Graphics2D graphicContext;
	Movements movementHandler;
	
	final BufferedImage imageSolClassic;
	final BufferedImage imageMurClassic;
	final BufferedImage imageBuissonClassic;
	final BufferedImage imageBuisson2Classic;
	final BufferedImage imageEnemyBlob;
	
	static BufferedImage imageBattleBackground;
	
	JPanel gamePanel;
	
	
	/**
	 * The constructor initialize all the images necessary to draw all cells on the map of the game.
	 * 
	 * @param movement Needed to get access to the map contained in the Movements Instance.
	 * 
	 * @throws IOException
	 */
	public Painter(Movements movement) throws IOException {
		System.out.println("Working Directory = " +
	              System.getProperty("user.dir"));
		
		// System.out.println(new File("t").getCanonicalPath());
		imageSolClassic = ImageIO.read(new File("PNG/rpgTile019.png"));
		imageMurClassic = ImageIO.read(new File("PNG/rpgTile076.png"));
		imageBuissonClassic = ImageIO.read(new File("PNG/rpgTile159.png"));
		imageBuisson2Classic = ImageIO.read(new File("PNG/rpgTile157.png"));
		imageEnemyBlob = ImageIO.read(new File("ENEMIES/MoldBrown.png"));
		
		imageBattleBackground = ImageIO.read(new File("PNG/battle_background.png"));
		/*
		imageSolClassic = ImageIO.read(new File("L3_PROJET_RESEAU_BDD\\PNG\\rpgTile019.png"));
		imageMurClassic = ImageIO.read(new File("L3_PROJET_RESEAU_BDD\\PNG\\rpgTile076.png"));
		imageBuissonClassic = ImageIO.read(new File("L3_PROJET_RESEAU_BDD\\PNG\\rpgTile159.png"));
		imageBuisson2Classic = ImageIO.read(new File("L3_PROJET_RESEAU_BDD\\PNG\\rpgTile157.png"));
		imageEnemyBlob = ImageIO.read(new File("L3_PROJET_RESEAU_BDD\\ENEMIES\\MoldBrown.png"));
		*/
		this.movementHandler = movement;
	}
	
	
	/**
	 * Get the preferredSize for the window
	 * 
	 * @return preferredSize
	 */
	public Dimension getPreferredSize() {
        return new Dimension(GRPGParameters.WINDOW_WIDTH,GRPGParameters.WINDOW_HEIGHT);
    }
	
	
	/**
	 * This method is called when we need to draw the background of the Panel during a fight.
	 * 
	 * @param g
	 */
	public static void drawBattleBackground(Graphics2D g) {
		g.drawImage(imageBattleBackground, 0, 0,GRPGParameters.WINDOW_WIDTH,GRPGParameters.WINDOW_HEIGHT, null);
	}
	
	/**
	 * When this method is called, the map is iterated so as to draw every cell present in the array, according to its content.
	 * 
	 * @param g Needed so we can draw in the right context.
	 */
	public void drawMap(Graphics2D g) {
    	for (int j = 0; j < this.movementHandler.getMap().getHeight(); j++) {
    		for (int i = 0; i < this.movementHandler.getMap().getWidth(); i++) {
    			int xOffset = j*GRPGParameters.SCALE;
    			int yOffset = i*GRPGParameters.SCALE;
    			char toAccess = this.movementHandler.getMap().getPositionInMap(j, i);
    			switch ( toAccess ) {
					case '&':
						g.setColor(Color.BLACK);
						g.fillRect(xOffset,yOffset,GRPGParameters.SCALE,GRPGParameters.SCALE);
						g.setColor(Color.BLACK);
						g.drawRect(xOffset,yOffset,GRPGParameters.SCALE,GRPGParameters.SCALE);
						break;
					case '-':
						/*
						g.setColor(Color.WHITE);
						g.fillRect(xOffset,yOffset,GTParameters.SCALE,GTParameters.SCALE);
						g.setColor(Color.WHITE);
						g.drawRect(xOffset,yOffset,GTParameters.SCALE,GTParameters.SCALE);
						*/
						// g.drawImage(image, xOffset, yOffset, dx2, dy2, sx1, sy1, sx2, sy2, observer)
						g.drawImage(imageSolClassic, xOffset, yOffset,GRPGParameters.SCALE,GRPGParameters.SCALE, null);
						break;
					case 'M':
						/*
						g.setColor(Color.RED);
						g.fillRect(xOffset,yOffset,GTParameters.SCALE,GTParameters.SCALE);
						g.setColor(Color.RED);
						g.drawRect(xOffset,yOffset,GTParameters.SCALE,GTParameters.SCALE);
						*/
						g.drawImage(imageSolClassic, xOffset, yOffset,GRPGParameters.SCALE,GRPGParameters.SCALE, null);
						g.drawImage(imageEnemyBlob, xOffset, yOffset,GRPGParameters.SCALE,GRPGParameters.SCALE, null);
						break;
					case '*':
						/*
						g.setColor(Color.GREEN);
						g.fillRect(xOffset,yOffset,GTParameters.SCALE,GTParameters.SCALE);
						g.setColor(Color.GREEN);
						g.drawRect(xOffset,yOffset,GTParameters.SCALE,GTParameters.SCALE);
						*/
						g.drawImage(imageSolClassic, xOffset, yOffset, null);
						// int randomBush = (int) (Math.floor(Math.random() * 2) + 1);  
						g.drawImage(imageBuissonClassic, xOffset, yOffset,GRPGParameters.SCALE,GRPGParameters.SCALE, null);
						/*
						if (randomBush == 1) {
							g.drawImage(imageBuissonClassic, xOffset, yOffset,GRPGParameters.SCALE,GRPGParameters.SCALE, null);
						} else {
							g.drawImage(imageBuisson2Classic, xOffset, yOffset,GRPGParameters.SCALE,GRPGParameters.SCALE, null);
						}
						*/
						break;
					case '/':
						/*
						g.setColor(Color.GRAY);
						g.fillRect(xOffset,yOffset,GTParameters.SCALE,GTParameters.SCALE);
						g.setColor(Color.GRAY);
						g.drawRect(xOffset,yOffset,GTParameters.SCALE,GTParameters.SCALE);
						*/
						g.drawImage(imageMurClassic, xOffset, yOffset,GRPGParameters.SCALE,GRPGParameters.SCALE, null);
						break;
					default:
						break;
    			}
    			
    			// repaint();
    		}
    	}
    }
	
	/**
	 * A function that is useful to see the actual size of each cells.
	 * 
	 * @param g Needed to draw on the right context.
	 * @param mapWidth
	 * @param mapHeight
	 * @param component
	 */
	public void drawDebugGrid(Graphics g, int mapWidth, int mapHeight, Component component) {
		int width = component.getWidth();//mapWidth;
		int height = component.getHeight();//mapHeight;
		g.setColor(Color.GRAY);

		for (int i = GRPGParameters.SCALE; i <= width; i += GRPGParameters.SCALE) {
			g.drawLine(i, 1, i, height);
		}

		for (int i = GRPGParameters.SCALE; i <= height; i += GRPGParameters.SCALE) {
			g.drawLine(1, i, width, i);
		}
	}
	
	/**
	 * This function is currently drawing a blue square in place the player's character.
	 * 
	 * @param g Needed to draw in the right context
	 */
	public void drawPlayer(Graphics g) {
    	/*
		g.setColor(Color.BLUE);
		g.fillRect(playerToDraw.getX(),playerToDraw.getY(),GTParameters.SCALE,GTParameters.SCALE);
		g.setColor(Color.BLACK);
		g.drawRect(playerToDraw.getX(),playerToDraw.getY(),GTParameters.SCALE,GTParameters.SCALE);
    	*/
    	int xToDraw = movementHandler.getCurrentPlayerPositionX();
    	int yToDraw = movementHandler.getCurrentPlayerPositionY();
    	g.setColor(Color.BLUE);
		g.fillRect(xToDraw*GRPGParameters.SCALE,yToDraw*GRPGParameters.SCALE,GRPGParameters.SCALE,GRPGParameters.SCALE);
		g.setColor(Color.BLACK);
		g.drawRect(xToDraw*GRPGParameters.SCALE,yToDraw*GRPGParameters.SCALE,GRPGParameters.SCALE,GRPGParameters.SCALE);
    }
	
	/*
	public void paint(Graphics g) {
        super.paint(g);       
        Graphics2D g2 = (Graphics2D) g;
        this.graphicContext = g2;
        //g2.rotate(3.14);
        //graphicContext.setClip(-200,-200,3000,3000);
        // Draw Text
        graphicContext.drawString("This is my custom Panel!",10,20);
        this.drawMap(g2);
        // this.drawPlayer(this.player, graphicContext);
        drawDebugGrid(graphicContext,20,20);
        // g.translate(2,2);
    }
    
	public void movePlayer(KeyEvent e) {
        this.movementHandler.movement(e.getKeyChar());
        
        repaint();
    }
    */
}
