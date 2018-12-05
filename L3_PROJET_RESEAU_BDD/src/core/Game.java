package core;

import java.awt.EventQueue;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

/**
 * @author 
 *
 */
public class Game {
	private JFrame frame;

	
	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public Game() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	// Juste une d�mo, ne surtout pas faire du code comme celui d'en-dessous
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 847, 498);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel cardsContainer = new JPanel(new CardLayout());
		frame.getContentPane().add(cardsContainer, "cardsContainer");
		
		JButton btnTest = new JButton("TEST");
		
		JPanel panel1 = new JPanel();
		
		JLabel labelPanel1 = new JLabel("PANEL 1");
		panel1.add(labelPanel1);
		panel1.add(btnTest);
		cardsContainer.add(panel1, "panel_1");
		
		JPanel panel2 = new JPanel();
		cardsContainer.add(panel2, "panel_2");
		
		JLabel lblPanel = new JLabel("PANEL 2");
		panel2.add(lblPanel);
		
		/*btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((CardLayout) cardsContainer.getLayout()).next(cardsContainer);
			}
		});*/
	}

}
