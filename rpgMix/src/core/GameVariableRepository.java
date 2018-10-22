package core;

public class GameVariableRepository {
	
	// Varies from 0 to 2, each digits indicating a player. Will varies between the turns.
	private int playerTurn;
	
	
	private int playerAttack;
	private int playerDefense;
	private int playerHealth;
	private String playerName;
	private String playerId;


	private GameVariableRepository() {
	
		this.playerTurn = 0;
		this.playerAttack = 0;
		this.playerHealth = 0;
		this.playerDefense = 0;
		this.playerName = null;
		this.playerId = null;
	}
	
	static GameVariableRepository instance = new GameVariableRepository();
	
	public static GameVariableRepository getInstance() {
		return instance;
	}
	
	 public void setPlayerAttack(int attack){
		 this.playerAttack=attack;
	 }
	 public void setPlayerDefense(int defense){
		 this.playerDefense=defense;
	 }
	 public void setPlayerHealth(int health){
		 this.playerHealth=health;
	 }
	 public void setPlayerName(String name){
		 this.playerName=name;
	 }
	 public void setPlayerId(String id){
		 this.playerId=id;
	 }
	 
	 public int getPlayerAttack(){
		 return this.playerAttack;
	 }
	 public int getPlayerDefense(){
		 return this.playerDefense;
	 }
	 public int getPlayerHealth(){
		 return this.playerHealth;
	 }
	 public String getPlayerName(){
		 return this.playerName;
	 }
	 public String getPlayerId(){
		 return this.playerId;
	 }
	 
	 
	public int incrementPlayerTurn() {
		this.playerTurn++;
		if ( playerTurn >= 2 ) {
			this.playerTurn = 0;
		}
		return this.playerTurn;
	}
	
	public int getPlayerTurn() {
		return this.playerTurn;
	}
	
	
}