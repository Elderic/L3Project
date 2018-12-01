/**
 * 
 */
package game;

import java.io.IOException;

import javax.swing.JTextArea;

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
	
	public Fight () {
		// Se garder la possibilitï¿½ de crï¿½er une collection de monstre si on veut mettre plsuieurs adversaires contre le joueur
		EnemyCharacter enemyMonster = (EnemyCharacter) VariableFactory.getInstance().createVariable("EnemyCharacter", "Créature du Malin", 20, 3, 2);
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
	
	public void initFight(JTextArea textArea) {
		//IA A FAIRE
		/*
		int playerHealth = 20;	//A RECUP
		int enemyHealth = 20;	//A RECUP
		FightAbilities playerAbilities = new FightAbilities(4, 2);	//A RECUP
		FightAbilities enemyAbilities = new FightAbilities(3, 5);	//A RECUP
		*/
		GUIDisplayHandler.displayAppendOnTextArea(textArea, "Dï¿½but du combat !");
		GUIDisplayHandler.displayAppendOnTextArea(textArea, "Veuillez choisir si vous souhaitez attaquer l'ennemi (a) ou vous dï¿½fendre pendant le tour ennemi (d).");
	}
	
	public void inFight(String parameter, JTextArea textArea) throws IOException, InterruptedException {
		// int playerHealth = player.getHealth();
		// int enemyHealth = enemy.getHealth();
		// Scanner read = new Scanner(System.in);
		if (playerHealth > 0 && enemyHealth > 0) {
			// String tmp = read.nextLine();
			
			int random = (int) (Math.random()*100);
			if(random<50) {
				enemyIsDefending = true;
				GUIDisplayHandler.displayAppendOnTextArea(textArea, "L'ennemi s'est dï¿½fendu !");
			}
			else {
				enemyIsDefending = false;
				GUIDisplayHandler.displayAppendOnTextArea(textArea, "L'ennemi attaque !");
			}	
			
			// Si ennemi defend & joueur attaque => degats = attaque - defense
			// Si ennemi defend & joueur defend => RIEN
			// Si ennemi attaque & joueur attaque => degats = attaque / degats = attaque
			// Si ennemi attaque & joueur defend => degats = attaque - defense
			 
			if(parameter.equals("a")) {
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
				if(!enemyIsDefending) {
					int damage = enemyAbilities.getAttack()-playerAbilities.getDefense();
					if(damage>0) {
						playerHealth -= damage;
						// this.player.setHealth(playerHealth);
					}
				}
			}
			else {
				System.out.println("Erreur, a ou d attendus !");
			}
				
			System.out.println("playerHealth = " + playerHealth + " enemyHealth = " + enemyHealth);
			
			if ( enemyHealth <= 0 || playerHealth <= 0 ) {
				// VariableRepository.getInstance().modify("characterInFight", false);
				// VariableRepository.getInstance().searchByName("characterInFight")
				VariableRepository.getInstance().register("characterInFight", false);
				// VariableRepository.getInstance().removeByName("enemy_1");
				System.out.println("Combat terminï¿½ !");
				if(enemyHealth>=0) {
					//AJOUTER VICTOIRE + GENERER LOOT pour chaque loot > proposer au joueur de le porter ou non (remplace son stuff actuel)
					System.out.println("Fï¿½licitation, vous avez gagnï¿½.");
					
/****************requete****************************/
					/*this.enemy = (EnemyCharacter) VariableRepository.getInstance().searchByName("enemy_1");
					Stuff resultQuery=FightQuery.endFightQuery("victory", 10, enemy.getRarity());					
					System.out.println(resultQuery.toString());*/
				}
				else {
					System.out.println("Dommage, vous avez perdu.");
					
/****************requete****************************/
					/*this.enemy = (EnemyCharacter) VariableRepository.getInstance().searchByName("enemy_1");
					Stuff resultQuery=FightQuery.endFightQuery("defeat", 5, enemy.getRarity());
					System.out.println(resultQuery.toString());*/

					//REPLACER LE JOUEUR AU DEBUT DU JEU + MALUS ?
				} 
			}
		}
	}
	
	/*
	 System.out.println("Combat terminï¿½ !");
		if(enemyHealth>=0) {
			System.out.println("Fï¿½licitation, vous avez gagnï¿½.");
			//AJOUTER VICTOIRE + GENERER LOOT pour chaque loot > proposer au joueur de le porter ou non (remplace son stuff actuel)
		}
		else {
			System.out.println("Dommage, vous avez perdu.");
			//REPLACER LE JOUEUR AU DEBUT DU JEU + MALUS ?
		} 
	 
	 */
	
	/*
	public void inFight() {
		boolean enemyIsDefending = false;	//IA A FAIRE
		int playerHealth = 20;	//A RECUP
		int enemyHealth = 20;	//A RECUP
		FightAbilities playerAbilities = new FightAbilities(4, 2);	//A RECUP
		FightAbilities enemyAbilities = new FightAbilities(3, 5);	//A RECUP
		
		
		System.out.println("Dï¿½but du combat !");
		System.out.println("Veuillez choisir si vous souhaitez attaquer l'ennemi (a) ou vous dï¿½fendre pendant le tour ennemi (d).");
		
		Scanner read = new Scanner(System.in);
		while(playerHealth>0 && enemyHealth>0) {
			String tmp = read.nextLine();
			
			int random = (int) (Math.random()*100);
			if(random<50) {
				enemyIsDefending = true;
				System.out.println("L'ennemi se dï¿½fend");
			}
			else {
				enemyIsDefending = false;
				System.out.println("L'ennemi attaque");
			}
			
			
			
			// Si ennemi defend & joueur attaque => degats = attaque - defense
			// Si ennemi defend & joueur defend => RIEN
			// Si ennemi attaque & joueur attaque => degats = attaque / degats = attaque
			// Si ennemi attaque & joueur defend => degats = attaque - defense
			 
			if(tmp.contains("a")) {
				if(enemyIsDefending) {
					int damage = playerAbilities.getAttack()-enemyAbilities.getDefense();
					if(damage>0) {
						enemyHealth -= damage;
					}
				}
				else {
					int damageToEnemy = playerAbilities.getAttack();
					int damageToPlayer = enemyAbilities.getAttack();
					if(damageToEnemy>0) {
						enemyHealth -= damageToEnemy;
					}
					if(damageToPlayer>0) {
						playerHealth -= damageToPlayer;
					}
				}
			}
			else if(tmp.contains("d")) {
				if(!enemyIsDefending) {
					int damage = enemyAbilities.getAttack()-playerAbilities.getDefense();
					if(damage>0) {
						playerHealth -= damage;
					}
				}
			}
			else {
				System.out.println("Erreur, a ou d attendus !");
			}
			
			
			System.out.println("playerHealth = " + playerHealth + " enemyHealth = " + enemyHealth);
			
		}
		read.close();
		
		System.out.println("Combat terminï¿½ !");
		if(enemyHealth>=0) {
			System.out.println("Fï¿½licitation, vous avez gagnï¿½.");
			//AJOUTER VICTOIRE + GENERER LOOT pour chaque loot > proposer au joueur de le porter ou non (remplace son stuff actuel)
		}
		else {
			System.out.println("Dommage, vous avez perdu.");
			//REPLACER LE JOUEUR AU DEBUT DU JEU + MALUS ?
		}
	}
	*/
	
	/**
	 * @return the enemy
	 */
	public EnemyCharacter getEnemy() {
		return enemy;
	}
	
	/**
	 * @return the player
	 */
	public PlayersCharacter getPlayer() {
		return player;
	}
	
	/**
	 * @param enemy the enemy to set
	 */
	public void setEnemy(EnemyCharacter enemy) {
		this.enemy = enemy;
	}
	
	/**
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
