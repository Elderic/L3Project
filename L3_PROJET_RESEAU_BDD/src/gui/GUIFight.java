package gui;

import gui.GRPGParameters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import core.VariableRepository;
import game.Fight;
import game.PlayersCharacter;
import game.EnemyCharacter;
//import query.FightQuery;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class GUIFight extends JPanel implements ComponentListener {
	private static final long serialVersionUID = 1L;
	
	private JLabel labelConnexionTitle;	
	private JLabel labelHealthBarPlayer;
	private JLabel labelHealthBarOpponent;
	
	private JButton buttonAttack;
	private JButton buttonDefense;
	
	private JProgressBar healthBarPlayer;
	private JProgressBar healthBarOpponent;
	
	private JTextArea textArea;
	private JScrollPane scrollPane;
	
	/*	
	progressBar.setValue( ( int ) playerToUpdate.getPlayerMana() );
	 
	progressBar.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent arg0) {
			labelProgressBarValue.setText(Integer.valueOf(progressBar.getValue()).toString());
		}
	});
	 */
	

	/**
	 * Create the panel.
	 */
	public GUIFight() {
		this.addComponentListener((ComponentListener) this);
		/*
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
				
			}
		});
		*/
		//setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		int windowWidth = GRPGParameters.WINDOW_WIDTH;
		if (windowWidth < 1024 || (windowWidth % 1024 != 0)) {
			throw new IllegalArgumentException("Non supported window size : " + windowWidth);
		}
		setPreferredSize(new Dimension(1024, 769));
		initLayout();
		initActions();	
	}
	
	/**
	 * 
	 */
	public void checkEndFight() {
		if ( ((Boolean)VariableRepository.getInstance().searchByName("characterInFight")) == false ) {
			VariableRepository.getInstance().removeByName("enemy_1");
			JPanel parent = (JPanel)getParent();
        	CardLayout layout = (CardLayout) parent.getLayout();
        	layout.previous(parent);
		}
	}
	
	/**
	 * 
	 */
	protected void initActions() {
		buttonAttack.addActionListener(new AttackAction());
		buttonDefense.addActionListener(new DefenseAction());
	}
	
	
	/**
	 * 
	 */
	private class AttackAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			try {
				((Fight) VariableRepository.getInstance().searchByName("fightManager")).inFight("a", textArea);
			} catch (IOException | InterruptedException e1) {
				e1.printStackTrace();
			}
			
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
				e1.printStackTrace();
			}
			*/
		}
	}
	
	
	/**
	 * 
	 */
	private class DefenseAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			try {
				((Fight) VariableRepository.getInstance().searchByName("fightManager")).inFight("d", textArea);
			} catch (IOException | InterruptedException e1) {
				e1.printStackTrace();
			}
			
			GUIDisplayHandler.updateProgressBarValue(healthBarPlayer, ((PlayersCharacter)VariableRepository.getInstance().searchByName("player1")).getHealth() );
			GUIDisplayHandler.updateProgressBarValue(healthBarOpponent, ((EnemyCharacter)VariableRepository.getInstance().searchByName("enemy_1")).getHealth() );
			
			GUIDisplayHandler.updateLabel(labelHealthBarPlayer, ( String.valueOf( ((PlayersCharacter)VariableRepository.getInstance().searchByName("player1")).getHealth() ) ) );
			GUIDisplayHandler.updateLabel(labelHealthBarPlayer, ( String.valueOf( ((EnemyCharacter)VariableRepository.getInstance().searchByName("enemy_1")).getHealth() ) ) );
			
			checkEndFight();
		}
	}
	
	
	/**
	 * 
	 */
	public void componentShown(ComponentEvent e) {
        // displayMessage(e.getComponent().getClass().getName() + " --- Shown");
		Fight fight = new Fight();
		VariableRepository.getInstance().register("fightManager", fight);
		fight.initFight(textArea);
		
		GUIDisplayHandler.updateProgressBarValue(healthBarPlayer, ((PlayersCharacter)VariableRepository.getInstance().searchByName("player1")).getHealth() );
		GUIDisplayHandler.updateProgressBarValue(healthBarOpponent, ((EnemyCharacter)VariableRepository.getInstance().searchByName("enemy_1")).getHealth() );
		
		GUIDisplayHandler.updateLabel(labelHealthBarPlayer, ( String.valueOf( ((PlayersCharacter)VariableRepository.getInstance().searchByName("player1")).getHealth() ) ) );
		GUIDisplayHandler.updateLabel(labelHealthBarPlayer, ( String.valueOf( ((EnemyCharacter)VariableRepository.getInstance().searchByName("enemy_1")).getHealth() ) ) );
    }
	
	/**
	 * 
	 */
	public void initLayout () {
		labelHealthBarPlayer = new JLabel("0");
		labelHealthBarPlayer.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelHealthBarPlayer.setBounds(962, 375, 39, 28);
		labelHealthBarPlayer.setComponentOrientation(getComponentOrientation());
		add(labelHealthBarPlayer);
		labelHealthBarPlayer.setLabelFor(healthBarPlayer);
		
		labelHealthBarOpponent = new JLabel("0");
		labelHealthBarOpponent.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelHealthBarOpponent.setBounds(23, 375, 39, 28);
		labelHealthBarOpponent.setComponentOrientation(getComponentOrientation());
		add(labelHealthBarOpponent);
		labelHealthBarOpponent.setLabelFor(healthBarOpponent);
		labelConnexionTitle = new JLabel("You are fighting an enemy.");
		labelConnexionTitle.setFont(new Font("Tahoma", Font.PLAIN, 38));
		labelConnexionTitle.setBounds(268, 22, 558, 76);
		add(labelConnexionTitle);
	

		buttonAttack = new JButton("Attack");
		buttonAttack.setBounds(438, 240, 114, 35);
		add(buttonAttack);
		
		buttonDefense = new JButton("Defense");
		buttonDefense.setBounds(438, 308, 114, 35);
		add(buttonDefense);
		
		healthBarPlayer = new JProgressBar(SwingConstants.VERTICAL);
		healthBarPlayer.setForeground(new Color(0, 153, 255));
		healthBarPlayer.setBackground(Color.LIGHT_GRAY);
		healthBarPlayer.setBounds(962, 375, 36, 200);
		add(healthBarPlayer);
		
		healthBarOpponent = new JProgressBar(SwingConstants.VERTICAL);
		healthBarOpponent.setForeground(new Color(0, 153, 255));
		healthBarOpponent.setBackground(Color.LIGHT_GRAY);
		healthBarOpponent.setBounds(23, 375, 36, 200);
		add(healthBarOpponent);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 604, 975, 154);
		add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
	}
	
	/**
	 * 
	 */
	/*public void paint(Graphics g) {
        super.paint(g);       
        Graphics2D g2 = (Graphics2D) g;
        Painter.drawBattleBackground(g2);
    }*/
	
	/**
	 * 
	 */
	public void reset() {
		
	}

	
	@Override
	public void componentHidden(ComponentEvent e) {
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		
	}

	@Override
	public void componentResized(ComponentEvent e) {
		
	}
}