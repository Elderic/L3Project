package panels;
import gui.GTParameters;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import query.SigningInUpQuery;
import core.GameVariableRepository;

public class CharacterCreationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nameField;

	private JComboBox genderChoice;
	private JLabel characterCreationLabel;	
	private JLabel nameLabel;
	private JLabel genderLabel;
	private JLabel errorEmptyFieldLabel;

	private JButton buttonPrevious;
	private JButton buttonCreate;

	private boolean status=false;

	/**
	 * Create the panel.
	 */
	public CharacterCreationPanel() {
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
	
	public String returnComboBoxValue(JComboBox comboBox) {
		String gender =null;
		if ( comboBox.getSelectedItem() == "Male" ) {
			gender = "male";
		}
		else if( comboBox.getSelectedItem() == "Female" )
			gender="female";
		return gender;
	}

	protected void initActions() {
		buttonPrevious.addActionListener(new PreviousAction());
		buttonCreate.addActionListener(new CreationAction());

	}
	
	private class CreationAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			errorEmptyFieldLabel.setVisible(false);
			if(nameField.getText().length()>0){
				String playerId=GameVariableRepository.getInstance().getPlayerId();
				String gender=returnComboBoxValue(genderChoice);
				String name=nameField.getText();
				try {
					boolean hasBeenCreated=SigningInUpQuery.characterCreation(playerId, gender, name);
					
					System.out.println("has been created: "+hasBeenCreated);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else{
				errorEmptyFieldLabel.setVisible(true);
			}
		}
	}
	private class PreviousAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			PanelsContainer.getInstance().getCardLayout().previous(PanelsContainer.getInstance());
		}
	}
	
		
	public void initLayout () {
		
		characterCreationLabel = new JLabel("Character Creation");
		characterCreationLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
		characterCreationLabel.setBounds(400, 22, 635, 76);
		add(characterCreationLabel);
		
		buttonPrevious = new JButton("Previous");
		buttonPrevious.setBounds(514, 522, 104, 23);
		add(buttonPrevious);
		
		buttonCreate = new JButton("Create");
		buttonCreate.setBounds(410, 522, 104, 23);
		add(buttonCreate);
		
		genderChoice = new JComboBox();
		genderChoice.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		genderChoice.setBounds(400, 326, 135, 20);
		add(genderChoice);
		
		genderLabel = new JLabel("Select the gender of your character");
		genderLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		genderLabel.setBounds(400, 250, 335, 76);
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
		errorEmptyFieldLabel.setBounds(400,350,304,100);
		errorEmptyFieldLabel.setForeground(Color.red);
		errorEmptyFieldLabel.setVisible(false);
		add(errorEmptyFieldLabel);
			
	}
}