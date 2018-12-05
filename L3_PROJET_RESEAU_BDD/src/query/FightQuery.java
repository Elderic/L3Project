package query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import game.EnemyCharacter;
import game.PlayersCharacter;
import game.PlayersStuff;
import game.Stuff;
import core.GameVariableRepository;
import core.VariableRepository;
import data.VariableFactory;

/**
 * @author TOULAIN Timothe
 *
 */
public class FightQuery {
	private static EnemyCharacter enemy;
	private static PlayersCharacter player;
	
	
	/**
	 * retrieve player and enemy data before the fight
	 * 
	 * @return true or false
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static boolean FightQuery() throws IOException, InterruptedException {
		
		Socket socket = null ;
		PrintWriter outputFlux = null ;
		BufferedReader inputFlux = null ;
		String chain ;
		
		try {
			// deuxieme argument : le numero de port que l'on contacte
			socket = new Socket ("127.0.0.1", 5000) ;
			outputFlux = new PrintWriter (socket.getOutputStream (), true) ;
			inputFlux = new BufferedReader (new InputStreamReader (socket.getInputStream ())) ;
		} 
		catch (UnknownHostException e) {
			System.err.println ("Unknown host") ;
            closeConnection(outputFlux,inputFlux,socket);
            return false;
		} 
	
        outputFlux.println("fightSolo");
        chain = inputFlux.readLine () ;
        System.out.println ("Server says: " + chain) ;
        if(chain.equals("ready to receive player id")){

            outputFlux.println (GameVariableRepository.getInstance().getPlayerId()) ;
        	//outputFlux.println("player00001");
        	
            System.out.println("id sent");
            chain = inputFlux.readLine () ;   
        }
        if(chain.equals("sending player data")){
			System.out.println("we're about to receive the player data");  
			chain = inputFlux.readLine () ;   
			System.out.println("here are the data "+chain);  
			/**the data are organized like:
			 *name/health/attack/defense
			 *so we split the string using the separator "/"
			 **/
			String[] split=chain.split("/");
			String name=split[0];
			String health=split[1];
			String attack=split[2];
			String defense=split[3];
			player= (PlayersCharacter) VariableRepository.getInstance().searchByName("player1");
			   // player.setName(name);
			player.setHealth(Integer.parseInt(health));
			player.setAttack(Integer.parseInt(attack));
			player.setDefense(Integer.parseInt(defense));
			
			chain = inputFlux.readLine () ;   
			if(chain.equals("sending enemy data")){
			    System.out.println("we're about to receive the enemy data");  
			    chain = inputFlux.readLine () ;   
			    System.out.println("here are the data "+chain);  
			    String[] splitEnemy=chain.split("/");
			    String nameEnemy=splitEnemy[0];
			    String healthEnemy=splitEnemy[1];
			    String typeEnemy=splitEnemy[2];
			    String rarityEnemy=splitEnemy[3];
			    String attackEnemy=splitEnemy[4];
			    String defenseEnemy=splitEnemy[5];
			                    
			    EnemyCharacter enemyMonster = (EnemyCharacter) VariableFactory.getInstance().createVariable("EnemyCharacter",nameEnemy, Integer.parseInt(healthEnemy),Integer.parseInt(attackEnemy),Integer.parseInt(defenseEnemy));
				VariableRepository.getInstance().register("enemy_1", enemyMonster);
				enemy = (EnemyCharacter) VariableRepository.getInstance().searchByName("enemy_1");
				enemy.setType(typeEnemy);
			    enemy.setRarity(rarityEnemy);
			    /*enemy.setName(name);
				enemy.setHealth(Integer.parseInt(healthEnemy));          
			    enemy.setAttack(Integer.parseInt(attackEnemy));
			    enemy.setDefense(Integer.parseInt(defenseEnemy));*/
			    
				System.out.println("enemy info:");
			
			    for(int i=0;i<=5;i++){
			    	System.out.println(splitEnemy[i]);
			    }   
			}
			else{
				System.out.println("error");
			    System.out.println(chain);
			    closeConnection(outputFlux,inputFlux,socket);
			    return false;
			}
			closeConnection(outputFlux,inputFlux,socket);
			return true;
        }
        else{
            System.out.println("error, no data retrieved");
            System.out.println(chain);
            closeConnection(outputFlux,inputFlux,socket);
            return false;
        }
   	}
	
	/**
	 * update player's stats and get his reward according to the result of the fight
	 * 
	 * @param resultFight
	 * @param experienceWon
	 * @param rarity
	 * 
	 * @return stuff or null
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static Stuff endFightQuery(String resultFight, int experienceWon, String rarity) throws IOException, InterruptedException {
		Socket socket = null ;
		PrintWriter outputFlux = null ;
		BufferedReader inputFlux = null ;
		String chain ;
		
		try {
			// deuxieme argument : le numero de port que l'on contacte
			socket = new Socket ("127.0.0.1", 5000) ;
			outputFlux = new PrintWriter (socket.getOutputStream (), true) ;
			inputFlux = new BufferedReader (new InputStreamReader (socket.getInputStream ())) ;
		} 
		catch (UnknownHostException e) {
			System.err.println ("Unknown host") ;
            closeConnection(outputFlux,inputFlux,socket);

            return null;
		} 
        outputFlux.println("endFight");
        chain = inputFlux.readLine () ;
        System.out.println ("Server says: " + chain) ;
        if(chain.equals("ready to update data")){
            System.out.println ("step1");
            System.out.println(GameVariableRepository.getInstance().getPlayerId());
           // GameVariableRepository.getInstance().setPlayerId("player00007");
        	outputFlux.println(GameVariableRepository.getInstance().getPlayerId()) ;
            //outputFlux.println("player00001");
            
            chain = inputFlux.readLine () ;
            if(chain.equals("id received")){
            	outputFlux.println(experienceWon) ;
            	System.out.println("expe "+experienceWon);
                chain = inputFlux.readLine () ;
                if(chain.equals("experience received")){
                	outputFlux.println(resultFight) ;//victory or defeat         	
                	System.out.println("result fight "+resultFight);
                	chain = inputFlux.readLine () ;   
                	if(chain.equals("result received")){
                    	outputFlux.println(rarity) ;//common or elite or boss         	
                    	chain = inputFlux.readLine () ;   
                    	if(chain.equals("enemy rarity received")){
                    		System.out.println("ok rarity");
                        	chain = inputFlux.readLine () ;   
                    		if(chain.equals("update completed")){
                    			if(resultFight.equals("victory")){
                    				System.out.println("data update, ready to receive loot");
                    				chain = inputFlux.readLine();
                    				String[] splitLoot=chain.split("/");
                    				String nameLoot=splitLoot[0];
                    				String typeLoot=splitLoot[1];
                    				String rarityLoot=splitLoot[2];
                    				String descriptionLoot=splitLoot[3];
                    				String attackLoot=splitLoot[4];
                    				String defenseLoot=splitLoot[5];
                    				
                    				Stuff stuff=new Stuff();
                    				stuff.setName(nameLoot);
                    				stuff.setType(typeLoot);
                    				stuff.setRarity(rarityLoot);
                    				stuff.setDescription(descriptionLoot);
                    				stuff.setAttack(Integer.parseInt(attackLoot));
                    				stuff.setDefense(Integer.parseInt(defenseLoot));
                    				lootManager(stuff);
                    				
                    				for(int i=0;i<6;i++){
                    					System.out.println(splitLoot[i]);
                    				}
                    				closeConnection(outputFlux,inputFlux,socket);
                        			return stuff;
                    			}
                    			else{
                					System.out.println("No loot");
                    				closeConnection(outputFlux,inputFlux,socket);
                        			return null;
                    			}
                    			
                    		}
                    		else {
                    			System.out.println("update error");
                    			closeConnection(outputFlux,inputFlux,socket);
                    			return null;
                    		}  
                    	}
                	}
                }
            }
        }
        else{
            closeConnection(outputFlux,inputFlux,socket);
        	return null;
        }
        closeConnection(outputFlux,inputFlux,socket);
		return null;
	}
	public static void lootManager(Stuff stuff){
		PlayersStuff playerStuff=new PlayersStuff();
		if(stuff.getType().equals("helmet")){
			playerStuff.setHelmet(stuff);
			System.out.println("managed helmet");
		}
		else if(stuff.getType().equals("breastplate")){
			playerStuff.setBreastplate(stuff);
			System.out.println("managed breastplate");
		}
		else if(stuff.getType().equals("leggings")){
			playerStuff.setLeggings(stuff);
			System.out.println("managed leggings");
		}
		else if(stuff.getType().equals("shoes")){
			playerStuff.setShoes(stuff);			
			System.out.println("managed shoes");
		}
		else if(stuff.getType().equals("armbands")){
			playerStuff.setArmbands(stuff);
			System.out.println("managed armbands");
		}
		else if(stuff.getType().equals("weapon")){
			playerStuff.setWeapon(stuff);
			System.out.println("managed weapon");
		}
	}
	
	/**
	 * close the connection with the server
	 * @param outputFlux
	 * @param inputFlux
	 * @param socket
	 * 
	 * @throws IOException
	 */
	public static void closeConnection(PrintWriter outputFlux, BufferedReader inputFlux, Socket socket) throws IOException{
	 	outputFlux.close () ;
        inputFlux.close () ;
        socket.close () ;
	}
}