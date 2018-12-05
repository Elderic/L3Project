package gui;

import javax.swing.*;

import core.GameVariableRepository;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import query.SigningInUpQuery;

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
	private JLabel signingUpOkLabel;
	private JLabel errorSigningUpLabel;

	private JButton buttonCreate;
	
	/**
	 * Create the panel.
	 */
	public GUICharacterCreation() {
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
		buttonCreate.addActionListener(new CreationAction());

	}
	
	
	/**
	 * 
	 */
	private class CreationAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			errorEmptyFieldLabel.setVisible(false);
			if(nameField.getText().length()>0 ){
				String playerId=GameVariableRepository.getInstance().getPlayerId();
				String gender=returnComboBoxValue(genderChoice);
				String name=nameField.getText();
				try {
					boolean hasBeenCreated=SigningInUpQuery.characterCreation(playerId, gender, name);
					System.out.println("has been created: "+hasBeenCreated);
					if(hasBeenCreated==true){
						signingUpOkLabel.setVisible(true);
						buttonCreate.setEnabled(false);
					}
					else{
						errorSigningUpLabel.setVisible(true);
						buttonCreate.setEnabled(false);
					}
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
	
	
	
	/**
	 * 
	 */
	public void initLayout () {
		characterCreationLabel = new JLabel("Character Creation");
		characterCreationLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
		characterCreationLabel.setBounds(500, 22, 635, 76);
		add(characterCreationLabel);
		
		
		
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
		
		signingUpOkLabel = new JLabel("Signing up succesful, please restart the game");
		signingUpOkLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		signingUpOkLabel.setBounds(350,450,404,300);
		signingUpOkLabel.setForeground(Color.red);
		signingUpOkLabel.setVisible(false);
		add(signingUpOkLabel);
		
		errorSigningUpLabel = new JLabel("Impossible to sign up");
		errorSigningUpLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		errorSigningUpLabel.setBounds(400,450,304,100);
		errorSigningUpLabel.setForeground(Color.red);
		errorSigningUpLabel.setVisible(false);
		add(errorSigningUpLabel);
		
		
	
		
	}
}