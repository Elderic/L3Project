package gui;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

/**
 * @author 
 *
 */
public class GUIDisplayHandler {
	/**
	 * 
	 * 
	 * @param textArea
	 * @param toDisplay
	 */
	public static void displayAppendOnTextArea(JTextArea textArea, String toDisplay) {
		textArea.append(toDisplay + "\n");
	}
	
	/**
	 * 
	 * 
	 * @param healthBar
	 * @param valueToDisplay
	 */
	public static void updateProgressBarValue(JProgressBar healthBar, int valueToDisplay) {
		healthBar.setValue(valueToDisplay);
	}
	
	/**
	 * 
	 * 
	 * @param labelToUpdate
	 * @param toDisplay
	 */
	public static void updateLabel(JLabel labelToUpdate, String toDisplay) {
		labelToUpdate.setText(toDisplay);
	}
}
