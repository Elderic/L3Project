package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author 
 *
 */
public class GUIMainScreen extends JPanel {
	private static final long serialVersionUID = 7064806528132220998L;
	
	private JLabel lblRpg;
	private JButton signIn;
	private JButton signUp;
	private JButton fight;
	private JButton leaveButton;
	private JButton charact;

	boolean fightQuery = false;
	
	
	/**
	 * 
	 * 
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 * @throws LineUnavailableException
	 */
	public GUIMainScreen () throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		int windowWidth = GRPGParameters.WINDOW_WIDTH;
		if (windowWidth < 1024 || (windowWidth % 1024 != 0)) {
			throw new IllegalArgumentException("Non supported window size : " + windowWidth);
		}
		
		setPreferredSize(new Dimension(windowWidth, GRPGParameters.WINDOW_HEIGHT));
		setBackground(Color.LIGHT_GRAY.darker());
				
		this.initLayout();		
		this.initActions();
	}
	
	
	/**
	 * 
	 */
	protected void initActions() {
		signIn.addActionListener(new SignInAction());
		signUp.addActionListener(new SignUpAction());
		leaveButton.addActionListener(new LeaveButtonAction() );
		fight.addActionListener(new FightAction() );
		charact.addActionListener(new CharactAction() );
	}
	
	
	/**
	 *
	 */
	private class SignInAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			PanelsContainer.getInstance().getCardLayout().next(PanelsContainer.getInstance());
		}
	}
	
	
	/**
	 *
	 */
	private class SignUpAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			PanelsContainer.getInstance().getCardLayout().next(PanelsContainer.getInstance());
			PanelsContainer.getInstance().getCardLayout().next(PanelsContainer.getInstance());
		}
	}
	
	
	/**
	 * 
	 */
	private class FightAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
					
				PanelsContainer.getInstance().getCardLayout().next(PanelsContainer.getInstance());
				PanelsContainer.getInstance().getCardLayout().next(PanelsContainer.getInstance());
				PanelsContainer.getInstance().getCardLayout().next(PanelsContainer.getInstance());
				PanelsContainer.getInstance().getCardLayout().next(PanelsContainer.getInstance());	
		}
	}
	
	
	/**
	 * 
	 */
	private class CharactAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
					
				PanelsContainer.getInstance().getCardLayout().next(PanelsContainer.getInstance());
				PanelsContainer.getInstance().getCardLayout().next(PanelsContainer.getInstance());
				PanelsContainer.getInstance().getCardLayout().next(PanelsContainer.getInstance());
		}
	}
	
	
	/**
	 * 
	 */
	private class LeaveButtonAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	
	/**
	 * 
	 * 
	 * @throws IOException
	 */
	public void initLayout () throws IOException {
		setLayout(null);
		
		lblRpg = new JLabel("RPG");
		lblRpg.setBounds(417, 0, 254, 87);
		add(lblRpg);
		lblRpg.setFont(new Font("Tahoma", Font.PLAIN, 72));
		
		signIn = new JButton("Sign in");
		signIn.setBounds(445, 116, 192, 50);
		add(signIn);
		
		signUp = new JButton("Sign up");
		signUp.setBounds(445, 189, 192, 50);
		add(signUp);
		
		leaveButton = new JButton("Quit");
		leaveButton.setBounds(445, 268, 192, 50);
		add(leaveButton);
		
		fight = new JButton("temp fight panel");
		fight.setBounds(445, 340, 192, 50);
		add(fight);
		
		charact = new JButton("temp char crea panel");
		charact.setBounds(445, 440, 192, 50);
		add(charact);
	}
}