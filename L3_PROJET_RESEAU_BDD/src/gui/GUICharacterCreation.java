package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import query.SigningInUpQuery;
import core.GameVariableRepository;

/**
 * @author 
 *
 */
public class GUICharacterCreation extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextField nameField;
	private JComboBox<String> genderChoice;
	private JLabel characterCreationLabel;	
	private JLabel nameLabel;
	private JLabel genderLabel;
	private JLabel errorEmptyFieldLabel;

	private JButton buttonPrevious;
	private JButton buttonCreate;
	private JButton btnCharacter1;
	private JButton btnCharacter2;
	private JButton btnCharacter3;
	private JButton btnCharacter4;
	private JButton btnCharacter5;	
	private JButton btnCharacter6;

	private int nbCharacterChoosen=0;
	private String characterChoosen="";

	private boolean status=false;

	
	/**
	 * Create the panel.
	 */
	public GUICharacterCreation() {
		setBackground(Color.LIGHT_GRAY.darker());
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
	 * Get the ComboBox value
	 * 
	 * @param comboBox
	 * @return gender
	 */
	public String returnComboBoxValue(JComboBox<String> comboBox) {
		String gender =null;
		if ( comboBox.getSelectedItem() == "Male" ) {
			gender = "male";
		}
		else if( comboBox.getSelectedItem() == "Female" )
			gender="female";
		return gender;
	}

	/**
	 * 
	 */
	protected void initActions() {
		buttonPrevious.addActionListener(new PreviousAction());
		buttonCreate.addActionListener(new CreationAction());

	}
	
	
	/**
	 * 
	 */
	private class CreationAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			errorEmptyFieldLabel.setVisible(false);
			if(nameField.getText().length()>0 && nbCharacterChoosen==1){
				String playerId=GameVariableRepository.getInstance().getPlayerId();
				String gender=returnComboBoxValue(genderChoice);
				String name=nameField.getText();
				try {
					boolean hasBeenCreated=SigningInUpQuery.characterCreation(playerId, gender, name);
					
					System.out.println("has been created: "+hasBeenCreated);
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			else{
				errorEmptyFieldLabel.setVisible(true);
			}
		}
	}
	
	
	/**
	 * 
	 */
	private class PreviousAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			PanelsContainer.getInstance().getCardLayout().previous(PanelsContainer.getInstance());
		}
	}
	
	
	/**
	 * 
	 */
	public void initLayout () {
		characterCreationLabel = new JLabel("Character Creation");
		characterCreationLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
		characterCreationLabel.setBounds(400, 22, 635, 76);
		add(characterCreationLabel);
		
		buttonPrevious = new JButton("Previous");
		buttonPrevious.setBounds(514, 622, 104, 23);
		add(buttonPrevious);
		
		buttonCreate = new JButton("Create");
		buttonCreate.setBounds(410, 622, 104, 23);
		add(buttonCreate);
		
		genderChoice = new JComboBox<String>();
		genderChoice.setModel(new DefaultComboBoxModel<String>(new String[] {"Male", "Female"}));
		genderChoice.setBounds(400, 276, 135, 20);
		add(genderChoice);
		
		genderLabel = new JLabel("Select the gender of your character");
		genderLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		genderLabel.setBounds(400, 200, 335, 76);
		add(genderLabel);
		
		nameField = new JTextField();
		nameField.setBounds(400, 200, 135, 20);
		add(nameField);
		nameField.setColumns(10);
		
		nameLabel = new JLabel("Choose the name of your character");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nameLabel.setBounds(400, 124, 335, 76);
		add(nameLabel);	
		
		errorEmptyFieldLabel = new JLabel("One or several fields are uncomplete");
		errorEmptyFieldLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		errorEmptyFieldLabel.setBounds(400,450,304,100);
		errorEmptyFieldLabel.setForeground(Color.red);
		errorEmptyFieldLabel.setVisible(false);
		add(errorEmptyFieldLabel);
		
		ImageIcon icon1=new ImageIcon(new ImageIcon("character1.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
		ImageIcon icon2=new ImageIcon(new ImageIcon("character2.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
		ImageIcon icon3=new ImageIcon(new ImageIcon("character3.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
		ImageIcon icon4=new ImageIcon(new ImageIcon("character4.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
		ImageIcon icon5=new ImageIcon(new ImageIcon("character5.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
		ImageIcon icon6=new ImageIcon(new ImageIcon("character6.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
	
		btnCharacter1= new JButton();
		btnCharacter1.setBackground(Color.white);
		btnCharacter1.setIcon(icon1);
		btnCharacter1.setOpaque(false);
		btnCharacter1.setBounds(400, 320, 50, 50);
		add(btnCharacter1);
		
		btnCharacter2= new JButton();
		btnCharacter2.setBackground(Color.white);
		btnCharacter2.setOpaque(false);
		btnCharacter2.setIcon(icon2);
		btnCharacter2.setBounds(450, 320, 50, 50);
		add(btnCharacter2);
		
		btnCharacter3= new JButton();
		btnCharacter3.setBackground(Color.white);
		btnCharacter3.setIcon(icon3);
		btnCharacter3.setOpaque(false);
		btnCharacter3.setBounds(500, 320, 50, 50);
		add(btnCharacter3);
		
		btnCharacter4= new JButton();
		btnCharacter4.setBackground(Color.white);
		btnCharacter4.setIcon(icon4);
		btnCharacter4.setOpaque(false);
		btnCharacter4.setBounds(400, 370, 50, 50);
		add(btnCharacter4);
		
		btnCharacter5= new JButton();
		btnCharacter5.setBackground(Color.white);
		btnCharacter5.setIcon(icon5);
		btnCharacter5.setOpaque(false);
		btnCharacter5.setBounds(450, 370, 50, 50);
		add(btnCharacter5);
		
		btnCharacter6= new JButton();
		btnCharacter6.setBackground(Color.white);
		btnCharacter6.setIcon(icon6);
		btnCharacter6.setOpaque(false);
		btnCharacter6.setBounds(500, 370, 50, 50);
		add(btnCharacter6);
	
		btnCharacter1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nbCharacterChoosen!=1 && !characterChoosen.equals("character1")) {
					nbCharacterChoosen=1;
					characterChoosen="character1";
					btnCharacter1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
					System.out.println(nbCharacterChoosen+" "+characterChoosen);

				}
		 		else if(characterChoosen.equals("character1")) {
		 			characterChoosen="";
		 			nbCharacterChoosen=0;
					btnCharacter1.setBorder(BorderFactory.createLineBorder(Color.gray, 1));				
				}
			}
		});
		btnCharacter2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nbCharacterChoosen!=1 && !characterChoosen.equals("character2")) {
					nbCharacterChoosen=1;
					characterChoosen="character2";
					btnCharacter2.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
					System.out.println(nbCharacterChoosen+" "+characterChoosen);

				}
		 		else if(characterChoosen.equals("character2")) {
		 			characterChoosen="";
		 			nbCharacterChoosen=0;
					btnCharacter2.setBorder(BorderFactory.createLineBorder(Color.gray, 1));				
				}
			}
		});
		btnCharacter3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nbCharacterChoosen!=1 && !characterChoosen.equals("character3")) {
					nbCharacterChoosen=1;
					characterChoosen="character3";
					btnCharacter3.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
					System.out.println(nbCharacterChoosen+" "+characterChoosen);

				}
		 		else if(characterChoosen.equals("character3")) {
		 			characterChoosen="";
		 			nbCharacterChoosen=0;
					btnCharacter3.setBorder(BorderFactory.createLineBorder(Color.gray, 1));				
				}
			}
		});
		btnCharacter4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nbCharacterChoosen!=1 && !characterChoosen.equals("character4")) {
					nbCharacterChoosen=1;
					characterChoosen="character4";
					btnCharacter4.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
					System.out.println(nbCharacterChoosen+" "+characterChoosen);

				}
		 		else if(characterChoosen.equals("character4")) {
		 			characterChoosen="";
		 			nbCharacterChoosen=0;
					btnCharacter4.setBorder(BorderFactory.createLineBorder(Color.gray, 1));				
				}
			}
		});
		btnCharacter5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nbCharacterChoosen!=1 && !characterChoosen.equals("character5")) {
					nbCharacterChoosen=1;
					characterChoosen="character5";
					btnCharacter5.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
					System.out.println(nbCharacterChoosen+" "+characterChoosen);

				}
		 		else if(characterChoosen.equals("character5")) {
		 			characterChoosen="";
		 			nbCharacterChoosen=0;
					btnCharacter5.setBorder(BorderFactory.createLineBorder(Color.gray, 1));				
				}
			}
		});
		btnCharacter6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nbCharacterChoosen!=1 && !characterChoosen.equals("character6")) {
					nbCharacterChoosen=1;
					characterChoosen="character6";
					btnCharacter6.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
					System.out.println(nbCharacterChoosen+" "+characterChoosen);
				}
		 		else if(characterChoosen.equals("character6")) {
		 			characterChoosen="";
		 			nbCharacterChoosen=0;
					btnCharacter6.setBorder(BorderFactory.createLineBorder(Color.gray, 1));				
				}
			}
		});
	}
}