/**
 * 
 */
package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JRadioButton;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class GUICreateCharacter extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private static GUICreateCharacter window = new GUICreateCharacter();
	private JTextField txtNomDuPersonnage;
	
	
	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		window.setVisible(true);
		window.setTitle("Création du personnage");
	}
	
	
	public GUICreateCharacter() {
		setSize(new Dimension(350, 190));
		setPreferredSize(new Dimension(360, 300));
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(200, 46, 60, 14);
		getContentPane().add(lblGenre);
		
		JLabel lblNomDuPersonnage = new JLabel("Nom du personnage");
		lblNomDuPersonnage.setBounds(21, 46, 117, 14);
		getContentPane().add(lblNomDuPersonnage);
		
		JRadioButton rdbtnFeminin = new JRadioButton("Feminin");
		rdbtnFeminin.setBounds(200, 67, 109, 23);
		getContentPane().add(rdbtnFeminin);
		
		JRadioButton rdbtnMasculin = new JRadioButton("Masculin");
		rdbtnMasculin.setBounds(200, 93, 109, 23);
		getContentPane().add(rdbtnMasculin);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnFeminin);
		group.add(rdbtnMasculin);
		
		txtNomDuPersonnage = new JTextField();
		txtNomDuPersonnage.setBounds(21, 71, 132, 20);
		getContentPane().add(txtNomDuPersonnage);
		txtNomDuPersonnage.setColumns(10);
		
		JLabel lblCrezVotrePersonnage = new JLabel("Cr\u00E9ez votre personnage");
		lblCrezVotrePersonnage.setBounds(99, 11, 161, 14);
		getContentPane().add(lblCrezVotrePersonnage);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(124, 127, 89, 23);
		getContentPane().add(btnValider);
	}
}
