package query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import core.GameVariableRepository;

public class FightQuery {
	
	public static boolean FightQuery() throws IOException, InterruptedException {
		Socket socket = null ;
		PrintWriter flux_sortie = null ;
		BufferedReader flux_entree = null ;
		String chaine ;
		
		try {
			// deuxieme argument : le numero de port que l'on contacte
			socket = new Socket ("127.0.0.1", 5000) ;
			flux_sortie = new PrintWriter (socket.getOutputStream (), true) ;
			flux_entree = new BufferedReader (new InputStreamReader (socket.getInputStream ())) ;
		} 
		catch (UnknownHostException e) {
			System.err.println ("Hote inconnu") ;
            closeConnection(flux_sortie,flux_entree,socket);
            return false;
		} 
	
        flux_sortie.println("fightSolo");
        // on lit ce qu'a envoye le serveur
        chaine = flux_entree.readLine () ;
        System.out.println ("Le serveur m'a repondu : " + chaine) ;
        if(chaine.equals("ready to receive player id")){

            flux_sortie.println (GameVariableRepository.getInstance().getPlayerId()) ;
            System.out.println("id envoyer");
            chaine = flux_entree.readLine () ;   
         }
            if(chaine.equals("sending player data")){
                System.out.println("we're about to receive the player data");  
                chaine = flux_entree.readLine () ;   
                System.out.println("here are the data "+chaine);  
                /**the data are organized like:
                 *name/health/attack/defense
                 *so we split the string using the separator "/"
                 *
                 **/
                String[] split=chaine.split("/");
                String name=split[0];
                String health=split[1];
                String attack=split[2];
                String defense=split[3];

                GameVariableRepository.getInstance().setPlayerName(name);
                GameVariableRepository.getInstance().setPlayerHealth(Integer.parseInt(health));
                GameVariableRepository.getInstance().setPlayerAttack(Integer.parseInt(attack));
                GameVariableRepository.getInstance().setPlayerDefense(Integer.parseInt(defense));
                //flux_sortie.println("next");
                chaine = flux_entree.readLine () ;   
                if(chaine.equals("sending enemy data")){
                    System.out.println("we're about to receive the enemy data");  
                    chaine = flux_entree.readLine () ;   
                    System.out.println("here are the data "+chaine);  
                    String[] splitEnemy=chaine.split("/");
                    String nameEnemy=splitEnemy[0];
                    String healthEnemy=splitEnemy[1];
                    String typeEnemy=splitEnemy[2];
                    String rarityEnemy=splitEnemy[3];
                    String attackEnemy=splitEnemy[4];
                    String defenseEnemy=splitEnemy[5];
                    //a stocker quelques part

                	System.out.println("info enemy:");

                    for(int i=0;i<=5;i++){
                    	System.out.println(splitEnemy[i]);
                    }
                    
                }
                else{
                	System.out.println("error");
                    System.out.println(chaine);
                    closeConnection(flux_sortie,flux_entree,socket);
                    return false;
                }
                
                closeConnection(flux_sortie,flux_entree,socket);

                return true;
            }
            else{
                System.out.println("error, no data retrieved");
                System.out.println(chaine);

                closeConnection(flux_sortie,flux_entree,socket);
                return false;
            }
        }
	public static boolean endFightQuery(String resultFight, int experienceWon, String rarity) throws IOException, InterruptedException {
		Socket socket = null ;
		PrintWriter flux_sortie = null ;
		BufferedReader flux_entree = null ;
		String chaine ;
		
		try {
			// deuxieme argument : le numero de port que l'on contacte
			//socket = new Socket ("192.168.1.30", 5000) ;
			socket = new Socket ("127.0.0.1", 5000) ;
			flux_sortie = new PrintWriter (socket.getOutputStream (), true) ;
			flux_entree = new BufferedReader (new InputStreamReader (socket.getInputStream ())) ;
		} 
		catch (UnknownHostException e) {
			System.err.println ("Hote inconnu") ;
            closeConnection(flux_sortie,flux_entree,socket);

            return false;
		} 
        flux_sortie.println("endFight");
        chaine = flux_entree.readLine () ;
        System.out.println ("Le serveur m'a repondu : " + chaine) ;
        if(chaine.equals("ready to update data")){
            System.out.println ("etape1") ;
        	flux_sortie.println(GameVariableRepository.getInstance().getPlayerId()) ;
            chaine = flux_entree.readLine () ;
            if(chaine.equals("id received")){
            	flux_sortie.println(experienceWon) ;
            	System.out.println("expe "+experienceWon);
                chaine = flux_entree.readLine () ;
                if(chaine.equals("experience received")){
                	flux_sortie.println(resultFight) ;//victory or defeat         	
                	System.out.println("result fight "+resultFight);
                	chaine = flux_entree.readLine () ;   
                	if(chaine.equals("result received")){
                    	flux_sortie.println(rarity) ;//common or elite or boss         	
                    	chaine = flux_entree.readLine () ;   
                    	if(chaine.equals("enemy rarity received")){
                    		System.out.println("ok rarity");
                        	chaine = flux_entree.readLine () ;   
                    		if(chaine.equals("update completed")){
                    			System.out.println("donnees updater, pret a recevoir loot");
                    			chaine = flux_entree.readLine();
                    			String[] splitLoot=chaine.split("/");
                    			String nameLoot=splitLoot[0];
                    			String typeLoot=splitLoot[1];
                    			String rarityLoot=splitLoot[2];
                    			String descriptionLoot=splitLoot[3];
                    			String attackLoot=splitLoot[4];
                    			String defenseLoot=splitLoot[5];
                    			//a stocker
                    			for(int i=0;i<6;i++){
                    				System.out.println(splitLoot[i]);
                    			}
                    			closeConnection(flux_sortie,flux_entree,socket);
                    			return true;
                    		}
                    		else {
                    			System.out.println("erreur update");
                    			closeConnection(flux_sortie,flux_entree,socket);
                    			return false;
                    		}  
                    	}
                	}
                }
            }
        }
        else{
            closeConnection(flux_sortie,flux_entree,socket);
        	return false;
        }
		return false;
	}
	
	public static void closeConnection(PrintWriter flux_sortie,BufferedReader flux_entree, Socket socket) throws IOException{
	 	flux_sortie.close () ;
        flux_entree.close () ;
        socket.close () ;
	}
}