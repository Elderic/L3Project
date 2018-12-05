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
		/*
		//On crée un Worker générique, cette fois
		SwingWorker sw = new SwingWorker<Integer, String>(){
			protected Integer doInBackground() throws Exception {
				Thread.sleep(3000);
				return 0;
			}

			public void done(){
				if(SwingUtilities.isEventDispatchThread()) {
					System.out.println("Dans l'EDT ! ");
				}
				try {
					//On utilise la méthode get() pour récupérer le résultat
					//de la méthode doInBackground()
					System.out.println("Traitement terminé au bout de "+get()+" fois !");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}   
		      
			//La méthode gérant les résultats intermédiaires
			public void process(List<String> list){
				for(String str : list)
					System.out.println(str);
				}
			};
	    //On lance le SwingWorker
	    sw.execute();
	    */
	}
	
	/**
	 * 
	 * 
	 * @param healthBar
	 * @param valueToDisplay
	 */
	public static void updateProgressBarValue(JProgressBar healthBar, int valueToDisplay) {
		//healthBar.setValue(valueToDisplay);
	}
	
	/**
	 * 
	 * 
	 * @param labelToUpdate
	 * @param toDisplay
	 */
	public static void updateLabel(JLabel labelToUpdate, String toDisplay) {
		//labelToUpdate.setText(toDisplay);
	}
}
