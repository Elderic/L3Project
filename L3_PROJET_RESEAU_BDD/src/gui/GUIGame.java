/**
 * 
 */
package gui;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import game.Map;
import game.Movements;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class GUIGame extends JFrame{
	private static final long serialVersionUID = 1L;
	private static GUIGame window = new GUIGame();
	private static Movements movement;
	private Painter graphicPainter;
	private Graphics2D graphicContext;
	
	public GUIGame() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				movePlayer(arg0);
			}
		});
		setSize(new Dimension(1050, 900));
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mnNewMenu.add(mntmQuitter);
		
		JMenu mnMultijoueurs = new JMenu("Multi-joueurs");
		menuBar.add(mnMultijoueurs);
		
		JMenuItem mntmCombatreUnAutre = new JMenuItem("Combatre un autre joueur");
		mnMultijoueurs.add(mntmCombatreUnAutre);
		getContentPane().setLayout(null);
		
		JPanel panelMap = new JPanel();
		panelMap.setBounds(10, 11, 474, 428);
		getContentPane().add(panelMap);
		
		// panelMap.setBorder(BorderFactory.createLineBorder(Color.black));
        setFocusable(true);
        // this.player = new PlayersCharacter();
        
		try {
			initGameVariables();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void initGameVariables() throws IOException {
		int width = 20;
		int height = 10;
		int monsterPercentage = 10;
		int obstaclePercentage = 20;
		int playerXCords = 5;
		int playerYCords = 5;
	
		movement = new Movements(height, width, monsterPercentage, obstaclePercentage,playerXCords,playerYCords);
		graphicPainter = new Painter(movement);
		// graphicPainter.drawDebugGrid(g, 20, 20);
		
	}
	
	public void paint(Graphics g) {
        super.paint(g);       
        Graphics2D g2 = (Graphics2D) g;
        this.graphicContext = g2;
        //g2.rotate(3.14);
        //graphicContext.setClip(-200,-200,3000,3000);
        // Draw Text
        graphicPainter.drawMap(g2);
        graphicPainter.drawPlayer(graphicContext);
        graphicPainter.drawDebugGrid(graphicContext,20,20);
        // g.translate(2,2);
    }
	
	 public void movePlayer(KeyEvent e) {
	        
        movement.movement(e.getKeyChar());
        
        repaint();
	 }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		window.setVisible(true);
		window.setTitle("RPG");
	}
}
