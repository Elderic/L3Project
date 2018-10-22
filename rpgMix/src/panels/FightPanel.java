package panels;
import gui.GTParameters;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import core.GameVariableRepository;

import query.FightQuery;


public class FightPanel extends JPanel {

	/*	progressBar.setValue( ( int ) playerToUpdate.getPlayerMana() );
		progressBar.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent arg0) {
			labelProgressBarValue.setText(Integer.valueOf(progressBar.getValue()).toString());
		}
});
*/
	
	private static final long serialVersionUID = 1L;
	private JLabel labelConnexionTitle;	
	private JLabel loginLabel;
	private JLabel passwordLabel;
	private JLabel errorEmptyField;
	private JLabel connectionImpossibleField;

	private JButton buttonAttack;
	private JButton buttonDefense;
	private JButton buttonObject;
	private JButton buttonGiveUp;
	private JButton buttonPrevious;
	
	private JProgressBar healthBarPlayer;
	private JProgressBar healthBarOpponent;
	
	private JLabel labelHealthBarPlayer;
	private JLabel labelHealthBarOpponent;

	/**
	 * Create the panel.
	 */
	public FightPanel() {
		setBackground(Color.LIGHT_GRAY.darker());
		setLayout(null);
		
		int windowWidth = GTParameters.WINDOW_WIDTH;
		if (windowWidth < 1024 || (windowWidth % 1024 != 0)) {
			throw new IllegalArgumentException("Non supported window size : " + windowWidth);
		}
		setPreferredSize(new Dimension(1024, 769));
		initLayout();
		initActions();	
	}
	
	protected void initActions() {
		buttonAttack.addActionListener(new AttackAction());
		buttonDefense.addActionListener(new DefenseAction());
		buttonObject.addActionListener(new ObjectAction());
		buttonGiveUp.addActionListener(new GiveUpAction());
		buttonPrevious.addActionListener(new PreviousAction());
	}

	private class PreviousAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			PanelsContainer.getInstance().getCardLayout().previous(PanelsContainer.getInstance());
		}
	}

	private class AttackAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			try {
				boolean testFightQuery=FightQuery.FightQuery("fightSolo");
				System.out.println("query ="+testFightQuery);
				System.out.println(GameVariableRepository.getInstance().getPlayerName());
			} catch (IOException | InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class DefenseAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	private class ObjectAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {

		}
	}
	private class GiveUpAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			//revenir sur l'écran de deplacement(map)
			//requete bd pour defaite +1
		}
	}
	
		
	public void initLayout () {
		labelConnexionTitle = new JLabel("fight");
		labelConnexionTitle.setFont(new Font("Tahoma", Font.PLAIN, 38));
		labelConnexionTitle.setBounds(400, 22, 335, 76);
		add(labelConnexionTitle);
	

		buttonAttack = new JButton("Attack");
		buttonAttack.setBounds(400, 300, 114, 35);
		add(buttonAttack);
		
		buttonDefense = new JButton("Defense");
		buttonDefense.setBounds(514, 300, 114, 35);
		add(buttonDefense);
		
		buttonObject = new JButton("Object");
		buttonObject.setBounds(400, 335, 114, 35);
		add(buttonObject);
		
		buttonGiveUp = new JButton("Give Up");
		buttonGiveUp.setBounds(514, 335, 114, 35);
		add(buttonGiveUp);
		
		buttonPrevious = new JButton("Previous");
		buttonPrevious.setBounds(514, 522, 114, 35);
		add(buttonPrevious);
		
		labelHealthBarPlayer = new JLabel("0");
		labelHealthBarPlayer.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelHealthBarPlayer.setBounds(938, 292, 39, 28);
		labelHealthBarPlayer.setComponentOrientation(getComponentOrientation());
		add(labelHealthBarPlayer);
		
		healthBarPlayer = new JProgressBar(SwingConstants.HORIZONTAL);
		labelHealthBarPlayer.setLabelFor(healthBarPlayer);
		healthBarPlayer.setForeground(new Color(0, 153, 255));
		healthBarPlayer.setBackground(Color.LIGHT_GRAY);
		healthBarPlayer.setBounds(928, 292, 36, 200);
		add(healthBarPlayer);
		
		labelHealthBarOpponent = new JLabel("0");
		labelHealthBarOpponent.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelHealthBarOpponent.setBounds(200, 292, 39, 28);
		labelHealthBarOpponent.setComponentOrientation(getComponentOrientation());
		add(labelHealthBarOpponent);
		
		healthBarOpponent = new JProgressBar(SwingConstants.HORIZONTAL);
		labelHealthBarOpponent.setLabelFor(healthBarOpponent);
		healthBarOpponent.setForeground(new Color(0, 153, 255));
		healthBarOpponent.setBackground(Color.LIGHT_GRAY);
		healthBarOpponent.setBounds(200, 292, 36, 200);
		add(healthBarOpponent);
		
	}
}