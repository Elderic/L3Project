package gui;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class GUIDisplayHandler {
	public static void displayAppendOnTextArea(JTextArea textArea, String toDisplay) {
		textArea.append(toDisplay + "\n");
	}
	
	public static void updateProgressBarValue(JProgressBar healthBar, int valueToDisplay) {
		healthBar.setValue(valueToDisplay);
	}
	
	public static void updateLabel(JLabel labelToUpdate, String toDisplay) {
		labelToUpdate.setText(toDisplay);
	}
}
