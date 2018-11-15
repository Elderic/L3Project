/**
 * 
 */
package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Dimension;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class GUIRegister extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private static GUIRegister window = new GUIRegister();
	private JTextField txtIdentifiant;
	private JTextField txtAdresseEmail;
	private JPasswordField pwdMotDePasse;
	
	
	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		window.setVisible(true);
		window.setTitle("Inscription");
	}
	
	
	public GUIRegister() {
		setSize(new Dimension(300, 330));
		setPreferredSize(new Dimension(360, 300));
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblInscrivezvousPourJouer = new JLabel("Inscrivez-vous pour jouer !");
		lblInscrivezvousPourJouer.setBounds(75, 11, 167, 14);
		getContentPane().add(lblInscrivezvousPourJouer);
		
		JLabel lblIdentifiant = new JLabel("Identifiant");
		lblIdentifiant.setBounds(96, 48, 66, 14);
		getContentPane().add(lblIdentifiant);
		
		txtIdentifiant = new JTextField();
		txtIdentifiant.setBounds(93, 73, 101, 20);
		getContentPane().add(txtIdentifiant);
		txtIdentifiant.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setBounds(96, 113, 81, 14);
		getContentPane().add(lblMotDePasse);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(105, 261, 74, 23);
		getContentPane().add(btnValider);
		
		JLabel lblAdresseEmail = new JLabel("Adresse e-mail");
		lblAdresseEmail.setBounds(96, 186, 92, 14);
		getContentPane().add(lblAdresseEmail);
		
		txtAdresseEmail = new JTextField();
		txtAdresseEmail.setBounds(93, 211, 101, 20);
		getContentPane().add(txtAdresseEmail);
		txtAdresseEmail.setColumns(10);
		
		pwdMotDePasse = new JPasswordField();
		pwdMotDePasse.setBounds(96, 138, 98, 20);
		getContentPane().add(pwdMotDePasse);
	}
}
