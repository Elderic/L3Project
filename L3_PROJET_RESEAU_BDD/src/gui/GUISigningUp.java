package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import query.SigningInUpQuery;
import javax.swing.JButton;


public class GUISigningUp extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextField loginField;
	private JPasswordField passwordField;
	private JPasswordField passwordField2;

	JLabel labelRegistrationTitle;	
	JLabel loginLabel;
	JLabel passwordLabel;
	JLabel passwordLabel2;
	JLabel errorEmptyField;
	JLabel errorPasswordField;
	JLabel subscriptionImpossibleField;

	JButton buttonSignUp;
	JButton buttonPrevious;
	boolean status;
	/**
	 * Create the panel.
	 */
	public GUISigningUp() {
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
	
	protected void initActions() {
		buttonSignUp.addActionListener(new ConnectAction());
		buttonPrevious.addActionListener(new PreviousAction());
	}
	
	private class ConnectAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			String password1=new String(passwordField.getPassword());
			String password2=new String(passwordField2.getPassword());
			subscriptionImpossibleField.setVisible(false);
			errorPasswordField.setVisible(false);
			errorEmptyField.setVisible(false);

			if(loginField.getText().length()>0 && passwordField.getPassword().length>0 && passwordField2.getPassword().length>0) {
				if(password1.equals(password2)) {
					System.out.println("password ok");
					try {
						status=SigningInUpQuery.signingInUpQuery("signingUp",loginField.getText(),password1);
						if(status){						
							System.out.println("acces a l'ecran suivant");
							PanelsContainer.getInstance().getCardLayout().next(PanelsContainer.getInstance());
						}
						else{ //connexion impossible
				//on ne prend pas encore en compte la raison de la non inscription(login deja pris, mdp pas au bon format etc)
							subscriptionImpossibleField.setVisible(true);
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				else {
					errorEmptyField.setVisible(false);
					errorPasswordField.setVisible(true);
				}
			}
			else {
				errorPasswordField.setVisible(false);
				errorEmptyField.setVisible(true);
			}
										
		}
	}
	
	private class PreviousAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			PanelsContainer.getInstance().getCardLayout().previous(PanelsContainer.getInstance());
			PanelsContainer.getInstance().getCardLayout().previous(PanelsContainer.getInstance());
		}
	}
	
		
	public void initLayout () {
		labelRegistrationTitle = new JLabel("Registration");
		labelRegistrationTitle.setFont(new Font("Tahoma", Font.PLAIN, 38));
		labelRegistrationTitle.setBounds(400, 22, 335, 76);
		add(labelRegistrationTitle);
		
		loginLabel = new JLabel("Login");
		loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginLabel.setBounds(350, 126, 335, 76);
		add(loginLabel);
				
		loginField = new JTextField();
		loginField.setBounds(400, 156, 135, 20);
		add(loginField);
		loginField.setColumns(10);
		
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordLabel.setBounds(320, 170, 335, 76);
		add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(400, 200, 135, 20);
		add(passwordField);
		passwordField.setColumns(10);
		
		
		passwordLabel2 = new JLabel("Confirm password");
		passwordLabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordLabel2.setBounds(260, 214, 335, 76);
		add(passwordLabel2);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(400, 244, 135, 20);
		add(passwordField2);
		passwordField.setColumns(10);
		
		buttonSignUp = new JButton("Sign Up");
		buttonSignUp.setBounds(400, 522, 114, 23);
		add(buttonSignUp);
		
		buttonPrevious = new JButton("Previous");
		buttonPrevious.setBounds(514, 522, 104, 23);
		add(buttonPrevious);
			
		
		errorEmptyField = new JLabel("One or several fields are uncomplete");
		errorEmptyField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		errorEmptyField.setForeground(Color.red);
		errorEmptyField.setBounds(400,300,304,100);
		errorEmptyField.setVisible(false);
		add(errorEmptyField);
		
		errorPasswordField = new JLabel("The passwords are not matching");
		errorPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		errorPasswordField.setForeground(Color.red);
		errorPasswordField.setBounds(400,300,304,100);
		errorPasswordField.setVisible(false);
		add(errorPasswordField);
		
		subscriptionImpossibleField = new JLabel("impossible to sign up");
		subscriptionImpossibleField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		subscriptionImpossibleField.setForeground(Color.red);
		subscriptionImpossibleField.setBounds(400,300,304,100);
		subscriptionImpossibleField.setVisible(false);
		add(subscriptionImpossibleField);
	}
}