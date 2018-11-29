/**
 * 
 */
package gui;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.KeyStroke;

import core.VariableRepository;
import game.Movements;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class GUIGame extends JPanel {
	private static final long serialVersionUID = 1L;
	// private static GUIGame window = new GUIGame();
	private static Movements movement;
	private Painter graphicPainter;
	private Graphics2D graphicContext;

	private void setKeyBindings() {
		ActionMap actionMap = getActionMap();
		int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap inputMap = getInputMap(condition );
		
		char vkZ = 'z';
		char vkQ = 'q';
		char vkS = 's';
		char vkD = 'd';

		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 0), vkZ);
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), vkQ);
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), vkS);
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), vkD);

		actionMap.put(vkZ, new KeyAction(vkZ));
		actionMap.put(vkQ, new KeyAction(vkQ));
		actionMap.put(vkS, new KeyAction(vkS));
		actionMap.put(vkD, new KeyAction(vkD));

	}
	
	private class KeyAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public KeyAction(char vkZ) {
			putValue(ACTION_COMMAND_KEY, vkZ);
	    }
		
		@Override
		public void actionPerformed(ActionEvent actionEvt) {
			// System.out.println(actionEvt.getActionCommand() + " pressed");
			System.out.println(actionEvt.getActionCommand());
			char c = actionEvt.getActionCommand().charAt(0);
	        try {
				movement.movement(c);
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
	        
	        repaint();
	        
	        if ( ((boolean) VariableRepository.getInstance().searchByName("characterInFight")) == true) {
	        	JPanel parent = (JPanel)getParent();
	        	CardLayout layout = (CardLayout) parent.getLayout();
	        	layout.next(parent);
	        }
	        System.out.println("testRepaintAfter");
	        
		}
	}
	
	public GUIGame() {
		//listener = new CustomKeyListener();
	      this.setFocusable(true);
	      this.requestFocus();
	      // this.addKeyListener((KeyListener) listener);
	      setKeyBindings();
	      /*
		// this.setBounds(10, 11, 474, 428);
        this.setFocusable(true);
        // this.setRequestFocusEnabled(true);
        this.requestFocusInWindow();
        */
        try {
			initGameVariables();
		} catch (IOException e) {
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
		
	}
	
	public void paint(Graphics g) {
        super.paint(g);       
        Graphics2D g2 = (Graphics2D) g;
        this.graphicContext = g2;
        // g2.translate(0, GRPGParameters.STARTING_DRAW_ORIGIN);
        //g2.rotate(3.14);
        //graphicContext.setClip(-200,-200,3000,3000);
        // Draw Text
        graphicPainter.drawMap(g2);
        graphicPainter.drawPlayer(graphicContext);
        graphicPainter.drawDebugGrid(graphicContext,20,20, this);
        // g.translate(2,2);
    }

}
