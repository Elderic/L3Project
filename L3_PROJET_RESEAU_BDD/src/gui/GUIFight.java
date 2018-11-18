package gui;
import gui.GRPGParameters;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import core.VariableRepository;
import game.Fight;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JTextArea;

import game.PlayersCharacter;
import game.EnemyCharacter;

//import query.FightQuery;


public class GUIFight extends JPanel {

	/*	progressBar.setValue( ( int ) playerToUpdate.getPlayerMana() );
		progressBar.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent arg0) {
			labelProgressBarValue.setText(Integer.valueOf(progressBar.getValue()).toString());
		}
});
*/
	
	private static final long serialVersionUID = 1L;
	private JLabel labelConnexionTitle;	

	private JButton buttonAttack;
	private JButton buttonDefense;
	private JButton buttonObject;
	private JButton buttonGiveUp;
	private JButton buttonPrevious;
	
	private JProgressBar healthBarPlayer;
	private JProgressBar healthBarOpponent;
	
	private JLabel labelHealthBarPlayer;
	private JLabel labelHealthBarOpponent;
	
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public GUIFight() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				Fight fight = new Fight();
				VariableRepository.getInstance().register("fightManager", fight);;
				fight.initFight(textArea);
				
				GUIDisplayHandler.updateProgressBarValue(healthBarPlayer, ((PlayersCharacter)VariableRepository.getInstance().searchByName("player1")).getHealth() );
				GUIDisplayHandler.updateProgressBarValue(healthBarOpponent, ((EnemyCharacter)VariableRepository.getInstance().searchByName("enemy_1")).getHealth() );
				
				GUIDisplayHandler.updateLabel(labelHealthBarPlayer, ( String.valueOf( ((PlayersCharacter)VariableRepository.getInstance().searchByName("player1")).getHealth() ) ) );
				GUIDisplayHandler.updateLabel(labelHealthBarPlayer, ( String.valueOf( ((EnemyCharacter)VariableRepository.getInstance().searchByName("enemy_1")).getHealth() ) ) );
				/*
				while ( ((Boolean) VariableRepository.getInstance().searchByName("characterInFight") ) == true ) {
					
				}
				*/
			}
		});
		
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		int windowWidth = GRPGParameters.WINDOW_WIDTH;
		if (windowWidth < 1024 || (windowWidth % 1024 != 0)) {
			throw new IllegalArgumentException("Non supported window size : " + windowWidth);
		}
		setPreferredSize(new Dimension(1024, 769));
		initLayout();
		initActions();	
	}
	
	public void checkEndFight() {
		
		if ( ((Boolean)VariableRepository.getInstance().searchByName("characterInFight")) == false ) {
			VariableRepository.getInstance().removeByName("enemy_1");
			JPanel parent = (JPanel)getParent();
        	CardLayout layout = (CardLayout) parent.getLayout();
        	layout.previous(parent);
		}
	}
	
	protected void initActions() {
		buttonAttack.addActionListener(new AttackAction());
		buttonDefense.addActionListener(new DefenseAction());
		buttonObject.addActionListener(new ObjectAction());
		buttonGiveUp.addActionListener(new GiveUpAction());
		// buttonPrevious.addActionListener(new PreviousAction());
	}
	/*
	private class PreviousAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			PanelsContainer.getInstance().getCardLayout().previous(PanelsContainer.getInstance());
		}
	}
	*/
	private class AttackAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			// System.out.println("Attack");
			((Fight) VariableRepository.getInstance().searchByName("fightManager")).inFight("a", textArea);
			
			GUIDisplayHandler.updateProgressBarValue(healthBarPlayer, ((PlayersCharacter)VariableRepository.getInstance().searchByName("player1")).getHealth() );
			GUIDisplayHandler.updateProgressBarValue(healthBarOpponent, ((EnemyCharacter)VariableRepository.getInstance().searchByName("enemy_1")).getHealth() );
			
			GUIDisplayHandler.updateLabel(labelHealthBarPlayer, ( String.valueOf( ((PlayersCharacter)VariableRepository.getInstance().searchByName("player1")).getHealth() ) ) );
			GUIDisplayHandler.updateLabel(labelHealthBarPlayer, ( String.valueOf( ((EnemyCharacter)VariableRepository.getInstance().searchByName("enemy_1")).getHealth() ) ) );
			
			checkEndFight();
			/*
			try {
				boolean testFightQuery=FightQuery.FightQuery("fightSolo");
				System.out.println("query ="+testFightQuery);
				System.out.println(GameVariableRepository.getInstance().getPlayerName());
			} catch (IOException | InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			*/
		}
	}
	private class DefenseAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			// System.out.println("Defense");
			((Fight) VariableRepository.getInstance().searchByName("fightManager")).inFight("d", textArea);
			
			GUIDisplayHandler.updateProgressBarValue(healthBarPlayer, ((PlayersCharacter)VariableRepository.getInstance().searchByName("player1")).getHealth() );
			GUIDisplayHandler.updateProgressBarValue(healthBarOpponent, ((EnemyCharacter)VariableRepository.getInstance().searchByName("enemy_1")).getHealth() );
			
			GUIDisplayHandler.updateLabel(labelHealthBarPlayer, ( String.valueOf( ((PlayersCharacter)VariableRepository.getInstance().searchByName("player1")).getHealth() ) ) );
			GUIDisplayHandler.updateLabel(labelHealthBarPlayer, ( String.valueOf( ((EnemyCharacter)VariableRepository.getInstance().searchByName("enemy_1")).getHealth() ) ) );
			
			checkEndFight();
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
		labelHealthBarPlayer.setBounds(962, 375, 39, 28);
		labelHealthBarPlayer.setComponentOrientation(getComponentOrientation());
		add(labelHealthBarPlayer);
		
		healthBarPlayer = new JProgressBar(SwingConstants.VERTICAL);
		labelHealthBarPlayer.setLabelFor(healthBarPlayer);
		healthBarPlayer.setForeground(new Color(0, 153, 255));
		healthBarPlayer.setBackground(Color.LIGHT_GRAY);
		healthBarPlayer.setBounds(962, 375, 36, 200);
		add(healthBarPlayer);
		
		labelHealthBarOpponent = new JLabel("0");
		labelHealthBarOpponent.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelHealthBarOpponent.setBounds(23, 375, 39, 28);
		labelHealthBarOpponent.setComponentOrientation(getComponentOrientation());
		add(labelHealthBarOpponent);
		
		healthBarOpponent = new JProgressBar(SwingConstants.VERTICAL);
		labelHealthBarOpponent.setLabelFor(healthBarOpponent);
		healthBarOpponent.setForeground(new Color(0, 153, 255));
		healthBarOpponent.setBackground(Color.LIGHT_GRAY);
		healthBarOpponent.setBounds(23, 375, 36, 200);
		add(healthBarOpponent);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(23, 604, 975, 154);
		add(textArea);
		
	}
	
	public void paint(Graphics g) {
        super.paint(g);       
        Graphics2D g2 = (Graphics2D) g;
        Painter.drawBattleBackground(g2);
    }
}