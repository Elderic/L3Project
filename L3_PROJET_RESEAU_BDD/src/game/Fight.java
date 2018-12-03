package game;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.JTextArea;

import query.FightQuery;

import core.VariableRepository;
import data.VariableFactory;
import gui.GUIDisplayHandler;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class Fight {
	private EnemyCharacter enemy;
	private PlayersCharacter player;
	boolean enemyIsDefending;
	FightAbilities playerAbilities;	//A RECUP
	FightAbilities enemyAbilities;	//A RECUP
	int playerHealth;
	int enemyHealth;
	
	
	/**
	 * Create a Fight
	 */
	public Fight () {
		// Se garder la possibilit� de cr�er une collection de monstre si on veut mettre plsuieurs adversaires contre le joueur
		EnemyCharacter enemyMonster = (EnemyCharacter) VariableFactory.getInstance().createVariable("EnemyCharacter", "Cr�ature du Malin", 20, 3, 2);
		VariableRepository.getInstance().register("enemy_1", enemyMonster);
				
		this.enemy = (EnemyCharacter) VariableRepository.getInstance().searchByName("enemy_1");
		this.player = (PlayersCharacter) VariableRepository.getInstance().searchByName("player1");
		
		enemyIsDefending = false;
		playerAbilities = new FightAbilities(player.getAttack(), player.getDefense());
		System.out.println(player.getAttack());
					
		enemyAbilities = new FightAbilities(enemy.getAttack(), enemy.getDefense());
		
		playerHealth = player.getHealth();
		enemyHealth = enemy.getHealth();
		System.out.println("fight: player: "+player.getHealth()+"|"+player.getAttack()+"|"+player.getDefense());
		System.out.println("fight: ennemi attack: "+enemy.getAttack()+" defense "+enemy.getDefense());
		System.out.println("fight: ennemi rarity: "+enemy.getRarity()+" type "+enemy.getType());
	}
	
	
	/**
	 * Start the fight
	 * 
	 * @param textArea
	 */
	public void initFight(JTextArea textArea) {
		/*IA A FAIRE
		
		int playerHealth = 20;	//A RECUP
		int enemyHealth = 20;	//A RECUP
		FightAbilities playerAbilities = new FightAbilities(4, 2);	//A RECUP
		FightAbilities enemyAbilities = new FightAbilities(3, 5);	//A RECUP
		*/
		GUIDisplayHandler.displayAppendOnTextArea(textArea, "Let's fight !");
		GUIDisplayHandler.displayAppendOnTextArea(textArea, "Choose if you want to attack the enemy or defense your-selft.");
	}
	
	/**
	 * Manage the fight
	 * 
	 * @param parameter
	 * @param textArea
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void inFight(String parameter, JTextArea textArea) throws IOException, InterruptedException {
		if (playerHealth > 0 && enemyHealth > 0) {
			
			int random = (int) (Math.random()*100);
			if(random<50) {
				enemyIsDefending = true;
				GUIDisplayHandler.displayAppendOnTextArea(textArea, "The enemy defends his-self!");
			}
			else {
				enemyIsDefending = false;
				GUIDisplayHandler.displayAppendOnTextArea(textArea, "The enemy attack you!");
			}
			 
			if(parameter.equals("a")) {
				GUIDisplayHandler.displayAppendOnTextArea(textArea, "You attacked the enemy.");
				
				if(enemyIsDefending) {
					int damage = playerAbilities.getAttack()-enemyAbilities.getDefense();
					if(damage>0) {
						enemyHealth -= damage;
						// this.enemy.setHealth(enemyHealth);
					}
				}
				else {
					int damageToEnemy = playerAbilities.getAttack();
					int damageToPlayer = enemyAbilities.getAttack();
					if(damageToEnemy>0) {
						enemyHealth -= damageToEnemy;
						// this.enemy.setHealth(enemyHealth);
					}
					if(damageToPlayer>0) {
						playerHealth -= damageToPlayer;
						// this.player.setHealth(playerHealth);
					}
				}
			}
			else if(parameter.contains("d")) {
				GUIDisplayHandler.displayAppendOnTextArea(textArea, "You defend your-self.");
				
				if(!enemyIsDefending) {
					int damage = enemyAbilities.getAttack()-playerAbilities.getDefense();
					if(damage>0) {
						playerHealth -= damage;
						// this.player.setHealth(playerHealth);
					}
				}
			}
			
			if ( enemyHealth <= 0 || playerHealth <= 0 ) {
				// VariableRepository.getInstance().modify("characterInFight", false);
				// VariableRepository.getInstance().searchByName("characterInFight")
				
				// VariableRepository.getInstance().removeByName("enemy_1");
				GUIDisplayHandler.displayAppendOnTextArea(textArea, "Fight is over !");
				if(playerHealth>=0) {
					//AJOUTER VICTOIRE + GENERER LOOT pour chaque loot > proposer au joueur de le porter ou non (remplace son stuff actuel)
					GUIDisplayHandler.displayAppendOnTextArea(textArea, "Congratulations, you won.");
					
/****************requete****************************/
					/*this.enemy = (EnemyCharacter) VariableRepository.getInstance().searchByName("enemy_1");
					Stuff resultQuery=FightQuery.endFightQuery("victory", 10, enemy.getRarity());					
					System.out.println(resultQuery.toString());
					GUIDisplayHandler.displayAppendOnTextArea(textArea,resultQuery.toString());
					Thread.sleep(3000);*/
					//afficher info loot sur panel
					VariableRepository.getInstance().register("characterInFight", false);
				}
				else {
					GUIDisplayHandler.displayAppendOnTextArea(textArea, "Badly, you loose.");
					
/****************requete****************************/
					/*this.enemy = (EnemyCharacter) VariableRepository.getInstance().searchByName("enemy_1");
					Stuff resultQuery=FightQuery.endFightQuery("defeat", 5, enemy.getRarity());
					GUIDisplayHandler.displayAppendOnTextArea(textArea,"perdu");
					Thread.sleep(3000);*/
					//resultQuery vaudra null, afficher message sur panel au joueur
					//REPLACER LE JOUEUR AU DEBUT DU JEU + MALUS ?
					VariableRepository.getInstance().register("characterInFight", false);
				}
				
			}
			else {
				GUIDisplayHandler.displayAppendOnTextArea(textArea, "Your health: " + playerHealth + ". Enemy health: " + enemyHealth);
			}
			
		}
	}
	
	/**
	 * Get the enemy of the fight
	 * 
	 * @return the enemy
	 */
	public EnemyCharacter getEnemy() {
		return enemy;
	}
	
	/**
	 * Get the player of the fight
	 * 
	 * @return the player
	 */
	public PlayersCharacter getPlayer() {
		return player;
	}
	
	/**
	 * Set the enemy of the fight
	 * 
	 * @param enemy the enemy to set
	 */
	public void setEnemy(EnemyCharacter enemy) {
		this.enemy = enemy;
	}
	
	/**
	 * Set the player of the fight
	 * 
	 * @param player the player to set
	 */
	public void setPlayer(PlayersCharacter player) {
		this.player = player;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Fight [enemy=" + enemy + ", player=" + player + "]";
	}
}
