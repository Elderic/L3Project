package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import game.Movements;
import game.PlayersCharacter;
import gui.GRPGParameters;

/* The painter class is needed for drawing all the graphics, such as the maps, characters skins, everything that involves graphic rendering.
 * 
 */
public class Painter extends JPanel {
	Graphics2D graphicContext;
	Movements movementHandler;
	
	final BufferedImage imageSolClassic;
	final BufferedImage imageMurClassic;
	final BufferedImage imageBuissonClassic;
	final BufferedImage imageBuisson2Classic;
	final BufferedImage imageEnemyBlob;
	
	JPanel gamePanel;
	
	public Painter(Movements movement) throws IOException {
		System.out.println("Working Directory = " +
	              System.getProperty("user.dir"));
		imageSolClassic = ImageIO.read(new File("L3_PROJET_RESEAU_BDD\\PNG\\rpgTile019.png"));
		imageMurClassic = ImageIO.read(new File("L3_PROJET_RESEAU_BDD\\PNG\\rpgTile076.png"));
		imageBuissonClassic = ImageIO.read(new File("L3_PROJET_RESEAU_BDD\\PNG\\rpgTile159.png"));
		imageBuisson2Classic = ImageIO.read(new File("L3_PROJET_RESEAU_BDD\\PNG\\rpgTile157.png"));
		imageEnemyBlob = ImageIO.read(new File("L3_PROJET_RESEAU_BDD\\ENEMIES\\MoldBrown.png"));
		
		this.movementHandler = movement;
	}
	
	public Dimension getPreferredSize() {
        return new Dimension(GRPGParameters.WINDOW_WIDTH,GRPGParameters.WINDOW_HEIGHT);
    }
	
	public void drawMap (Graphics2D g) {
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
						g.drawImage(imageSolClassic, xOffset, yOffset, null);
						break;
					case 'M':
						/*
						g.setColor(Color.RED);
						g.fillRect(xOffset,yOffset,GTParameters.SCALE,GTParameters.SCALE);
						g.setColor(Color.RED);
						g.drawRect(xOffset,yOffset,GTParameters.SCALE,GTParameters.SCALE);
						*/
						g.drawImage(imageSolClassic, xOffset, yOffset, null);
						g.drawImage(imageEnemyBlob, xOffset, yOffset, null);
						break;
					case '*':
						/*
						g.setColor(Color.GREEN);
						g.fillRect(xOffset,yOffset,GTParameters.SCALE,GTParameters.SCALE);
						g.setColor(Color.GREEN);
						g.drawRect(xOffset,yOffset,GTParameters.SCALE,GTParameters.SCALE);
						*/
						g.drawImage(imageSolClassic, xOffset, yOffset, null);
						int randomBush = (int) (Math.floor(Math.random() * 2) + 1);  
						if (randomBush == 1) {
							g.drawImage(imageBuissonClassic, xOffset, yOffset, null);
						} else {
							g.drawImage(imageBuisson2Classic, xOffset, yOffset, null);
						}
						break;
					case '/':
						/*
						g.setColor(Color.GRAY);
						g.fillRect(xOffset,yOffset,GTParameters.SCALE,GTParameters.SCALE);
						g.setColor(Color.GRAY);
						g.drawRect(xOffset,yOffset,GTParameters.SCALE,GTParameters.SCALE);
						*/
						g.drawImage(imageMurClassic, xOffset, yOffset, null);
						break;
					default:
						break;
    			}
    			
    			// repaint();
    		}
    	}
    }
	
	public void drawDebugGrid(Graphics g, int mapWidth, int mapHeight) {
		int width = mapWidth;
		int height = mapHeight;
		g.setColor(Color.GRAY);

		for (int i = GRPGParameters.SCALE; i <= width; i += GRPGParameters.SCALE) {
			g.drawLine(i, 1, i, height);
		}

		for (int i = GRPGParameters.SCALE; i <= height; i += GRPGParameters.SCALE) {
			g.drawLine(1, i, width, i);
		}
	}
	
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
    */
	/*
	public void movePlayer(KeyEvent e) {
        
        this.movementHandler.movement(e.getKeyChar());
        
        repaint();
    }
    */
}
