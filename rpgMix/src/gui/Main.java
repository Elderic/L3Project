package gui;

import java.awt.Color;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import core.VariableRepository;

import data.ClassFactory;
import panels.SigningUpPanel;

import panels.SigningInPanel;
import panels.MainScreenPanel;
import panels.PanelsContainer;

public class Main extends JFrame {

	private static final long serialVersionUID = 1101006957083345550L;
	private PanelsContainer panelsContainer;
	private MainScreenPanel mainScreenPanel;
	private SigningInPanel signingInPanel;
	private SigningUpPanel signingUpPanel;
	
	//to modify


	public Main() throws IllegalArgumentException, InterruptedException, LineUnavailableException, UnsupportedAudioFileException {
		super("RPG");
		try {
			panelsContainer = (PanelsContainer) ClassFactory.createPanel("PanelsContainer");
			mainScreenPanel = (MainScreenPanel) ClassFactory.createPanel("MainScreenPanel");
			signingInPanel = (SigningInPanel) ClassFactory.createPanel("SigningInPanel");
			signingUpPanel = (SigningUpPanel) ClassFactory.createPanel("SigningUpPanel");


			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		panelsContainer.addPanel(mainScreenPanel);
		panelsContainer.addPanel(signingInPanel);
		panelsContainer.addPanel(signingUpPanel);
	
		
		VariableRepository.getInstance();
		initLayout();	
	}

	private void initLayout() {
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);	
		getContentPane().add(panelsContainer);
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
	        
	         public void run() {
	        	 try {
	     			new Main();
	     		} catch (IllegalArgumentException e) {
	     			System.err.println(e.getMessage());
	     		} catch (InterruptedException e) {
	     			// TODO Auto-generated catch block
	     			System.err.println(e.getMessage());
	     			e.printStackTrace();
	     		} catch (LineUnavailableException e) {
	     			// TODO Auto-generated catch block
	     			e.printStackTrace();
	     		} catch (UnsupportedAudioFileException e) {
	     			// TODO Auto-generated catch block
	     			e.printStackTrace();
	     		}
	         }
	      });
	}
}