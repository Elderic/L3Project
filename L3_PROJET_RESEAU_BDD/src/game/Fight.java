/**
 * 
 */
package game;

import java.util.Scanner;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class Fight {
	private EnemyCharacter enemy;
	private PlayersCharacter player;
	
	
	public Fight() {
		boolean enemyIsDefending = false;	//IA A FAIRE
		int playerHealth = 20;	//A RECUP
		int enemyHealth = 20;	//A RECUP
		
		FightAbilities playerAbilities = new FightAbilities(4, 2);	//A RECUP
		FightAbilities enemyAbilities = new FightAbilities(3, 5);	//A RECUP
		
		System.out.println("Début du combat !");
		System.out.println("Veuillez choisir si vous souhaitez attaquer l'ennemi (a) ou vous défendre pendant le tour ennemi (d).");
		
		Scanner read = new Scanner(System.in);
		while(playerHealth>0 && enemyHealth>0) {
			String tmp = read.nextLine();
			
			int random = (int) (Math.random()*100);
			if(random<50) {
				enemyIsDefending = true;
				System.out.println("L'ennemi se défend");
			}
			else {
				enemyIsDefending = false;
				System.out.println("L'ennemi attaque");
			}
			
			
			/*
			 * Si ennemi defend & joueur attaque => degats = attaque - defense
			 * Si ennemi defend & joueur defend => RIEN
			 * Si ennemi attaque & joueur attaque => degats = attaque / degats = attaque
			 * Si ennemi attaque & joueur defend => degats = attaque - defense
			 */
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
		
		System.out.println("Combat terminé !");
		if(enemyHealth>=0) {
			System.out.println("Félicitation, vous avez gagné.");
			//AJOUTER VICTOIRE + GENERER LOOT
		}
		else {
			System.out.println("Dommage, vous avez perdu.");
			//REPLACER LE JOUEUR AU DEBUT DU JEU + MALUS ?
		}
	}
	
	
	
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
